package com.example.reactiveprogrammingtutorial.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;


class FluxAndMonoServicesTest {
	FluxAndMonoServices services = new FluxAndMonoServices();
	
	@Test
	void fruitsFlux() {
		var fruitsFlux = services.fruitsFlux();
		StepVerifier.create(fruitsFlux)
				.expectNext("Mango", "Orange", "Banana")
				.verifyComplete();
	}
	
	@Test
	void fruitMono() {
		var fruitMono = services.fruitsMono();
		StepVerifier.create(fruitMono)
				.expectNext("Mango")
				.verifyComplete();
	}
	
	@Test
	void fruitsFluxMap() {
		var fruitFluxMap = services.fruitsFluxMap();
		StepVerifier.create(fruitFluxMap)
				.expectNext("MANGO", "ORANGE", "BANANA")
				.verifyComplete();
	}
	
	@Test
	void fruitsFluxFilter() {
		var fruitFluxFilter = services.fruitsFluxFilter(5);
		StepVerifier.create(fruitFluxFilter)
				.expectNext("ORANGE", "BANANA")
				.verifyComplete();
	}
	
	@Test
	void fruitsFluxFlatMap() {
		var fruitFlux = services.fruitsFluxFlatMap();
		StepVerifier.create(fruitFlux)
				.expectNextCount(17)
				.verifyComplete();
	}
	
	@Test
	void fruitsFluxFlatMapAsync() {
		var fruitFlux = services.fruitsFluxFlatMapAsync();
		StepVerifier.create(fruitFlux)
				.expectNextCount(17)
				.verifyComplete();
	}
	
	@Test
	void fruitsMonoFlatMap() {
		var fruitMono = services.fruitsMonoFlatMap();
		StepVerifier.create(fruitMono)
				.expectNextCount(1)
				.verifyComplete();
	}
	
	@Test
	void fruitsFluxConcatMap() {
		var fruitFlux = services.fruitsFluxConcatMap();
		StepVerifier.create(fruitFlux)
				.expectNextCount(17)
				.verifyComplete();
	}
	
	@Test
	void fruitsMonoFlatMapMany() {
		var fruitFlux = services.fruitsMonoFlatMapMany();
		StepVerifier.create(fruitFlux)
				.expectNextCount(5)
				.verifyComplete();
	}
	
	@Test
	void fruitsFluxTransform() {
		var fruitFlux = services.fruitsFluxTransform(5);
		StepVerifier.create(fruitFlux)
				.expectNext("Orange", "Banana")
				.verifyComplete();
	}
	
	@Test
	void fruitsFluxTransformDefaultIfEmpty() {
		var fruitFlux = services.fruitsFluxTransformDefaultIfEmpty(10);
		StepVerifier.create(fruitFlux)
				.expectNext("Default")
				.verifyComplete();
	}
	
	@Test
	void fruitsFluxTransformSwitchIfEmpty() {
		var fruitsFlux = services.fruitsFluxTransformSwitchIfEmpty(8);
		StepVerifier.create(fruitsFlux)
				.expectNext("Pineapple", "Jack Fruit")
				.verifyComplete();
	}
}