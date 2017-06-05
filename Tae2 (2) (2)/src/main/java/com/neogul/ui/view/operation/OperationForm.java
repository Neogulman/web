package com.neogul.ui.view.operation;

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

import com.neogul.data.dao.Operation_Info_Dao;
import com.neogul.data.dto.Category;
import com.neogul.data.dto.Product;
import com.neogul.data.dto.TB_Operation_Info;
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
public class OperationForm extends OperationFormDesign {


    
    private OperationLogic viewLogic;
    private final FieldGroup fieldGroup = new FieldGroup();

   /* @Autowired
    private pDao pDao;*/
    
    @Autowired
    private Operation_Info_Dao dDao;
    
    
    @SpringComponent
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public static class OperationFormFactory {

        @Autowired
        private ApplicationContext context;

        public OperationForm createForm(OperationLogic logic) {
        	OperationForm form = context.getBean(OperationForm.class);
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

    private OperationForm() {
    }

    public void editOperation(TB_Operation_Info operation) {
       if (operation==null) {
    	   operation = new TB_Operation_Info();
       }

        delete.setVisible(!operation.getAsk_user_id().isEmpty());
        //save.setVisible(!operation.getAgent_id().isEmpty());
        
        //if(agent.getAgent_id().isEmpty())
        	//status.addItems("접속중","정상","차단","반출중");
       
        fieldGroup.discard();
        fieldGroup.setItemDataSource(new BeanItem<>(operation));
        
       
       
        //status.setEnabled(agent.getAgent_id().isEmpty());
        //work_key.clear();
        work_key.setEnabled(operation.getAsk_user_id().isEmpty());
        ask_user_id.setEnabled(operation.getAsk_user_id().isEmpty());
        agent_id.setEnabled(operation.getAsk_user_id().isEmpty());
        work_name.setEnabled(operation.getAsk_user_id().isEmpty());
        agent_id.setEnabled(operation.getAsk_user_id().isEmpty());
        server_group.setEnabled(operation.getAsk_user_id().isEmpty());
        command_group.setEnabled(operation.getAsk_user_id().isEmpty());
        program_group.setEnabled(operation.getAsk_user_id().isEmpty());
        //s_day.setEnabled(operation.getAgent_id().isEmpty());
        //e_day.setEnabled(operation.getAgent_id().isEmpty());
        payment_user_id.setEnabled(operation.getAsk_user_id().isEmpty());
        //fieldGroup.bind(status, "status");
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
        fieldGroup.bind(work_key, "work_key");
        fieldGroup.bind(ask_user_id, "ask_user_id");
        fieldGroup.bind(work_name, "work_name");
        fieldGroup.bind(agent_id, "agent_id");
        fieldGroup.bind(server_group, "server_group");
        fieldGroup.bind(command_group, "command_group");
        fieldGroup.bind(program_group, "program_group");
        fieldGroup.bind(s_day, "s_day");
        fieldGroup.bind(e_day, "e_day");
        fieldGroup.bind(payment_user_id, "manager_id");
        
  
        ask_user_id.addValidator(new StringLengthValidator("Agent ID must have at least two characters",2,1024,false));

        ask_user_id.setValidationVisible(false);
        ask_user_id.addValueChangeListener(e->{
        	if(!ask_user_id.isEmpty())
        		ask_user_id.setValidationVisible(true);
        	else
        		ask_user_id.setValidationVisible(false);
        });
        
        agent_id.addValidator(new StringLengthValidator("Nickname must have at least two characters",2,1024,false));

        agent_id.setValidationVisible(false);
        agent_id.addValueChangeListener(e->{
        	if(!agent_id.isEmpty())
        		agent_id.setValidationVisible(true);
        	else
        		agent_id.setValidationVisible(false);
        });
        
        save.addClickListener(event -> onSave());
        cancel.addClickListener(event -> {
            fieldGroup.discard();
            viewLogic.cancelOperation();
            
        });
        delete.addClickListener(event -> onDelete());
        
        //contract_idx_str.setItemCaptionPropertyId("name");

        //fieldGroup.bind(contract_idx_str, "contract_idx_str");

//        fieldGroup.bind(stockCount, "stockCount");
//        stockCount.setConverter(new StockPriceConverter());
    }

    
  
    
    private void onSave() {
        try {
            fieldGroup.commit();
            TB_Operation_Info operation = ((BeanItem<TB_Operation_Info>) fieldGroup.getItemDataSource()).getBean();
//        We do not support saving data in this demo

            
//            if(operation.getStatus().equals("정상"))
//            	operation.setStatus("Y");
//    		else if(operation.getStatus().equals("접속중"))
//    			operation.setStatus("S");
//    		else if(operation.getStatus().equals("차단"))
//    			operation.setStatus("B");
//    		else if(operation.getStatus().equals("반출중"))
//    			operation.setStatus("O");
            
            viewLogic.saveOperation(operation);
            
       } catch (FieldGroup.CommitException e) {
           Logger.getGlobal().log(Level.INFO,"Commit error", e);
       }
    }
    
    

    private void onDelete() {
        fieldGroup.discard();
        TB_Operation_Info operation = ((BeanItem<TB_Operation_Info>) fieldGroup.getItemDataSource()).getBean();
        if (operation != null) viewLogic.deleteOperation(operation);
    }

    private void init(OperationLogic logic) {
        this.viewLogic = logic;
    }

}