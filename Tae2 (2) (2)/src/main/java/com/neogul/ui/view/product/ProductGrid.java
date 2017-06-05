package com.neogul.ui.view.product;

import java.util.HashMap;
import java.util.Map;

import com.neogul.data.dto.TB_Product;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Grid;

/**
 * Grid of products, handling the visual presentation and filtering of a set of
 * items. This version uses an in-memory data source that is suitable for small
 * data sets.
 */
public class ProductGrid extends Grid {

    public static final Map<Object,String> styleByColumn = new HashMap<>();
    static {
        styleByColumn.put("price","align-right");
        styleByColumn.put("stockCount","align-right");
    }
    public ProductGrid() {
        setSizeFull();
        setSelectionMode(SelectionMode.SINGLE);
        setColumns("barcode","name","price","locationX","locationY","stock","salesvolume","type","brand");
        getDefaultHeaderRow().getCell("barcode").setText("바코드 번호");
        getDefaultHeaderRow().getCell("name").setText("상품명");
        getDefaultHeaderRow().getCell("locationX").setText("X좌표");
        getDefaultHeaderRow().getCell("locationY").setText("Y좌표");
        getDefaultHeaderRow().getCell("stock").setText("재고");
        getDefaultHeaderRow().getCell("salesvolume").setText("판매량");
        getDefaultHeaderRow().getCell("type").setText("종류");
        getDefaultHeaderRow().getCell("brand").setText("브랜드");
        getDefaultHeaderRow().getCell("price").setText("가격");
        setCellStyleGenerator(cell -> styleByColumn.get(cell.getPropertyId()));
    }


    public TB_Product getSelectedRow() {
        Object id = ((SelectionModel.Single) getSelectionModel()).getSelectedRow();
        return id == null? null : ((BeanItem<TB_Product>)getContainerDataSource().getItem(id)).getBean();
    }

}