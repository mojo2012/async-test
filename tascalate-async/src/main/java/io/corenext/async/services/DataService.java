package io.corenext.async.services;

import static net.tascalate.async.CallContext.async;
import static net.tascalate.async.CallContext.await;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;

import jakarta.inject.Singleton;
import net.tascalate.async.async;

@Singleton
public class DataService {

	public @async CompletionStage<List<String>> getTestString() {
		final var data = Arrays.asList( //
				await(getDataInternal()), //
				await(getDataInternal()), //
				await(getDataInternal()));

		return async(data);
	}

	private @async CompletionStage<String> getDataInternal() {
		try {
			Thread.sleep(2000);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		return async(Thread.currentThread().getName());
	}
}