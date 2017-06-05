package com.neogul.ui.view.product;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import com.neogul.data.dao.Product_Dao;
import com.neogul.data.dto.TB_Product;
import com.neogul.ui.authentication.AccessControl;
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
public class ProductLogic implements Serializable {

    private ProductView view;

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
    public static class ProductLogicFactory {

        @Autowired
        private ApplicationContext context;

        public ProductLogic createLogic(ProductView view) {
        	ProductLogic logic = context.getBean(ProductLogic.class);
            logic.init(view);
            return logic;
        }
    }

  /*  @Autowired
    private pDao pDao;*/
    @Autowired
    private Product_Dao pDao;

    private ProductLogic() {
    }

    public void init() {
        editProduct(null);
        // Hide and disable if not admin
//        if (!getAccessControl().isUserInRole("admin")) {
//            view.setNewProductEnabled(false);
//        }
    }

    public void cancelproduct() {
        setFragmentParameter("");
        view.clearSelection();
        view.editproduct(null);
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
                "!" + ProductView.VIEW_NAME + "/" + fragmentParameter,
                false);
    }

    public void enter(String productId) {
        if (productId != null && !productId.isEmpty()) {
            if (productId.equals("new")) {
                newproduct();
            } else {
                // Ensure this is selected even if coming directly here from
                // login
                try {
                    int pid = Integer.parseInt(productId);
                    //TB_Product product = findproduct(productId);
                    //view.selectRow(product);
                } catch (NumberFormatException e) {
                }
            }
        }
    }

    private TB_Product findproduct(int product_id) {
        try {
        	TB_Product di= new TB_Product();
        	di.setBarcode(product_id);
			return pDao.fnSelectOne(di);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    //추가 걍만든거
    public void addproduct(TB_Product product) {
    	try {
			pDao.fnInsert(product);
			view.showSaveNotification(product.getName() + " ("
	                + product.getBarcode() + ") added");
	        view.clearSelection();
	        view.editproduct(null);
	        view.updateproduct();
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void modifyproduct(TB_Product product) {
    	try {
			pDao.fnUpdateNickName(product);
			view.showSaveNotification(product.getName() + " ("
	                + product.getBarcode() + ") nickname changed");
	        view.clearSelection();
	        view.editproduct(null);
	        view.updateproduct();
	        view.editproduct(product);
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void blockproduct(TB_Product product) {
    	try {
    		pDao.fnUpdateStatus(product);
    		if(product.getType().equals("B"))
    			view.showSaveNotification(product.getName() + " ("
	                + product.getBarcode() + ") unblocked");
    		else
    			view.showSaveNotification(product.getName() + " ("
    	                + product.getBarcode() + ") blocked");
	        view.clearSelection();
	        view.editproduct(null);
	        view.updateproduct();
	        if(product.getType().equals("Y"))
    			product.setType("정상");
    		else if(product.getType().equals("S"))
    			product.setType("접속중");
    		else if(product.getType().equals("B"))
    			product.setType("차단");
    		else if(product.getType().equals("O"))
    			product.setType("반출중");
	        view.editproduct(product);
    		
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void saveproduct(TB_Product product) {
    	try {
    		view.showSaveNotification(product.getName() + " ("
	                + product.getBarcode() + ") saved");
			pDao.fnUpdateNickName(product);
			pDao.fnUpdateStatus(product);
	        view.clearSelection();
	        view.editproduct(null);
	        view.updateproduct();
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    public void deleteproduct(TB_Product product) {
        try {
			pDao.fnDelete(product);
			view.showSaveNotification(product.getName() + " ("
	                + product.getBarcode() + ") removed");

	        view.clearSelection();
	        view.editproduct(null);
	        view.updateproduct();
	        //view.removeProduct(product);
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void editProduct(TB_Product product) {
        if (product == null) {
            setFragmentParameter("");
        } else {
            setFragmentParameter(product.getBarcode() + "");
        }
        view.editproduct(product);
    }

    public void newproduct() {
        view.clearSelection();
        setFragmentParameter("new");
        view.editproduct(new TB_Product());
        
    }

    public void rowSelected(TB_Product product) {
        if (getAccessControl().isUserInRole("admin")) {
            view.editproduct(product);
        }
    }

    private void init(ProductView view) {
        this.view = view;
    }
}