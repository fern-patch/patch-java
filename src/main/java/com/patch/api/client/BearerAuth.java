package com.patch.api.client;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Override;
import java.lang.String;

public final class BearerAuth {
  private final String token;

  private BearerAuth(String token) {
    this.token = token;
  }

  @JsonValue
  public String getToken() {
    return token;
  }

  @Override
  public String toString() {
    return "Bearer " + getToken();
  }

  public static BearerAuth of(String token) {
    return new BearerAuth(token.startsWith("Bearer ") ? token.substring(7) : token);
  }
}
