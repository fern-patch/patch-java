package com.patch.api.client.orders.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = IssuedTo.Builder.class
)
public final class IssuedTo {
  private final String name;

  private final String email;

  private int _cachedHashCode;

  IssuedTo(String name, String email) {
    this.name = name;
    this.email = email;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof IssuedTo && equalTo((IssuedTo) other);
  }

  private boolean equalTo(IssuedTo other) {
    return name.equals(other.name) && email.equals(other.email);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.name, this.email);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "IssuedTo{" + "name: " + name + ", email: " + email + "}";
  }

  public static NameStage builder() {
    return new Builder();
  }

  public interface NameStage {
    EmailStage name(String name);

    Builder from(IssuedTo other);
  }

  public interface EmailStage {
    _FinalStage email(String email);
  }

  public interface _FinalStage {
    IssuedTo build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements NameStage, EmailStage, _FinalStage {
    private String name;

    private String email;

    private Builder() {
    }

    @Override
    public Builder from(IssuedTo other) {
      name(other.getName());
      email(other.getEmail());
      return this;
    }

    @Override
    @JsonSetter("name")
    public EmailStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    @JsonSetter("email")
    public _FinalStage email(String email) {
      this.email = email;
      return this;
    }

    @Override
    public IssuedTo build() {
      return new IssuedTo(name, email);
    }
  }
}
