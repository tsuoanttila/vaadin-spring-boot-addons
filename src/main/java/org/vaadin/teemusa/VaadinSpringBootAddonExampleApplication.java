package org.vaadin.teemusa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaadin.addon.contextmenu.ContextMenu;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringBootApplication
public class VaadinSpringBootAddonExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaadinSpringBootAddonExampleApplication.class, args);
	}
}

@SpringUI(path = "")
@Theme("valo")
class MyUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout content = new VerticalLayout();
                content.setMargin(true);
                content.addComponent(new Label("This view contains nothing "
                        + "interesting, but try context menu clicking on it to "
                        + "see a Vaadin Add-on in use."));
		content.setSizeFull();

		ContextMenu menu = new ContextMenu(content, false);
		menu.addItem("Menu entry", menuItem -> {
			Notification.show("Menu entry selected!", Type.TRAY_NOTIFICATION);
		});
		content.addContextClickListener(event -> {
			menu.open(event.getClientX(), event.getClientY());
		});

		setContent(content);
	}
}