package com.joheul.ui.view.agent;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.joheul.data.dto.Category;
import com.joheul.data.dto.TB_Device_Info;
import com.joheul.ui.util.Availability;
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
public class AgentGrid extends Grid {

    public static final Map<Object,String> styleByColumn = new HashMap<>();
    static {
        styleByColumn.put("price","align-right");
        styleByColumn.put("stockCount","align-right");
    }
    public AgentGrid() {
        setSizeFull();
        setSelectionMode(SelectionMode.SINGLE);
        
        setColumns("nickname","install_day","connect_day","status","user_id","agent_id","pc_mac","pc_ip");
        getDefaultHeaderRow().getCell("agent_id").setText("AGENT ID");
        getDefaultHeaderRow().getCell("nickname").setText("닉네임");
        getDefaultHeaderRow().getCell("pc_mac").setText("PC MAC");
        getDefaultHeaderRow().getCell("pc_ip").setText("PC IP");
        getDefaultHeaderRow().getCell("install_day").setText("설치 일시");
        getDefaultHeaderRow().getCell("connect_day").setText("최종 접속 일시");
        getDefaultHeaderRow().getCell("user_id").setText("USER ID");
        getDefaultHeaderRow().getCell("status").setText("상태");
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

    public TB_Device_Info getSelectedRow() {
        Object id = ((SelectionModel.Single) getSelectionModel()).getSelectedRow();
        return id == null? null : ((BeanItem<TB_Device_Info>)getContainerDataSource().getItem(id)).getBean();
    }

}