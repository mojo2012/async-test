package io.corenext.async.services;

import java.util.Arrays;
import java.util.List;

import io.github.vipcxj.jasync.spec.JAsync;
import io.github.vipcxj.jasync.spec.JPromise;
import io.github.vipcxj.jasync.spec.annotations.Async;
import jakarta.inject.Singleton;

@Singleton
public class DataService {
	@Async
	public JPromise<List<String>> getTestString() {
		final var data = Arrays.asList( //
				getDataInternal().await(), //
				getDataInternal().await(), //
				getDataInternal().await());

		return JAsync.just(data);
	}

	@Async
	private JPromise<String> getDataInternal() {
		try {
			Thread.sleep(2000);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		return JAsync.just(Thread.currentThread().getName());
	}
}