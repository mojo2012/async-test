package io.corenext.async.endpoints;

import java.util.List;

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
	public Mono<List<String>> get() {
		return Mono.fromCompletionStage(dataService.getTestString());
	}
}
