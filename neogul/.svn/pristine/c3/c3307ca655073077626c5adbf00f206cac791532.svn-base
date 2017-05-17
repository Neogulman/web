package com.joheul.ui.view.agent;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import com.joheul.data.dao.Device_Info_Dao;
import com.joheul.data.dao.ProductRepository;
import com.joheul.data.dto.Product;
import com.joheul.data.dto.TB_Device_Info;
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
public class AgentLogic implements Serializable {

    private AgentView view;

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
    public static class AgentLogicFactory {

        @Autowired
        private ApplicationContext context;

        public AgentLogic createLogic(AgentView view) {
        	AgentLogic logic = context.getBean(AgentLogic.class);
            logic.init(view);
            return logic;
        }
    }

  /*  @Autowired
    private pDao pDao;*/
    @Autowired
    private Device_Info_Dao pDao;

    private AgentLogic() {
    }

    public void init() {
        editAgent(null);
        // Hide and disable if not admin
//        if (!getAccessControl().isUserInRole("admin")) {
//            view.setNewProductEnabled(false);
//        }
    }

    public void cancelAgent() {
        setFragmentParameter("");
        view.clearSelection();
        view.editAgent(null);
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
                "!" + AgentView.VIEW_NAME + "/" + fragmentParameter,
                false);
    }

    public void enter(String AgentId) {
        if (AgentId != null && !AgentId.isEmpty()) {
            if (AgentId.equals("new")) {
                newAgent();
            } else {
                // Ensure this is selected even if coming directly here from
                // login
                try {
                    int pid = Integer.parseInt(AgentId);
                    TB_Device_Info agent = findAgent(AgentId);
                    view.selectRow(agent);
                } catch (NumberFormatException e) {
                }
            }
        }
    }

    private TB_Device_Info findAgent(String agent_id) {
        try {
        	TB_Device_Info di= new TB_Device_Info();
        	di.setAgent_id(agent_id);
			return pDao.fnSelectOne(di);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    //추가 걍만든거
    public void addAgent(TB_Device_Info agent) {
    	try {
			pDao.fnInsert(agent);
			view.showSaveNotification(agent.getNickname() + " ("
	                + agent.getAgent_id() + ") added");
	        view.clearSelection();
	        view.editAgent(null);
	        view.updateAgent();
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void modifyAgent(TB_Device_Info agent) {
    	try {
			pDao.fnUpdateNickName(agent);
			view.showSaveNotification(agent.getNickname() + " ("
	                + agent.getAgent_id() + ") nickname changed");
	        view.clearSelection();
	        view.editAgent(null);
	        view.updateAgent();
	        view.editAgent(agent);
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void blockAgent(TB_Device_Info agent) {
    	try {
    		pDao.fnUpdateStatus(agent);
    		if(agent.getStatus().equals("B"))
    			view.showSaveNotification(agent.getNickname() + " ("
	                + agent.getAgent_id() + ") unblocked");
    		else
    			view.showSaveNotification(agent.getNickname() + " ("
    	                + agent.getAgent_id() + ") blocked");
	        view.clearSelection();
	        view.editAgent(null);
	        view.updateAgent();
	        if(agent.getStatus().equals("Y"))
    			agent.setStatus("정상");
    		else if(agent.getStatus().equals("S"))
    			agent.setStatus("접속중");
    		else if(agent.getStatus().equals("B"))
    			agent.setStatus("차단");
    		else if(agent.getStatus().equals("O"))
    			agent.setStatus("반출중");
	        view.editAgent(agent);
    		
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void saveAgent(TB_Device_Info agent) {
    	try {
    		view.showSaveNotification(agent.getNickname() + " ("
	                + agent.getAgent_id() + ") saved");
			pDao.fnUpdateNickName(agent);
			pDao.fnUpdateStatus(agent);
	        view.clearSelection();
	        view.editAgent(null);
	        view.updateAgent();
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    public void deleteAgent(TB_Device_Info agent) {
        try {
			pDao.fnDelete(agent);
			view.showSaveNotification(agent.getNickname() + " ("
	                + agent.getAgent_id() + ") removed");

	        view.clearSelection();
	        view.editAgent(null);
	        view.updateAgent();
	        //view.removeProduct(agent);
	        setFragmentParameter("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void editAgent(TB_Device_Info agent) {
        if (agent == null) {
            setFragmentParameter("");
        } else {
            setFragmentParameter(agent.getPc_ip() + "");
        }
        view.editAgent(agent);
    }

    public void newAgent() {
        view.clearSelection();
        setFragmentParameter("new");
        view.editAgent(new TB_Device_Info());
        
    }

    public void rowSelected(TB_Device_Info agent) {
        if (getAccessControl().isUserInRole("admin")) {
            view.editAgent(agent);
        }
    }

    private void init(AgentView view) {
        this.view = view;
    }
}