package com.neogul.ui.view.product;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.neogul.data.dao.Product_Dao;
import com.neogul.data.dto.TB_Product;
import com.neogul.ui.view.product.ProductForm.ProductFormFactory;
import com.neogul.ui.view.product.ProductLogic.ProductLogicFactory;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.Or;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name = ProductView.VIEW_NAME)
public class ProductView extends CssLayout implements View {

	public static final String VIEW_NAME = "상품 등록";
	private ProductGrid grid;

	@Autowired
	private ProductFormFactory formFactory;

	/*
	 * @Autowired private pDao pDao;
	 */
	//@Autowired
	//private ProductRepository pDao;

	@Autowired
	private Product_Dao pDao;
	
//	@Autowired
//	private productContainer productContainer;

	private ProductForm form;

	private ProductLogic viewLogic;
	private ComboBox Typecombo;
	private Button searchproduct;
	private Button newproduct;
	private BeanItemContainer<TB_Product> gridcontainer;
	@Autowired
	private ProductLogicFactory logicFactory;

	public HorizontalLayout createTopBar() {
		Typecombo = new ComboBox();
		searchproduct = new Button(FontAwesome.TIMES);
		
		Typecombo.addItems("전체","음식","인형","사무용품","음료");
		
		Typecombo.select("전체");
		Typecombo.setCaption("종류");
		Typecombo.setNullSelectionAllowed(false);
		Typecombo.setTextInputAllowed(false);
		TextField filter = new TextField();
		filter.setStyleName("filter-textfield");
		filter.setInputPrompt("상품명");
		filter.setImmediate(true);
		TB_Product di =new TB_Product();
		
		try {
			gridcontainer = new BeanItemContainer<>(TB_Product.class, pDao.fnList(di));
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			Typecombo.addValueChangeListener(e->{
				updateproduct();
				String filtercombo = (String) Typecombo.getValue();
				if (filtercombo == null || "".equals(filtercombo)||filtercombo.equals("전체")) {
					gridcontainer.removeAllContainerFilters();
				} else {
					gridcontainer
							.addContainerFilter(new Or(
									new SimpleStringFilter("type", filtercombo, true, false)));
				}
				grid.setContainerDataSource(gridcontainer);
			});
			
			//searchproduct.addClickListener(event -> {
			filter.addTextChangeListener(event -> {
			String filterText = (String) event.getText();
			//String filterText = filter.getValue();
			if (filterText == null || "".equals(filterText)) {
				gridcontainer.removeAllContainerFilters();
				if(!Typecombo.getValue().equals("전체"))
					gridcontainer.addContainerFilter(
						new SimpleStringFilter("type", (String) Typecombo.getValue(), true, false));
	
			} else {
					gridcontainer
							.addContainerFilter(new SimpleStringFilter("name", filterText, true, false));
				}
				grid.setContainerDataSource(gridcontainer);
			}

			);
			
			
			
			searchproduct.addClickListener(event ->{
				filter.clear();
				Typecombo.select("전체");
				updateproduct();
			});
		
		
		FormLayout Typeform = new FormLayout();
		FormLayout searchform = new FormLayout();
		Typecombo.setSizeUndefined();
		Typeform.addComponent(Typecombo);
		//Typeform.setWidth(50,UNITS_PIXELS);
		
		newproduct = new Button("상품 등록");
		newproduct.addStyleName(ValoTheme.BUTTON_PRIMARY);
		newproduct.setIcon(FontAwesome.PLUS_CIRCLE);
		newproduct.addClickListener(event -> viewLogic.newproduct());
		
		//newproduct.setVisible(false);
		
		HorizontalLayout topLayout = new HorizontalLayout();
		CssLayout searchlayout = new CssLayout();
		topLayout.setSpacing(true);
		searchlayout.addComponents(filter,searchproduct);
		topLayout.setWidth("100%");
		searchlayout.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		topLayout.addComponent(Typeform);
		
		searchlayout.setCaption("상품명 :");
		searchlayout.setSizeUndefined();
		searchform.setSizeUndefined();
		searchform.addComponent(searchlayout);
		searchform.setComponentAlignment(searchlayout, Alignment.MIDDLE_LEFT);
		
		topLayout.setSpacing(true);
		topLayout.addComponent(searchform);
		//topLayout.addComponent(searchproduct);
		topLayout.setSizeUndefined();
		topLayout.addComponent(newproduct);
		topLayout.setComponentAlignment(Typeform, Alignment.MIDDLE_LEFT);
		topLayout.setComponentAlignment(searchform, Alignment.MIDDLE_LEFT);
		topLayout.setComponentAlignment(newproduct, Alignment.MIDDLE_RIGHT);
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

	public void setNewproductEnabled(boolean enabled) {
		newproduct.setEnabled(enabled);
	}

	public void clearSelection() {
		grid.getSelectionModel().reset();
	}

	public void selectRow(TB_Product row) {
		((Grid.SelectionModel.Single) grid.getSelectionModel()).select(row.getBarcode());
	}

	public TB_Product getSelectedRow() {
		return grid.getSelectedRow();
	}

	public void editproduct(TB_Product product) {
		if (product != null) {
			form.addStyleName("visible");
			form.setEnabled(true);
		} else {
			form.removeStyleName("visible");
			// Issue #286
			// form.setEnabled(false);
		}
		form.editproduct(product);
	}

	public void updateproduct() {
		// We do not save anything to the backend in this demo
		//productContainer.addItem(product);
		//productContainer.insertItem(product);
		TB_Product di =new TB_Product();
		try {
			gridcontainer = new BeanItemContainer<>(TB_Product.class, pDao.fnList(di));
			grid.setContainerDataSource(gridcontainer);
			
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	public void removeproduct(TB_Product product) {
//		productContainer.removeItem(product);
//	}

	@PostConstruct
	private void init() {
		viewLogic = logicFactory.createLogic(this);

		setSizeFull();
		addStyleName("crud-view");
		HorizontalLayout topLayout = createTopBar();
		VerticalLayout toplabel = new VerticalLayout();
		Label label =new Label("product State");
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
			//grid.setContainerDataSource(productContainer);
			
			/*List<TB_Product> data = pDao.fnList(new TB_Product());
	        grid.setContainerDataSource(new BeanItemContainer<>(TB_Product.class, data));
			*/
	        //System.out.println(data.get(0).getproduct_id());
	        
			TB_Product di = new TB_Product();
			updateproduct();
			
			
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
			//form.setCategories(pDao.fnList(new TB_Product()).subList(0,3));
			addComponent(form);

			viewLogic.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

