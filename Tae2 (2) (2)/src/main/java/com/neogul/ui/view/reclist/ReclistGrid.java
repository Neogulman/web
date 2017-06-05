package com.neogul.ui.view.reclist;

import java.util.HashMap;
import java.util.Map;

import com.neogul.data.dto.TB_Reclist;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Grid;

/**
 * Grid of products, handling the visual presentation and filtering of a set of
 * items. This version uses an in-memory data source that is suitable for small
 * data sets.
 */
public class ReclistGrid extends Grid {

    public static final Map<Object,String> styleByColumn = new HashMap<>();
    static {
//        styleByColumn.put("price","align-right");
//        styleByColumn.put("stockCount","align-right");
    }
    public ReclistGrid() {
        setSizeFull();
        setSelectionMode(SelectionMode.SINGLE);
        setColumns("name","price");
        getDefaultHeaderRow().getCell("name").setText("상품명");
        getDefaultHeaderRow().getCell("price").setText("추천 점수");
        setCellStyleGenerator(cell -> styleByColumn.get(cell.getPropertyId()));
    }


    public TB_Reclist getSelectedRow() {
        Object id = ((SelectionModel.Single) getSelectionModel()).getSelectedRow();
        return id == null? null : ((BeanItem<TB_Reclist>)getContainerDataSource().getItem(id)).getBean();
    }

}