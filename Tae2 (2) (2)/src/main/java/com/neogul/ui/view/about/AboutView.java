package com.neogul.ui.view.about;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.Version;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = AboutView.VIEW_NAME)
public class AboutView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "About";

    public AboutView() {
        CustomLayout aboutContent = new CustomLayout("aboutview");
        aboutContent.setStyleName("about-content");

        // you can add Vaadin components in predefined slots in the custom
        // layout
        aboutContent.addComponent(
                new Label(FontAwesome.INFO_CIRCLE.getHtml()
                        + "스마트 폰, 스마트 TV, 스마트 홈, 스마트 카 등등, 우리의 생활을 편리하게 만들어주는 IoT 기술의 등장으로 스마트한 세상이 열린지 벌써 몇 년이 흘렀다. 이미 주변의 많은 물건들이 인터넷과 통신하여 정보를 주고받고 있으며, 우리는 이를 쇼핑카트에 접목시킨 시스템을 개발하고자 한다.물건을 사는 일은 물물교환이나 자급자족 경제하에는 없었던 일이며, 근대 산업 경제의 발전에 따라 대두된 경제활동이다. 특히 상품의 종류가 다양해지면서 욕망은 무한히 확대됐다. 그러나 한정된 예산으로 무엇을, 언제, 어디서, 어떻게, 어떠한 이유 때문에 사는가를 우선 정하지 않으면 충동적인 구매를 하게 된다. 우리는 이러한 충동구매를 막으면서 상품의 위치를 찾으며 불필요한 동선을 생략할 수 있는 프로젝트이다.관리자와 소비자 등의 사용자를 위한 시스템 전체를 개발하기 위해, 각각의 사용자가 요구하는 요구 사항과 목적에 맞으며 편의성을 제공받을 수 있는 User Interface 개발하였다. 또한, 실제 사업 가능성까지 고려하여 스마트 디바이스 시장의 동향에 따른 맞춰가려 한다." 
                        + Version.getFullVersion(), ContentMode.HTML),
                "info");
        
        setSizeFull();
        setStyleName("about-view");
        addComponent(aboutContent);
        setComponentAlignment(aboutContent, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

}
