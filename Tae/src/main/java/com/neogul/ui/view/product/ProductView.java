package com.neogul.ui.view.product;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.neogul.data.dao.Device_Info_Dao;
import com.neogul.data.dao.ProductRepository;
import com.neogul.data.dto.Product;
import com.neogul.data.dto.TB_Device_Info;
import com.neogul.ui.view.product.ProductForm.ProductFormFactory;
import com.neogul.ui.view.product.ProductLogic.ProductLogicFactory;
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

@SpringView(name = ProductView.VIEW_NAME)
public class ProductView extends CssLayout implements View {

	public static final String VIEW_NAME = "상품 등록";
	private ProductGrid grid;

	@Autowired
	private AgentFormFactory formFactory;

	/*
	 * @Autowired private pDao pDao;
	 */
	//@Autowired
	//private ProductRepository pDao;

	@Autowired
	private Device_Info_Dao pDao;
	
//	@Autowired
//	private AgentContainer AgentContainer;

	private ProductForm form;

	private ProductLogic viewLogic;
	private ComboBox statuscombo;
	private Button searchAgent;
	private Button newAgent;
	private BeanItemContainer<TB_Device_Info> gridcontainer;
	@Autowired
	private AgentLogicFactory logicFactory;

	public HorizontalLayout createTopBar() {
		statuscombo = new ComboBox();
		searchAgent = new Button(FontAwesome.TIMES);
		
		statuscombo.addItems("전체","접속중","정상","차단","반출중");
		
		statuscombo.select("전체");
		statuscombo.setCaption("상태");
		statuscombo.setNullSelectionAllowed(false);
		statuscombo.setTextInputAllowed(false);
		TextField filter = new TextField();
		filter.setStyleName("filter-textfield");
		filter.setInputPrompt("USER ID");
		filter.setImmediate(true);
		TB_Device_Info di =new TB_Device_Info();
		
		try {
			gridcontainer = new BeanItemContainer<>(TB_Device_Info.class, pDao.fnList(di));
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			statuscombo.addValueChangeListener(e->{
				updateAgent();
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
							.addContainerFilter(new SimpleStringFilter("user_id", filterText, true, false));
				}
				grid.setContainerDataSource(gridcontainer);
			}

			);
			
			
			
			searchAgent.addClickListener(event ->{
				filter.clear();
				statuscombo.select("전체");
				updateAgent();
			});
		
		
		FormLayout statusform = new FormLayout();
		FormLayout searchform = new FormLayout();
		statuscombo.setSizeUndefined();
		statusform.addComponent(statuscombo);
		//statusform.setWidth(50,UNITS_PIXELS);
		
		newAgent = new Button("New Agent");
		newAgent.addStyleName(ValoTheme.BUTTON_PRIMARY);
		newAgent.setIcon(FontAwesome.PLUS_CIRCLE);
		newAgent.addClickListener(event -> viewLogic.newAgent());
		
		//newAgent.setVisible(false);
		
		HorizontalLayout topLayout = new HorizontalLayout();
		CssLayout searchlayout = new CssLayout();
		topLayout.setSpacing(true);
		searchlayout.addComponents(filter,searchAgent);
		topLayout.setWidth("100%");
		searchlayout.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		topLayout.addComponent(statusform);
		
		searchlayout.setCaption("USER ID :");
		searchlayout.setSizeUndefined();
		searchform.setSizeUndefined();
		searchform.addComponent(searchlayout);
		searchform.setComponentAlignment(searchlayout, Alignment.MIDDLE_LEFT);
		
		topLayout.setSpacing(true);
		topLayout.addComponent(searchform);
		//topLayout.addComponent(searchAgent);
		topLayout.setSizeUndefined();
		topLayout.addComponent(newAgent);
		topLayout.setComponentAlignment(statusform, Alignment.MIDDLE_LEFT);
		topLayout.setComponentAlignment(searchform, Alignment.MIDDLE_LEFT);
		topLayout.setComponentAlignment(newAgent, Alignment.MIDDLE_RIGHT);
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

	public void setNewAgentEnabled(boolean enabled) {
		newAgent.setEnabled(enabled);
	}

	public void clearSelection() {
		grid.getSelectionModel().reset();
	}

	public void selectRow(TB_Device_Info row) {
		((Grid.SelectionModel.Single) grid.getSelectionModel()).select(row.getAgent_id());
	}

	public TB_Device_Info getSelectedRow() {
		return grid.getSelectedRow();
	}

	public void editAgent(TB_Device_Info agent) {
		if (agent != null) {
			form.addStyleName("visible");
			form.setEnabled(true);
		} else {
			form.removeStyleName("visible");
			// Issue #286
			// form.setEnabled(false);
		}
		form.editAgent(agent);
	}

	public void updateAgent() {
		// We do not save anything to the backend in this demo
		//AgentContainer.addItem(agent);
		//AgentContainer.insertItem(agent);
		TB_Device_Info di =new TB_Device_Info();
		try {
			gridcontainer = new BeanItemContainer<>(TB_Device_Info.class, pDao.fnList(di));
			
			for(int i=0;i<gridcontainer.size();i++){
				if(gridcontainer.getIdByIndex(i).getStatus().equals("Y"))
					gridcontainer.getIdByIndex(i).setStatus("정상");
				else if(gridcontainer.getIdByIndex(i).getStatus().equals("S"))
					gridcontainer.getIdByIndex(i).setStatus("접속중");
				else if(gridcontainer.getIdByIndex(i).getStatus().equals("B"))
					gridcontainer.getIdByIndex(i).setStatus("차단");
				else if(gridcontainer.getIdByIndex(i).getStatus().equals("O"))
					gridcontainer.getIdByIndex(i).setStatus("반출중");
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

//	public void removeAgent(TB_Device_Info agent) {
//		AgentContainer.removeItem(agent);
//	}

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
			grid = new ProductGrid();
			grid.addSelectionListener(event -> viewLogic.rowSelected(grid.getSelectedRow()));
			//grid.setContainerDataSource(AgentContainer);
			
			/*List<TB_Device_Info> data = pDao.fnList(new TB_Device_Info());
	        grid.setContainerDataSource(new BeanItemContainer<>(TB_Device_Info.class, data));
			*/
	        //System.out.println(data.get(0).getAgent_id());
	        
			TB_Device_Info di = new TB_Device_Info();
			updateAgent();
			
			
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

