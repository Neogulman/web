package com.neogul.ui.view.reclist;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import com.neogul.data.dao.Reclist_Dao;
import com.neogul.data.dto.TB_Reclist;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringComponent;

/**
 * A form for editing a single product.
 * <p>
 * Using responsive layouts, the form can be displayed either sliding out on the
 * side of the view or filling the whole screen - see the theme for the related
 * CSS rules.
 */
@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ReclistForm extends ReclistFormDesign {


    
    private ReclistLogic viewLogic;
    private final FieldGroup fieldGroup = new FieldGroup();

   /* @Autowired
    private pDao pDao;*/
    
    @Autowired
    private Reclist_Dao dDao;
    
    
    @SpringComponent
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public static class ReclistFormFactory {

        @Autowired
        private ApplicationContext context;

        public ReclistForm createForm(ReclistLogic logic) {
        	ReclistForm form = context.getBean(ReclistForm.class);
            form.init(logic);
            return form;
        }
    }

  

    private ReclistForm() {
    }


    public void editproduct(TB_Reclist product) {
       if (product==null) {
        	product = new TB_Reclist();
       }
        
        add.setVisible(product.getName().equals(""));
        delete.setVisible(!product.getName().equals(""));
        save.setVisible(!product.getName().equals(""));

        //if(product.getBarcode()==0)
        	//type.addItems("접속중","정상","차단","반출중");
       
        fieldGroup.discard();
        fieldGroup.setItemDataSource(new BeanItem<>(product));
        

        //type.setEnabled(product.getBarcode()==0);
//        barcode.setEnabled(product.getBarcode()==0);
//        locationX.setEnabled(product.getBarcode()==0);
//        locationY.setEnabled(product.getBarcode()==0);
//        stock.setEnabled(product.getBarcode()==0);
//        salesvolume.setEnabled(product.getBarcode()==0);
//        type.setEnabled(product.getBarcode()==0);
        
        // Scroll to the top
        // As this is not a Panel, using JavaScript
        String scrollScript = "window.document.getElementById('" + getId()
                + "').scrollTop = 0;";
        Page.getCurrent().getJavaScript().execute(scrollScript);
    }

    @PostConstruct
    private void init() {
        addStyleName("product-form");

      
        //type.setContainerDataSource(new BeanItemContainer<>(TB_Reclist.class, Arrays.asList(TB_Reclist.)));
        //price.setConverter(new EuroConverter());
        //type.setContainerDataSource(new BeanItemContainer<>(type.class, Arrays.asList(type.values())));
        
        fieldGroup.bind(name, "name");
        fieldGroup.bind(price, "price");
        
        //barcode.addValidator(new StringLengthValidator("product ID must have at least two characters",2,1024,false));

        name.setValidationVisible(false);
        name.addValueChangeListener(e->{
        	if(!name.isEmpty())
        		name.setValidationVisible(true);
        	else
        		name.setValidationVisible(false);
        });
        
        //name.addValidator(new StringLengthValidator("name must have at least two characters",2,1024,false));

        name.setValidationVisible(false);
        name.addValueChangeListener(e->{
        	if(!name.isEmpty())
        		name.setValidationVisible(true);
        	else
        		name.setValidationVisible(false);
        });
        name.setCaption("상품명");
        price.setCaption("추천 점수");
        add.setCaption("등록");
        save.setCaption("수정");
        delete.setCaption("삭제");
        cancel.setCaption("취소");
        add.addClickListener(event -> onAdd());
        save.addClickListener(event -> onSave());
        cancel.addClickListener(event -> {
            fieldGroup.discard();
            viewLogic.cancelproduct();
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
            TB_Reclist product = ((BeanItem<TB_Reclist>) fieldGroup.getItemDataSource()).getBean();
            
            viewLogic.addproduct(product);
        } catch (FieldGroup.CommitException e) {
            Logger.getGlobal().log(Level.INFO,"Commit error", e);
        }
    }
    
    private void onModify() {
        try {
            fieldGroup.commit();
            TB_Reclist product = ((BeanItem<TB_Reclist>) fieldGroup.getItemDataSource()).getBean();
            viewLogic.modifyproduct(product);
        } catch (FieldGroup.CommitException e) {
            Logger.getGlobal().log(Level.INFO,"Commit error", e);
        }
    }
    
    private void onBlock() {
        try {
            fieldGroup.commit();
            TB_Reclist product = ((BeanItem<TB_Reclist>) fieldGroup.getItemDataSource()).getBean();
            
    
            viewLogic.blockproduct(product);
           
        } catch (FieldGroup.CommitException e) {
            Logger.getGlobal().log(Level.INFO,"Commit error", e);
        }
    }
    
    
    private void onSave() {
        try {
            fieldGroup.commit();
            TB_Reclist product = ((BeanItem<TB_Reclist>) fieldGroup.getItemDataSource()).getBean();
//        We do not support saving data in this demo
//        pDao.updateProduct(product);
            
        
            viewLogic.saveproduct(product);
            
        } catch (FieldGroup.CommitException e) {
            Logger.getGlobal().log(Level.INFO,"Commit error", e);
        }
    }
    
    

    private void onDelete() {
        fieldGroup.discard();
        TB_Reclist product = ((BeanItem<TB_Reclist>) fieldGroup.getItemDataSource()).getBean();
        if (product != null) viewLogic.deleteproduct(product);
    }

    private void init(ReclistLogic logic) {
        this.viewLogic = logic;
    }

}