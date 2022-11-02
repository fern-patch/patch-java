package com.patch.api.client.estimates.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class CabinClass {
  public static final CabinClass BUSINESS = new CabinClass(Value.BUSINESS, "business");

  public static final CabinClass FIRST = new CabinClass(Value.FIRST, "first");

  public static final CabinClass ECONOMY = new CabinClass(Value.ECONOMY, "economy");

  private final Value value;

  private final String string;

  CabinClass(Value value, String string) {
    this.value = value;
    this.string = string;
  }

  public Value getEnumValue() {
    return value;
  }

  @Override
  @JsonValue
  public String toString() {
    return this.string;
  }

  @Override
  public boolean equals(Object other) {
    return (this == other) 
      || (other instanceof CabinClass && this.string.equals(((CabinClass) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case BUSINESS:
        return visitor.visitBusiness();
      case FIRST:
        return visitor.visitFirst();
      case ECONOMY:
        return visitor.visitEconomy();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static CabinClass valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "business":
        return BUSINESS;
      case "first":
        return FIRST;
      case "economy":
        return ECONOMY;
      default:
        return new CabinClass(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    ECONOMY,

    BUSINESS,

    FIRST,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitEconomy();

    T visitBusiness();

    T visitFirst();

    T visitUnknown(String unknownType);
  }
}
