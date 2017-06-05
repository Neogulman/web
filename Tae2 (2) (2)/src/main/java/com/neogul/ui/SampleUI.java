package com.neogul.ui;

import com.vaadin.spring.annotation.EnableVaadinNavigation;
import org.springframework.beans.factory.annotation.Autowired;

import com.neogul.ui.authentication.AccessControl;
import com.neogul.ui.authentication.LoginScreen;
import com.neogul.ui.view.about.AboutView;
import com.neogul.ui.view.agent.AgentView;
import com.neogul.ui.view.operation.OperationView;
import com.neogul.ui.view.product.ProductView;
import com.neogul.ui.view.reclist.ReclistView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Viewport;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Main UI class of the application that shows either the login screen or the
 * main view of the application depending on whether a user is signed in.
 *
 * The @Viewport annotation configures the viewport meta tags appropriately on
 * mobile devices. Instead of device based scaling (default), using responsive
 * layouts.
 */
@SuppressWarnings("unused")
@Viewport("user-scalable=no,initial-scale=1.0")
@Theme("mytheme")
@SpringUI
@EnableVaadinNavigation
public class SampleUI extends UI {

    @Autowired
    private AccessControl accessControl;

    private Menu menu;

    @Autowired
    private MySpringViewDisplay springViewDisplay;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Responsive.makeResponsive(this);
        setLocale(vaadinRequest.getLocale());
        getPage().setTitle("AdvoCart");
        getNavigator().navigateTo(AboutView.VIEW_NAME);
        if (!accessControl.isUserSignedIn()) {
            setContent(new LoginScreen(accessControl, this::showMainView));
        } else {
            showMainView();
        }
    }

    private void showMainView() {
        addStyleName(ValoTheme.UI_WITH_MENU);

        HorizontalLayout layout = new HorizontalLayout();
        setContent(layout);

        layout.setStyleName("main-screen");

        springViewDisplay.addStyleName("valo-content");
        springViewDisplay.setSizeFull();

        getNavigator().setErrorView(ErrorView.class);

        menu = new Menu(getNavigator());
        // View are registered automatically by Vaadin Spring support
      
        menu.addViewButton(AboutView.VIEW_NAME, "제품 설명",
                FontAwesome.INFO_CIRCLE);
//        menu.addViewButton(AgentView.VIEW_NAME, AgentView.VIEW_NAME,
//                FontAwesome.SITEMAP);
//        menu.addViewButton(OperationView.VIEW_NAME, OperationView.VIEW_NAME,
//                FontAwesome.EDIT);
        menu.addViewButton(ProductView.VIEW_NAME, ProductView.VIEW_NAME,
                FontAwesome.EDIT);
        menu.addViewButton(ReclistView.VIEW_NAME, ReclistView.VIEW_NAME,
                FontAwesome.SITEMAP);
        getNavigator().addViewChangeListener(new ViewChangeHandler());

        layout.addComponent(menu);
        layout.addComponent(springViewDisplay);
        layout.setExpandRatio(springViewDisplay, 1);
        
        layout.setSizeFull();

        getNavigator().navigateTo(AboutView.VIEW_NAME);
    }

    private class ViewChangeHandler implements ViewChangeListener {

        @Override
        public boolean beforeViewChange(ViewChangeEvent event) {
            return true;
        }

        @Override
        public void afterViewChange(ViewChangeEvent event) {
            menu.setActiveView(event.getViewName());
        }

    }
}
