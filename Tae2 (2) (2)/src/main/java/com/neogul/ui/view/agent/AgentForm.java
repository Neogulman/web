package com.neogul.ui.view.agent;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import com.neogul.data.dao.Device_Info_Dao;
import com.neogul.data.dto.Category;
import com.neogul.data.dto.Product;
import com.neogul.data.dto.TB_Device_Info;
import com.neogul.ui.util.Availability;
import com.neogul.ui.util.Status;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;

/**
 * A form for editing a single product.
 * <p>
 * Using responsive layouts, the form can be displayed either sliding out on the
 * side of the view or filling the whole screen - see the theme for the related
 * CSS rules.
 */
@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AgentForm extends AgentFormDesign {


    
    private AgentLogic viewLogic;
    private final FieldGroup fieldGroup = new FieldGroup();

   /* @Autowired
    private pDao pDao;*/
    
    @Autowired
    private Device_Info_Dao dDao;
    
    
    @SpringComponent
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public static class AgentFormFactory {

        @Autowired
        private ApplicationContext context;

        public AgentForm createForm(AgentLogic logic) {
        	AgentForm form = context.getBean(AgentForm.class);
            form.init(logic);
            return form;
        }
    }

    private static class StockPriceConverter extends StringToIntegerConverter {

        @Override
        protected NumberFormat getFormat(Locale locale) {
            // do not use a thousands separator, as HTML5 input type
            // number expects a fixed wire/DOM number format regardless
            // of how the browser presents it to the user (which could
            // depend on the browser locale)
            DecimalFormat format = new DecimalFormat();
            format.setMaximumFractionDigits(0);
            format.setDecimalSeparatorAlwaysShown(false);
            format.setParseIntegerOnly(true);
            format.setGroupingUsed(false);
            return format;
        }

        @Override
        public Integer convertToModel(String value, Class<? extends Integer> targetType, Locale locale) throws ConversionException {
            try {
                return super.convertToModel(value, Integer.class, locale);
            } catch (ConversionException e) {
                return 0;
            }
        }

    }

    private AgentForm() {
    }

    public void setCategories(List<TB_Device_Info> categories) {
    	Device_Info_Dao di = new Device_Info_Dao();
        status.setContainerDataSource(new BeanItemContainer<>(Availability.class, Arrays.asList(Availability.values())));
        //status.setContainerDataSource(categoryContainer);
    }

    public void editAgent(TB_Device_Info agent) {
       if (agent==null) {
        	agent = new TB_Device_Info();
       }
        
        add.setVisible(agent.getAgent_id().isEmpty());
        delete.setVisible(!agent.getAgent_id().isEmpty());
        save.setVisible(!agent.getAgent_id().isEmpty());
        block.setVisible(!agent.getStatus().equals("차단")&&!agent.getAgent_id().isEmpty());
        unblock.setVisible(agent.getStatus().equals("차단")&&!agent.getAgent_id().isEmpty());
        
        //if(agent.getAgent_id().isEmpty())
        	//status.addItems("접속중","정상","차단","반출중");
       
        fieldGroup.discard();
        fieldGroup.setItemDataSource(new BeanItem<>(agent));
        
        modify.setVisible(!agent.getAgent_id().isEmpty());
        
        modify.setVisible(false);
        block.setVisible(false);
        unblock.setVisible(false);
       
        //status.setEnabled(agent.getAgent_id().isEmpty());
        agent_id.setEnabled(agent.getAgent_id().isEmpty());
        pc_mac.setEnabled(agent.getAgent_id().isEmpty());
        pc_ip.setEnabled(agent.getAgent_id().isEmpty());
        install_day.setEnabled(agent.getAgent_id().isEmpty());
        connect_day.setEnabled(agent.getAgent_id().isEmpty());
        user_id.setEnabled(agent.getAgent_id().isEmpty());
        status.removeAllItems();
        status.addItems("접속중","정상","차단","반출중");
        fieldGroup.bind(status, "status");
        // Scroll to the top
        // As this is not a Panel, using JavaScript
        String scrollScript = "window.document.getElementById('" + getId()
                + "').scrollTop = 0;";
        Page.getCurrent().getJavaScript().execute(scrollScript);
    }

    @PostConstruct
    private void init() {
        addStyleName("product-form");

      
        //status.setContainerDataSource(new BeanItemContainer<>(TB_Device_Info.class, Arrays.asList(TB_Device_Info.)));
        //price.setConverter(new EuroConverter());
        //status.setContainerDataSource(new BeanItemContainer<>(Status.class, Arrays.asList(Status.values())));
        
        fieldGroup.bind(agent_id, "agent_id");
        fieldGroup.bind(nickname, "nickname");
        fieldGroup.bind(pc_mac, "pc_mac");
        fieldGroup.bind(pc_ip, "pc_ip");
        fieldGroup.bind(install_day, "install_day");
        fieldGroup.bind(connect_day, "connect_day");
        fieldGroup.bind(user_id, "user_id");
        fieldGroup.bind(status, "status");

        
        agent_id.addValidator(new StringLengthValidator("Agent ID must have at least two characters",2,1024,false));

        agent_id.setValidationVisible(false);
        agent_id.addValueChangeListener(e->{
        	if(!agent_id.isEmpty())
        		agent_id.setValidationVisible(true);
        	else
        		agent_id.setValidationVisible(false);
        });
        
        nickname.addValidator(new StringLengthValidator("Nickname must have at least two characters",2,1024,false));

        nickname.setValidationVisible(false);
        nickname.addValueChangeListener(e->{
        	if(!nickname.isEmpty())
        		nickname.setValidationVisible(true);
        	else
        		nickname.setValidationVisible(false);
        });
        
        modify.addClickListener(event->onModify());
        block.addClickListener(event->onBlock());
        unblock.addClickListener(event->onBlock());
        add.addClickListener(event -> onAdd());
        save.addClickListener(event -> onSave());
        cancel.addClickListener(event -> {
            fieldGroup.discard();
            viewLogic.cancelAgent();
        });
        delete.addClickListener(event -> onDelete());
        
        //contract_idx_str.setItemCaptionPropertyId("name");

        //fieldGroup.bind(contract_idx_str, "contract_idx_str");

//        fieldGroup.bind(stockCount, "stockCount");
//        stockCount.setConverter(new StockPriceConverter());
    }

    
    private void onAdd() {
        try {
            fieldGroup.commit();
            TB_Device_Info agent = ((BeanItem<TB_Device_Info>) fieldGroup.getItemDataSource()).getBean();
            
            if(agent.getStatus().equals("정상"))
    			agent.setStatus("Y");
    		else if(agent.getStatus().equals("접속중"))
    			agent.setStatus("S");
    		else if(agent.getStatus().equals("차단"))
    			agent.setStatus("B");
    		else if(agent.getStatus().equals("반출중"))
    			agent.setStatus("O");
            
            viewLogic.addAgent(agent);
        } catch (FieldGroup.CommitException e) {
            Logger.getGlobal().log(Level.INFO,"Commit error", e);
        }
    }
    
    private void onModify() {
        try {
            fieldGroup.commit();
            TB_Device_Info agent = ((BeanItem<TB_Device_Info>) fieldGroup.getItemDataSource()).getBean();
            viewLogic.modifyAgent(agent);
        } catch (FieldGroup.CommitException e) {
            Logger.getGlobal().log(Level.INFO,"Commit error", e);
        }
    }
    
    private void onBlock() {
        try {
            fieldGroup.commit();
            TB_Device_Info agent = ((BeanItem<TB_Device_Info>) fieldGroup.getItemDataSource()).getBean();
            
            if(agent.getStatus().equals("정상"))
    			agent.setStatus("B");
    		else if(agent.getStatus().equals("접속중"))
    			agent.setStatus("B");
    		else if(agent.getStatus().equals("차단"))
    			agent.setStatus("Y");
    		else if(agent.getStatus().equals("반출중"))
    			agent.setStatus("B");
            viewLogic.blockAgent(agent);
           
        } catch (FieldGroup.CommitException e) {
            Logger.getGlobal().log(Level.INFO,"Commit error", e);
        }
    }
    
    
    private void onSave() {
        try {
            fieldGroup.commit();
            TB_Device_Info agent = ((BeanItem<TB_Device_Info>) fieldGroup.getItemDataSource()).getBean();
//        We do not support saving data in this demo
//        pDao.updateProduct(product);
            
            if(agent.getStatus().equals("정상"))
    			agent.setStatus("Y");
    		else if(agent.getStatus().equals("접속중"))
    			agent.setStatus("S");
    		else if(agent.getStatus().equals("차단"))
    			agent.setStatus("B");
    		else if(agent.getStatus().equals("반출중"))
    			agent.setStatus("O");
            viewLogic.saveAgent(agent);
            
        } catch (FieldGroup.CommitException e) {
            Logger.getGlobal().log(Level.INFO,"Commit error", e);
        }
    }
    
    

    private void onDelete() {
        fieldGroup.discard();
        TB_Device_Info agent = ((BeanItem<TB_Device_Info>) fieldGroup.getItemDataSource()).getBean();
        if (agent != null) viewLogic.deleteAgent(agent);
    }

    private void init(AgentLogic logic) {
        this.viewLogic = logic;
    }

}