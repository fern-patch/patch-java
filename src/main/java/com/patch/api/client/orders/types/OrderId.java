package com.patch.api.client.orders.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.UUID;

public final class OrderId {
  private final UUID value;

  private OrderId(UUID value) {
    this.value = value;
  }

  @JsonValue
  public UUID get() {
    return this.value;
  }

  @Override
  public boolean equals(Object other) {
    return this == other || (other instanceof OrderId && this.value.equals(((OrderId) other).value));
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
  public static OrderId of(UUID value) {
    return new OrderId(value);
  }

  public static OrderId valueOf(String value) {
    return of(value);
  }
}
