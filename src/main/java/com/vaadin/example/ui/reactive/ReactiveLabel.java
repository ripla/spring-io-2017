package com.vaadin.example.ui.reactive;

import com.vaadin.ui.Label;

import reactor.core.publisher.Flux;

public class ReactiveLabel extends Label implements ReactiveComponent {

    public void setValueStream(Flux<String> valueStream) {
        valueStream.subscribe(value -> {
            if (isAttached()) {
                getUI().access(() -> this.setValue(value));
            }
        });
    }
}
