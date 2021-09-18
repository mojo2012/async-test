package io.corenext.async.endpoints;

import io.corenext.async.services.DataService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import reactor.core.publisher.Mono;

@Controller("/")
public class TestEndpoints {

	@Inject
	private DataService dataService;

	@Get
	public Mono<String> get() {
		return dataService.getTestString().unwrap(Mono.class);
	}
}
