package com.example.reactiveprogrammingtutorial.service;

import reactor.core.publisher.Flux;

import java.util.List;

public class FluxAndMonoServices {
    public Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"));
    }
    public Mono<>
    public static void main(String... args) {
        FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();
        fluxAndMonoServices.fruitsFlux()
                .subscribe(s -> {
                    System.out.printf("s = %s\n", s);
                });
    }
}
