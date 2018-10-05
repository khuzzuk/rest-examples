package com.example.security.web;

import com.example.security.user.User;
import com.example.security.user.UserRemoteService;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@UIScope
@Route("user")
@Tag("UserView")
public class UserView extends Div implements InitializingBean {
    private static final String ALLOWED_ROLE = "ROLE_ADMIN";
    private final UserRemoteService userRemoteService;

    private Label helloUser = new Label("Hello User");
    private TextField findUser = new TextField("User name");
    private Button findButton = new Button("Find");
    private Grid<User> userGrid = new Grid<>(User.class);

    @Override
    public void afterPropertiesSet() {
        add(helloUser);

        boolean isAllowedToSeeGrid = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(ALLOWED_ROLE::equals);

        if (isAllowedToSeeGrid) {
            add(findUser, findButton, userGrid);
            findButton.addClickListener(e -> searchUser());
            User user = userRemoteService.getUser("admin");
            userGrid.setItems(user);
        } else {
            add(new Label("No access to user details"));
        }
    }

    private void searchUser() {
        String usernameToFind = findUser.getValue();
        if (usernameToFind != null) {
            User user = userRemoteService.getUser(usernameToFind);
            userGrid.setItems(user);
        }
    }
}
