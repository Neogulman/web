package com.joheul.ui.view.crud;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import com.joheul.data.dao.ProductRepository;
import com.joheul.data.dto.Product;
import com.joheul.ui.authentication.AccessControl;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.UI;

/**
 * This class provides an interface for the logical operations between the CRUD
 * view, its parts like the product editor form and the data source, including
 * fetching and saving products.
 *
 * Having this separate from the view makes it easier to test various parts of
 * the system separately, and to e.g. provide alternative views for the same
 * data.
 */
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
@SpringComponent
public class SampleCrudLogic implements Serializable {

    private SampleCrudView view;

    @Autowired
    private ApplicationContext applicationContext;

    private AccessControl getAccessControl()
    {
        return applicationContext.getBean(AccessControl.class);
    }

    private Page getPage()
    {
        return applicationContext.getBean(UI.class).getPage();
    }

    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @SpringComponent
    public static class SampleCrudLogicFactory {

        @Autowired
        private ApplicationContext context;

        public SampleCrudLogic createLogic(SampleCrudView view) {
            SampleCrudLogic logic = context.getBean(SampleCrudLogic.class);
            logic.init(view);
            return logic;
        }
    }

  /*  @Autowired
    private pDao pDao;*/
    @Autowired
    private ProductRepository pDao;

    private SampleCrudLogic() {
    }

    public void init() {
        editProduct(null);
        // Hide and disable if not admin
        if (!getAccessControl().isUserInRole("admin")) {
            view.setNewProductEnabled(false);
        }
    }

    public void cancelProduct() {
        setFragmentParameter("");
        view.clearSelection();
        view.editProduct(null);
    }

    /**
     * Update the fragment without causing navigator to change view
     */
    private void setFragmentParameter(String productId) {
        String fragmentParameter;
        if (productId == null || productId.isEmpty()) {
            fragmentParameter = "";
        } else {
            fragmentParameter = productId;
        }

        getPage().setUriFragment(
                "!" + SampleCrudView.VIEW_NAME + "/" + fragmentParameter,
                false);
    }

    public void enter(String productId) {
        if (productId != null && !productId.isEmpty()) {
            if (productId.equals("new")) {
                newProduct();
            } else {
                // Ensure this is selected even if coming directly here from
                // login
                try {
                    int pid = Integer.parseInt(productId);
                    Product product = findProduct(pid);
                    view.selectRow(product);
                } catch (NumberFormatException e) {
                }
            }
        }
    }

    private Product findProduct(int productId) {
        try {
			return pDao.getProduct(productId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

    public void saveProduct(Product product) {
        view.showSaveNotification(product.getProductName() + " ("
                + product.getId() + ") updated");
        view.clearSelection();
        view.editProduct(null);
        view.updateProduct(product);
        setFragmentParameter("");
    }

    public void deleteProduct(Product product) {
        try {
			pDao.deleteProduct(product.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.showSaveNotification(product.getProductName() + " ("
                + product.getId() + ") removed");

        view.clearSelection();
        view.editProduct(null);
        view.removeProduct(product);
        setFragmentParameter("");
    }

    public void editProduct(Product product) {
        if (product == null) {
            setFragmentParameter("");
        } else {
            setFragmentParameter(product.getId() + "");
        }
        view.editProduct(product);
    }

    public void newProduct() {
        view.clearSelection();
        setFragmentParameter("new");
        view.editProduct(new Product());
    }

    public void rowSelected(Product product) {
        if (getAccessControl().isUserInRole("admin")) {
            view.editProduct(product);
        }
    }

    private void init(SampleCrudView view) {
        this.view = view;
    }
}
