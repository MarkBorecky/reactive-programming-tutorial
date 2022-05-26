package com.example.reactiveprogrammingtutorial.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoServices {
    public Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana")).log();
    }
    public Mono<String> fruitsMono() {
        return Mono.just("Mango").log();
    }
    public static void main(String... args) {
        FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();
        fluxAndMonoServices.fruitsFlux()
                .subscribe(s -> {
                    System.out.printf("s = %s\n", s);
                });
        fluxAndMonoServices.fruitsMono()
                .subscribe(s -> {
                    System.out.printf("Mono -> s = %s\n", s);
                });
    }
}
