package com.neogul.ui.view.operation;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.neogul.data.dto.Category;
import com.neogul.data.dto.TB_Operation_Info;
import com.neogul.ui.util.Availability;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.converter.Converter;
import com.vaadin.data.util.converter.StringToCollectionConverter;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.HtmlRenderer;

/**
 * Grid of products, handling the visual presentation and filtering of a set of
 * items. This version uses an in-memory data source that is suitable for small
 * data sets.
 */
public class OperationGrid extends Grid {

    public static final Map<Object,String> styleByColumn = new HashMap<>();
    static {
        styleByColumn.put("price","align-right");
        styleByColumn.put("stockCount","align-right");
    }
    public OperationGrid() {
        setSizeFull();
        setSelectionMode(SelectionMode.SINGLE);
        
        setColumns("work_key","ask_user_id","ask_day","work_name","status","s_day","e_day","agent_name","agent_ip");
        getDefaultHeaderRow().getCell("ask_day").setText("신청 일시");
        getDefaultHeaderRow().getCell("ask_user_id").setText("신청자");
        getDefaultHeaderRow().getCell("work_name").setText("작업명");
        getDefaultHeaderRow().getCell("s_day").setText("작업 시작일");
        getDefaultHeaderRow().getCell("e_day").setText("작업 종료일");
        getDefaultHeaderRow().getCell("agent_name").setText("작업자");
        getDefaultHeaderRow().getCell("agent_ip").setText("작업 PC");
        getDefaultHeaderRow().getCell("status").setText("결재 상태");
//        addColumn("pc_ip", Integer.class);
//        addColumn("install_day", String.class);
//        addColumn("connect_day", BigDecimal.class);
//        addColumn("status", BigDecimal.class);
        setCellStyleGenerator(cell -> styleByColumn.get(cell.getPropertyId()));


//        addColumn("status",Availability.class).setRenderer(new HtmlRenderer())
//                .setConverter(new Converter<String, Availability>() {
//                    @Override
//                    public Availability convertToModel(String value, Class<? extends Availability> targetType, Locale locale) throws ConversionException {
//                        return null;
//                    }
//
//                    @Override
//                    public String convertToPresentation(Availability value, Class<? extends String> targetType, Locale locale) throws ConversionException {
//                        return getTrafficLightIconHtml(value) + " " + value.name();
//                    }
//
//                    @Override
//                    public Class<Availability> getModelType() {
//                        return Availability.class;
//                    }
//
//                    @Override
//                    public Class<String> getPresentationType() {
//                        return String.class;
//                    }
//                });
        
        //addColumn("contract_idx_str", Integer.class);
//        addColumn("category",Set.class).setConverter(new StringToCollectionConverter(", "){
//            @Override
//            public String convertToPresentation(Collection value, Class<? extends String> targetType, Locale locale) throws ConversionException {
//                Category[] categories = ((Collection<Category>)value).toArray(new Category[value.size()]);
//                Arrays.sort(categories,Comparator.comparing(Category::getId));
//                return super.convertToPresentation(Arrays.asList(categories), targetType, locale);
//            }
//        }).setSortable(false);
    }

    private String getTrafficLightIconHtml(Availability availability) {
        String color = "";
        if (availability == Availability.AVAILABLE) {
            color = "#2dd085";
        } else if (availability == Availability.COMING) {
            color = "#ffc66e";
        } else if (availability == Availability.DISCONTINUED) {
            color = "#f54993";
        }

        String iconCode = "<span class=\"v-icon\" style=\"font-family: "
                + FontAwesome.CIRCLE.getFontFamily() + ";color:" + color
                + "\">&#x"
                + Integer.toHexString(FontAwesome.CIRCLE.getCodepoint())
                + ";</span>";
        return iconCode;
    }

    public TB_Operation_Info getSelectedRow() {
        Object id = ((SelectionModel.Single) getSelectionModel()).getSelectedRow();
        return id == null? null : ((BeanItem<TB_Operation_Info>)getContainerDataSource().getItem(id)).getBean();
    }

}