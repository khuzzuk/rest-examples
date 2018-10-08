package com.example.security.web;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route("")
public class HomeView extends Div implements InitializingBean {
    private Label helloWorld = new Label("Hello world");
    private RouterLink userLink = new RouterLink("Users", UserView.class);

    @Override
    public void afterPropertiesSet() {
        add(helloWorld, userLink);
    }
}
