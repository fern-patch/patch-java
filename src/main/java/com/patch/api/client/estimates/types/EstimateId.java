package com.patch.api.client.estimates.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.UUID;

public final class EstimateId {
  private final UUID value;

  private EstimateId(UUID value) {
    this.value = value;
  }

  @JsonValue
  public UUID get() {
    return this.value;
  }

  @Override
  public boolean equals(Object other) {
    return this == other || (other instanceof EstimateId && this.value.equals(((EstimateId) other).value));
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }

  @Override
  public String toString() {
    return value.toString();
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static EstimateId of(UUID value) {
    return new EstimateId(value);
  }

  public static EstimateId valueOf(String value) {
    return of(value);
  }
}
