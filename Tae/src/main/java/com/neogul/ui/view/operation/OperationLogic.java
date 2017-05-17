package com.neogul.ui.view.operation;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import com.neogul.data.dao.Device_Info_Dao;
import com.neogul.data.dao.Operation_Info_Dao;
import com.neogul.data.dao.ProductRepository;
import com.neogul.data.dto.Product;
import com.neogul.data.dto.TB_Device_Info;
import com.neogul.data.dto.TB_Operation_Info;
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
public class OperationLogic implements Serializable {

    private OperationView view;

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
    public static class OperationLogicFactory {

        @Autowired
        private ApplicationContext context;

        public OperationLogic createLogic(OperationView view) {
        	OperationLogic logic = context.getBean(OperationLogic.class);
            logic.init(view);
            return logic;
        }
    }

  /*  @Autowired
    private pDao pDao;*/
    @Autowired
    private Operation_Info_Dao pDao;

    private OperationLogic() {
    }

    public void init() {
        editOperation(null);
        // Hide and disable if not admin
//        if (!getAccessControl().isUserInRole("admin")) {
//            view.setNewProductEnabled(false);
//        }
    }

    public void cancelOperation() {
        setFragmentParameter("");
        view.clearSelection();
        view.editOperation(null);
        view.updateOperation();
    }

    /**
     * Update the fragment without causing navigator to change view
     */
    private void setFragmentParameter(String AgentId) {
        String fragmentParameter;
        if (AgentId == null || AgentId.isEmpty()) {
            fragmentParameter = "";
        } else {
            fragmentParameter = AgentId;
        }

        getPage().setUriFragment(
                "!" + OperationView.VIEW_NAME + "/" + fragmentParameter,
                false);
    }

    public void enter(String AgentId) {
        if (AgentId != null && !AgentId.isEmpty()) {
            if (AgentId.equals("new")) {
                newOperation();
            } else {
                // Ensure this is selected even if coming directly here from
                // login
                try {
                    int pid = Integer.parseInt(AgentId);
                    TB_Operation_Info agent = findOperation(AgentId);
                    view.selectRow(agent);
                } catch (NumberFormatException e) {
                }
            }
        }
    }

    private TB_Operation_Info findOperation(String agent_id) {
        try {
        	TB_Operation_Info di= new TB_Operation_Info();
        	di.setAgent_id(agent_id);
			return pDao.fnSelectOne(di);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    //추가 걍만든거
    public void addOperation(TB_Operation_Info operation) {
    	try {
			pDao.fnInsert(operation);
			view.showSaveNotification(operation.getAgent_name() + " ("
	                + operation.getAgent_id() + ") added");
	        view.clearSelection();
	        view.editOperation(null);
	        view.updateOperation();
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void modifyOperation(TB_Operation_Info operation) {
    	try {
			//pDao.fnUpdateNickName(operation);
			view.showSaveNotification(operation.getAgent_name() + " ("
	                + operation.getAgent_id() + ") nickname changed");
	        view.clearSelection();
	        view.editOperation(null);
	        view.updateOperation();
	        view.editOperation(operation);
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void blockOperation(TB_Operation_Info operation) {
    	try {
    		pDao.fnUpdateStatus(operation);
    		if(operation.getStatus().equals("B"))
    			view.showSaveNotification(operation.getAgent_name() + " ("
	                + operation.getAgent_id() + ") unblocked");
    		else
    			view.showSaveNotification(operation.getAgent_name() + " ("
    	                + operation.getAgent_id() + ") blocked");
	        view.clearSelection();
	        view.editOperation(null);
	        view.updateOperation();
	        if(operation.getStatus().equals("Y"))
	        	operation.setStatus("정상");
    		else if(operation.getStatus().equals("S"))
    			operation.setStatus("접속중");
    		else if(operation.getStatus().equals("B"))
    			operation.setStatus("차단");
    		else if(operation.getStatus().equals("O"))
    			operation.setStatus("반출중");
	        view.editOperation(operation);
    		
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void saveOperation(TB_Operation_Info operation) {
    	try {
			String[] sday = operation.getS_day().split(" ");
			String[] eday = operation.getE_day().split(" ");
			operation.setS_day(sday[0]+sday[1]+sday[2]+" "+sday[4]);
			operation.setE_day(eday[0]+eday[1]+eday[2]+" "+eday[4]);
			if(operation.getAsk_user_id().equals(null))
				pDao.fnInsert(operation);
			else
				pDao.fnUpdate(operation);
			
	        view.clearSelection();
	        view.editOperation(null);
	        view.updateOperation();
	        setFragmentParameter("");
	        view.showSaveNotification(operation.getAgent_name() + " ("
	                + operation.getAgent_id() + ") saved");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    public void deleteOperation(TB_Operation_Info operation) {
        try {
			pDao.fnDelete(operation);
			view.showSaveNotification(operation.getAgent_name() + " ("
	                + operation.getAgent_id() + ") removed");

	        view.clearSelection();
	        view.editOperation(null);
	        view.updateOperation();
	        //view.removeProduct(agent);
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void editOperation(TB_Operation_Info operation) {
        if (operation == null) {
            setFragmentParameter("");
        } else {
            setFragmentParameter(operation.getAgent_ip() + "");
        }
        view.editOperation(operation);
    }

    public void newOperation() {
        view.clearSelection();
        setFragmentParameter("new");
        view.editOperation(new TB_Operation_Info());
        
    }

    public void rowSelected(TB_Operation_Info operation) {
        if (getAccessControl().isUserInRole("admin")) {
        	view.updateOperation();
            view.editOperation(operation);
        }
    }

    private void init(OperationView view) {
        this.view = view;
    }
}