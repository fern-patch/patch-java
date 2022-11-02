package com.patch.api.client;

import com.patch.api.client.estimates.EstimatesServiceClient;
import java.lang.String;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public final class PatchApiClient {
  private final Supplier<EstimatesServiceClient> estimatesServiceClient;

  public PatchApiClient(String url) {
    this.estimatesServiceClient = memoize(() -> new EstimatesServiceClient(url));
  }

  public PatchApiClient(String url, BearerAuth auth) {
    this.estimatesServiceClient = memoize(() -> new EstimatesServiceClient(url, auth));
  }

  public final EstimatesServiceClient estimates() {
    return this.estimatesServiceClient.get();
  }

  private static <T> Supplier<T> memoize(Supplier<T> delegate) {
    AtomicReference<T> value = new AtomicReference<>();
    return () ->  {
      T val = value.get();
      if (val == null) {
        val = value.updateAndGet(cur -> cur == null ? Objects.requireNonNull(delegate.get()) : cur);
      }
      return val;
    } ;
  }
}
