package com.example.reactiveprogrammingtutorial.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class FluxAndMonoServices {
	List<String> fruits = List.of("Mango", "Orange", "Banana");
	
	public Flux<String> fruitsFlux() {
		return Flux.fromIterable(List.of("Mango", "Orange", "Banana"));
	}
	
	public Flux<String> fruitsFluxMap() {
		return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
				.map(String::toUpperCase);
	}
	
	public Flux<String> fruitsFluxFilter(int number) {
		return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
				.map(String::toUpperCase)
				.filter(s -> s.length() > number);
		
	}
	
	public Flux<String> fruitsFluxFlatMap() {
		return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
				.flatMap(s -> Flux.just(s.split("")));
	}
	
	public Flux<String> fruitsFluxFlatMapAsync() {
		return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
				.flatMap(s -> Flux.just(s.split(""))
						.delayElements(Duration.ofMillis(
								new Random().nextInt(1000)
						)));
	}
	
	public Flux<String> fruitsFluxConcatMap() {
		return Flux.fromIterable(fruits)
				.concatMap(s -> Flux.just(s.split(""))
						.delayElements(Duration.ofMillis(
								new Random().nextInt(1000)
						)))
				.log();
	}
	
	public Mono<String> fruitsMono() {
		return Mono.just("Mango");
	}
	
	public Mono<List<String>> fruitsMonoFlatMap() {
		return Mono.just("Mango")
				.flatMap(s -> Mono.just(List.of(s.split(""))))
				.log();
	}
	
	public Flux<String> fruitsMonoFlatMapMany() {
		return Mono.just("Mango")
				.flatMapMany(s -> Flux.just(s.split("")))
				.log();
	}
	
	public Flux<String> fruitsFluxTransform(int number) {
		Function<Flux<String>, Flux<String>> filterData =
				data -> data.filter(s -> s.length() > number);
		return Flux.fromIterable(fruits)
				.transform(filterData)
				.log();
	}
	
	public Flux<String> fruitsFluxTransformDefaultIfEmpty(int number) {
		Function<Flux<String>, Flux<String>> filterData =
				data -> data.filter(s -> s.length() > number);
		return Flux.fromIterable(fruits)
				.transform(filterData)
				.defaultIfEmpty("Default")
				.log();
	}
	
	public Flux<String> fruitsFluxTransformSwitchIfEmpty(int number) {
		Function<Flux<String>, Flux<String>> filterData =
				data -> data.filter(s -> s.length() > number);
		return Flux.fromIterable(fruits)
				.transform(filterData)
				.switchIfEmpty(
						Flux.just("Pineapple", "Jack Fruit")
								.transform(filterData))
				.log();
	}
}
