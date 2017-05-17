package com.joheul.ui.view.crud;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.joheul.data.dao.ProductRepository;
import com.joheul.data.dto.Product;
import com.joheul.ui.view.crud.ProductForm.ProductFormFactory;
import com.joheul.ui.view.crud.SampleCrudLogic.SampleCrudLogicFactory;
import com.vaadin.data.util.filter.Or;
import com.vaadin.data.util.filter.SimpleStringFilter;
//import com.vaadin.framework7.samples.backend.pDao;
//import com.vaadin.framework7.samples.backend.data.Product;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * A view for performing create-read-update-delete operations on products.
 * <p>
 * See also {@link SampleCrudLogic} for fetching the data, the actual CRUD
 * operations and controlling the view based on events from outside.
 */
@SpringView(name = SampleCrudView.VIEW_NAME)
public class SampleCrudView extends CssLayout implements View {

	public static final String VIEW_NAME = "Inventory";
	private ProductGrid grid;

	@Autowired
	private ProductFormFactory formFactory;

	/*
	 * @Autowired private pDao pDao;
	 */
	@Autowired
	private ProductRepository pDao;

	@Autowired
	private ProductContainer productContainer;

	private ProductForm form;

	private SampleCrudLogic viewLogic;
	private Button newProduct;

	@Autowired
	private SampleCrudLogicFactory logicFactory;

	public HorizontalLayout createTopBar() {
		TextField filter = new TextField();
		filter.setStyleName("filter-textfield");
		filter.setInputPrompt("Filter");
		filter.setImmediate(true);

		filter.addValueChangeListener(event -> {
			String filterText = (String) event.getProperty().getValue();
			if (filterText == null || "".equals(filterText)) {
				productContainer.removeAllContainerFilters();
			} else {
				productContainer
						.addContainerFilter(new Or(new SimpleStringFilter("productName", filterText, true, false),
								new SimpleStringFilter("availability", filterText, true, false),
								new SimpleStringFilter("category", filterText, true, false)));
			}
		}

		);

		newProduct = new Button("New product");
		newProduct.addStyleName(ValoTheme.BUTTON_PRIMARY);
		newProduct.setIcon(FontAwesome.PLUS_CIRCLE);
		newProduct.addClickListener(event -> viewLogic.newProduct());

		HorizontalLayout topLayout = new HorizontalLayout();
		topLayout.setSpacing(true);
		topLayout.setWidth("100%");
		topLayout.addComponent(filter);
		topLayout.addComponent(newProduct);
		topLayout.setComponentAlignment(filter, Alignment.MIDDLE_LEFT);
		topLayout.setExpandRatio(filter, 1);
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

	public void setNewProductEnabled(boolean enabled) {
		newProduct.setEnabled(enabled);
	}

	public void clearSelection() {
		grid.getSelectionModel().reset();
	}

	public void selectRow(Product row) {
		((Grid.SelectionModel.Single) grid.getSelectionModel()).select(row.getId());
	}

	public Product getSelectedRow() {
		return grid.getSelectedRow();
	}

	public void editProduct(Product product) {
		if (product != null) {
			form.addStyleName("visible");
			form.setEnabled(true);
		} else {
			form.removeStyleName("visible");
			// Issue #286
			// form.setEnabled(false);
		}
		form.editProduct(product);
	}

	public void updateProduct(Product product) {
		// We do not save anything to the backend in this demo
	}

	public void removeProduct(Product product) {
		productContainer.removeItem(product.getId());
	}

	@PostConstruct
	private void init() {
		viewLogic = logicFactory.createLogic(this);

		setSizeFull();
		addStyleName("crud-view");
		HorizontalLayout topLayout = createTopBar();
		try {
			grid = new ProductGrid();
			grid.addSelectionListener(event -> viewLogic.rowSelected(grid.getSelectedRow()));
			grid.setContainerDataSource(productContainer);

			VerticalLayout barAndGridLayout = new VerticalLayout();
			barAndGridLayout.addComponent(topLayout);
			barAndGridLayout.addComponent(grid);
			barAndGridLayout.setMargin(true);
			barAndGridLayout.setSpacing(true);
			barAndGridLayout.setSizeFull();
			barAndGridLayout.setExpandRatio(grid, 1);
			barAndGridLayout.setStyleName("crud-main-layout");

			addComponent(barAndGridLayout);

			form = formFactory.createForm(viewLogic);

			form.setCategories(pDao.getAllCategories());
			addComponent(form);

			viewLogic.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
