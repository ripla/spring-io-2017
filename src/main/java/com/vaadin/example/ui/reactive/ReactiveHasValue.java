package com.vaadin.example.ui.reactive;

import com.vaadin.data.HasValue;
import com.vaadin.shared.Registration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public interface ReactiveHasValue<V> extends HasValue<V> {

    default Flux<V> getValueStream() {
        return Flux.push(fluxSink -> {
            final Registration registration = addValueChangeListener(
                    e -> fluxSink.next(e.getValue()));
            fluxSink.onDispose(registration::remove);
        }, FluxSink.OverflowStrategy.LATEST);
    }
}
