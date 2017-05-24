package com.neogul.ui.view.reclist;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import com.neogul.data.dao.Reclist_Dao;
import com.neogul.data.dto.TB_Reclist;
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
public class ReclistLogic implements Serializable {

    private ReclistView view;

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
    public static class ReclistLogicFactory {

        @Autowired
        private ApplicationContext context;

        public ReclistLogic createLogic(ReclistView view) {
        	ReclistLogic logic = context.getBean(ReclistLogic.class);
            logic.init(view);
            return logic;
        }
    }

  /*  @Autowired
    private pDao pDao;*/
    @Autowired
    private Reclist_Dao pDao;

    private ReclistLogic() {
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
                "!" + ReclistView.VIEW_NAME + "/" + fragmentParameter,
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
                    //TB_Reclist product = findproduct(productId);
                    //view.selectRow(product);
                } catch (NumberFormatException e) {
                }
            }
        }
    }

    private TB_Reclist findproduct(int product_id) {
        try {
        	TB_Reclist di= new TB_Reclist();
        	di.setPrice(product_id);
			return pDao.fnSelectOne(di);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    //추가 걍만든거
    public void addproduct(TB_Reclist product) {
    	try {
			pDao.fnInsert(product);
			view.showSaveNotification(product.getName() + " ("
	                + product.getPrice() + ") added");
	        view.clearSelection();
	        view.editproduct(null);
	        view.updateproduct();
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void modifyproduct(TB_Reclist product) {
    	try {
			pDao.fnUpdateNickName(product);
			view.showSaveNotification(product.getName() + " ("
	                + product.getPrice() + ") nickname changed");
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
    
    public void blockproduct(TB_Reclist product) {
    	
	    
    }
    
    public void saveproduct(TB_Reclist product) {
    	try {
    		view.showSaveNotification(product.getName() + " ("
	                + product.getPrice() + ") saved");
			
    		pDao.fnInsert(product);
	        view.clearSelection();
	        view.editproduct(null);
	        view.updateproduct();
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    public void deleteproduct(TB_Reclist product) {
        try {
			pDao.fnDelete(product);
			view.showSaveNotification(product.getName() + " ("
	                + product.getPrice() + ") removed");

	        view.clearSelection();
	        view.editproduct(null);
	        //view.updateproduct();
	        //view.removeProduct(product);
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void editProduct(TB_Reclist product) {
        if (product == null) {
            setFragmentParameter("");
        } else {
            setFragmentParameter(product.getName() + "");
        }
        view.editproduct(product);
    }

    public void newproduct() {
        view.clearSelection();
        setFragmentParameter("new");
        view.editproduct(new TB_Reclist());
        
    }

    public void rowSelected(TB_Reclist product) {
        if (getAccessControl().isUserInRole("admin")) {
            view.editproduct(product);
        }
    }

    private void init(ReclistView view) {
        this.view = view;
    }
}