package com.vaadin.example.ui.reactive;

import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import reactor.core.publisher.Flux;

public class ReactiveNotification {

    public static void setErrorNotificationStream(UI ui,
            Flux<String> messageStream) {

        messageStream.subscribe(message -> ui.access(
                () -> new Notification(message,
                        Notification.Type.ERROR_MESSAGE).show(ui.getPage())));

    }
}
