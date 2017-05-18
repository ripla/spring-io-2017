package com.vaadin.example.ui.reactive;

import com.vaadin.ui.Component;

import reactor.core.publisher.Flux;

public interface ReactiveComponent extends Component {

    default void setVisible(Flux<Boolean> visibilityStream) {
        visibilityStream.subscribe(
                isVisible -> getUI().access(() -> this.setVisible(isVisible)));
    }
}
