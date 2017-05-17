package com.joheul.ui.view.operation;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.joheul.data.dao.Device_Info_Dao;
import com.joheul.data.dao.Operation_Info_Dao;
import com.joheul.data.dao.ProductRepository;
import com.joheul.data.dto.Product;
import com.joheul.data.dto.TB_Device_Info;
import com.joheul.data.dto.TB_Operation_Info;
import com.joheul.ui.view.operation.OperationForm.OperationFormFactory;
import com.joheul.ui.view.operation.OperationLogic.OperationLogicFactory;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.Or;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.Version;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Grid.SelectionModel;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name = OperationView.VIEW_NAME)
public class OperationView extends CssLayout implements View {

	public static final String VIEW_NAME = "Operation";
	private OperationGrid grid;

	@Autowired
	private OperationFormFactory formFactory;

	/*
	 * @Autowired private pDao pDao;
	 */
	//@Autowired
	//private ProductRepository pDao;

	@Autowired
	private Operation_Info_Dao pDao;
	
	@Autowired
	//private AgentContainer AgentContainer;

	private OperationForm form;

	private OperationLogic viewLogic;
	private ComboBox statuscombo;
	private Button searchOperation;
	private Button newOperation;
	private BeanItemContainer<TB_Operation_Info> gridcontainer;
	
	@Autowired
	private OperationLogicFactory logicFactory;

	public HorizontalLayout createTopBar() {
		statuscombo = new ComboBox();
		searchOperation = new Button(FontAwesome.TIMES);
		
		statuscombo.addItems("전체","결재중","승인","차단");
		
		statuscombo.select("전체");
		statuscombo.setCaption("결재 상태");
		statuscombo.setNullSelectionAllowed(false);
		statuscombo.setTextInputAllowed(false);
		TextField filter = new TextField();
		filter.setStyleName("filter-textfield");
		filter.setInputPrompt("작업명");
		filter.setImmediate(true);
		TB_Operation_Info di =new TB_Operation_Info();
		
		try {
			gridcontainer = new BeanItemContainer<>(TB_Operation_Info.class, pDao.fnList(di));
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			statuscombo.addValueChangeListener(e->{
				updateOperation();
				String filtercombo = (String) statuscombo.getValue();
				if (filtercombo == null || "".equals(filtercombo)||filtercombo.equals("전체")) {
					gridcontainer.removeAllContainerFilters();
				} else {
					gridcontainer
							.addContainerFilter(new Or(
									new SimpleStringFilter("status", filtercombo, true, false)));
				}
				grid.setContainerDataSource(gridcontainer);
			});
			
			//searchAgent.addClickListener(event -> {
			filter.addTextChangeListener(event -> {
			String filterText = (String) event.getText();
			//String filterText = filter.getValue();
			if (filterText == null || "".equals(filterText)) {
				gridcontainer.removeAllContainerFilters();
				if(!statuscombo.getValue().equals("전체"))
					gridcontainer.addContainerFilter(
						new SimpleStringFilter("status", (String) statuscombo.getValue(), true, false));
	
			} else {
					gridcontainer
							.addContainerFilter(new SimpleStringFilter("work_name", filterText, true, false));
				}
				grid.setContainerDataSource(gridcontainer);
			}

			);
			
			
			
			searchOperation.addClickListener(event ->{
				filter.clear();
				statuscombo.select("전체");
				updateOperation();
			});
		
		
		FormLayout statusform = new FormLayout();
		FormLayout searchform = new FormLayout();
		statuscombo.setSizeUndefined();
		statusform.addComponent(statuscombo);
		//statusform.setWidth(50,UNITS_PIXELS);
		
		newOperation = new Button("New Operation");
		newOperation.addStyleName(ValoTheme.BUTTON_PRIMARY);
		newOperation.setIcon(FontAwesome.PLUS_CIRCLE);
		newOperation.addClickListener(event -> viewLogic.newOperation());
		
		//newAgent.setVisible(false);
		
		HorizontalLayout topLayout = new HorizontalLayout();
		CssLayout searchlayout = new CssLayout();
		topLayout.setSpacing(true);
		searchlayout.addComponents(filter,searchOperation);
		topLayout.setWidth("100%");
		searchlayout.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		topLayout.addComponent(statusform);
		
		searchlayout.setCaption("작업명 :");
		searchlayout.setSizeUndefined();
		searchform.setSizeUndefined();
		searchform.addComponent(searchlayout);
		searchform.setComponentAlignment(searchlayout, Alignment.MIDDLE_LEFT);
		
		topLayout.setSpacing(true);
		topLayout.addComponent(searchform);
		//topLayout.addComponent(searchAgent);
		topLayout.setSizeUndefined();
		topLayout.addComponent(newOperation);
		topLayout.setComponentAlignment(statusform, Alignment.MIDDLE_LEFT);
		topLayout.setComponentAlignment(searchform, Alignment.MIDDLE_LEFT);
		topLayout.setComponentAlignment(newOperation, Alignment.MIDDLE_RIGHT);
		topLayout.setStyleName("top-bar");
		return topLayout;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		viewLogic.enter(event.getParameters());
	}

	public void showError(String msg) {
		Notification.show(msg, Type.ERROR_MESSAGE);
	}

	public void showSaveNotification(String msg) {
		Notification.show(msg, Type.TRAY_NOTIFICATION);
	}

	public void setNewOperationEnabled(boolean enabled) {
		newOperation.setEnabled(enabled);
	}

	public void clearSelection() {
		grid.getSelectionModel().reset();
	}

	public void selectRow(TB_Operation_Info row) {
		((Grid.SelectionModel.Single) grid.getSelectionModel()).select(row.getAgent_id());
	}

	public TB_Operation_Info getSelectedRow() {
		return grid.getSelectedRow();
	}

	public void editOperation(TB_Operation_Info operation) {
		if (operation != null) {
			form.addStyleName("visible");
			form.setEnabled(true);
			if(!operation.getS_day().equals(""))
	        {
	        	String[] sday = operation.getS_day().split("-");
	        	String[] eday = operation.getE_day().split("-");
	        	String[] sday2 = sday[2].split(" ");
	        	String[] eday2 = eday[2].split(" ");
	        	int a = Integer.parseInt(sday2[1].substring(0,2));
	        	
	        	if(a>12)
	        	{
	        		a=a-12;
	        		operation.setS_day(sday[0]+". "+sday[1]+". "+sday2[0]+" 오후 "+a+sday2[1].substring(2)+":00");
	        	}
	        	else if(a==0)
	        	{
	        		a=12;
	        		operation.setS_day(sday[0]+". "+sday[1]+". "+sday2[0]+" 오후 "+a+sday2[1].substring(2)+":00");
	        	}
	        	else
	        		operation.setS_day(sday[0]+". "+sday[1]+". "+sday2[0]+" 오전 "+sday2[1]+":00");
	        	
	        	int b = Integer.parseInt(eday2[1].substring(0,2));
	        	if(b>12)
	        	{
	        		b=b-12;
	        		operation.setE_day(eday[0]+". "+eday[1]+". "+eday2[0]+" 오후 "+b+eday2[1].substring(2)+":00");
	        	}
	        	else if(b==0)
	        	{
	        		b=12;
	        		operation.setE_day(eday[0]+". "+eday[1]+". "+eday2[0]+" 오후 "+b+eday2[1].substring(2)+":00");
	        	}
	        	else
	        		operation.setE_day(eday[0]+". "+eday[1]+". "+eday2[0]+" 오전 "+eday2[1]+":00");
	        	
	        }
		} else {
			form.removeStyleName("visible");
			// Issue #286
			// form.setEnabled(false);
		}
		
		form.editOperation(operation);
	}

	public void updateOperation() {
		// We do not save anything to the backend in this demo
		//AgentContainer.addItem(agent);
		//AgentContainer.insertItem(agent);
		TB_Operation_Info di =new TB_Operation_Info();
		try {
			gridcontainer = new BeanItemContainer<>(TB_Operation_Info.class, pDao.fnList(di));
			
			for(int i=0;i<gridcontainer.size();i++){
				if(gridcontainer.getIdByIndex(i).getStatus().equals("Y"))
					gridcontainer.getIdByIndex(i).setStatus("승인");
				else if(gridcontainer.getIdByIndex(i).getStatus().equals("S"))
					gridcontainer.getIdByIndex(i).setStatus("결재중");
				else if(gridcontainer.getIdByIndex(i).getStatus().equals("N"))
					gridcontainer.getIdByIndex(i).setStatus("차단");
			}
			grid.setContainerDataSource(gridcontainer);
			
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//public void removeAgent(TB_Device_Info agent) {
		//AgentContainer.removeItem(agent);
	//}

	@PostConstruct
	private void init() {
		viewLogic = logicFactory.createLogic(this);

		setSizeFull();
		addStyleName("crud-view");
		HorizontalLayout topLayout = createTopBar();
		VerticalLayout toplabel = new VerticalLayout();
		Label label =new Label("Agent State");
		Label label2 =new Label("Process Management / Current State");
		label.setStyleName(ValoTheme.LABEL_H1);
		label2.setStyleName(ValoTheme.LABEL_H3);
		toplabel.addComponents(label,label2);
		toplabel.setSizeUndefined();
		label.setSizeUndefined();
		label2.setSizeUndefined();
		label.setStyleName(ValoTheme.LABEL_NO_MARGIN,true);
		label.setStyleName(ValoTheme.LABEL_COLORED,true);
		label2.setStyleName(ValoTheme.LABEL_BOLD,true);
		
		try {
			grid = new OperationGrid();
			grid.addSelectionListener(event -> viewLogic.rowSelected(grid.getSelectedRow()));
			
			
			/*List<TB_Device_Info> data = pDao.fnList(new TB_Device_Info());
	        grid.setContainerDataSource(new BeanItemContainer<>(TB_Device_Info.class, data));
			*/
	        //System.out.println(data.get(0).getAgent_id());
	        
			TB_Operation_Info di = new TB_Operation_Info();
			updateOperation();
			
			
	        VerticalLayout barAndGridLayout = new VerticalLayout();
			//barAndGridLayout.addComponent(toplabel);
			barAndGridLayout.addComponent(topLayout);
			barAndGridLayout.addComponent(grid);
			barAndGridLayout.setMargin(true);
			barAndGridLayout.setSpacing(true);
			barAndGridLayout.setSizeFull();
			barAndGridLayout.setExpandRatio(grid, 1);
			barAndGridLayout.setStyleName("crud-main-layout");

			addComponent(barAndGridLayout);

			form = formFactory.createForm(viewLogic);
			//form.setCategories(pDao.fnList(new TB_Device_Info()).subList(0,3));
			addComponent(form);

			viewLogic.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
