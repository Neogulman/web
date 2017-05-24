package com.neogul.ui.view.product;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import com.neogul.data.dao.Product_Dao;
import com.neogul.data.dto.TB_Product;
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
public class ProductForm extends ProductFormDesign {


    
    private ProductLogic viewLogic;
    private final FieldGroup fieldGroup = new FieldGroup();

   /* @Autowired
    private pDao pDao;*/
    
    @Autowired
    private Product_Dao dDao;
    
    
    @SpringComponent
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public static class ProductFormFactory {

        @Autowired
        private ApplicationContext context;

        public ProductForm createForm(ProductLogic logic) {
        	ProductForm form = context.getBean(ProductForm.class);
            form.init(logic);
            return form;
        }
    }

  

    private ProductForm() {
    }


    public void editproduct(TB_Product product) {
       if (product==null) {
        	product = new TB_Product();
       }
        
        add.setVisible(product.getBarcode()==0);
        delete.setVisible(product.getBarcode()!=0);
        save.setVisible(product.getBarcode()!=0);
        block.setVisible(!product.getType().equals("차단")&&product.getBarcode()!=0);
        unblock.setVisible(product.getType().equals("차단")&&product.getBarcode()!=0);
        
        //if(product.getBarcode()==0)
        	//type.addItems("접속중","정상","차단","반출중");
       
        fieldGroup.discard();
        fieldGroup.setItemDataSource(new BeanItem<>(product));
        
        modify.setVisible(product.getBarcode()!=0);
        
        modify.setVisible(false);
        block.setVisible(false);
        unblock.setVisible(false);
       
        //type.setEnabled(product.getBarcode()==0);
        barcode.setEnabled(product.getBarcode()==0);
        locationX.setEnabled(product.getBarcode()==0);
        locationY.setEnabled(product.getBarcode()==0);
        stock.setEnabled(product.getBarcode()==0);
        salesvolume.setEnabled(product.getBarcode()==0);
        type.setEnabled(product.getBarcode()==0);
        type.removeAllItems();
        type.addItems("접속중","정상","차단","반출중");
        fieldGroup.bind(type, "type");
        // Scroll to the top
        // As this is not a Panel, using JavaScript
        String scrollScript = "window.document.getElementById('" + getId()
                + "').scrollTop = 0;";
        Page.getCurrent().getJavaScript().execute(scrollScript);
    }

    @PostConstruct
    private void init() {
        addStyleName("product-form");

      
        //type.setContainerDataSource(new BeanItemContainer<>(TB_Product.class, Arrays.asList(TB_Product.)));
        //price.setConverter(new EuroConverter());
        //type.setContainerDataSource(new BeanItemContainer<>(type.class, Arrays.asList(type.values())));
        
        fieldGroup.bind(barcode, "barcode");
        fieldGroup.bind(name, "name");
        fieldGroup.bind(locationX, "locationX");
        fieldGroup.bind(locationY, "locationY");
        fieldGroup.bind(stock, "stock");
        fieldGroup.bind(salesvolume, "salesvolume");
        fieldGroup.bind(type, "type");
        fieldGroup.bind(brand, "brand");
        fieldGroup.bind(price, "price");
        
        //barcode.addValidator(new StringLengthValidator("product ID must have at least two characters",2,1024,false));

        barcode.setValidationVisible(false);
        barcode.addValueChangeListener(e->{
        	if(!barcode.isEmpty())
        		barcode.setValidationVisible(true);
        	else
        		barcode.setValidationVisible(false);
        });
        
        //name.addValidator(new StringLengthValidator("name must have at least two characters",2,1024,false));

        name.setValidationVisible(false);
        name.addValueChangeListener(e->{
        	if(!name.isEmpty())
        		name.setValidationVisible(true);
        	else
        		name.setValidationVisible(false);
        });
        
        modify.addClickListener(event->onModify());
        block.addClickListener(event->onBlock());
        unblock.addClickListener(event->onBlock());
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
            TB_Product product = ((BeanItem<TB_Product>) fieldGroup.getItemDataSource()).getBean();
            
            viewLogic.addproduct(product);
        } catch (FieldGroup.CommitException e) {
            Logger.getGlobal().log(Level.INFO,"Commit error", e);
        }
    }
    
    private void onModify() {
        try {
            fieldGroup.commit();
            TB_Product product = ((BeanItem<TB_Product>) fieldGroup.getItemDataSource()).getBean();
            viewLogic.modifyproduct(product);
        } catch (FieldGroup.CommitException e) {
            Logger.getGlobal().log(Level.INFO,"Commit error", e);
        }
    }
    
    private void onBlock() {
        try {
            fieldGroup.commit();
            TB_Product product = ((BeanItem<TB_Product>) fieldGroup.getItemDataSource()).getBean();
            
    
            viewLogic.blockproduct(product);
           
        } catch (FieldGroup.CommitException e) {
            Logger.getGlobal().log(Level.INFO,"Commit error", e);
        }
    }
    
    
    private void onSave() {
        try {
            fieldGroup.commit();
            TB_Product product = ((BeanItem<TB_Product>) fieldGroup.getItemDataSource()).getBean();
//        We do not support saving data in this demo
//        pDao.updateProduct(product);
            
        
            viewLogic.saveproduct(product);
            
        } catch (FieldGroup.CommitException e) {
            Logger.getGlobal().log(Level.INFO,"Commit error", e);
        }
    }
    
    

    private void onDelete() {
        fieldGroup.discard();
        TB_Product product = ((BeanItem<TB_Product>) fieldGroup.getItemDataSource()).getBean();
        if (product != null) viewLogic.deleteproduct(product);
    }

    private void init(ProductLogic logic) {
        this.viewLogic = logic;
    }

}