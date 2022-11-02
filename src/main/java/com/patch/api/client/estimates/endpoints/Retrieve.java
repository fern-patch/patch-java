package com.patch.api.client.estimates.endpoints;

import com.patch.api.client.BearerAuth;
import com.patch.api.client.estimates.types.EstimateId;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Retrieve {
  private Retrieve() {
  }

  public static final class Request {
    private final Optional<BearerAuth> authOverride;

    private final EstimateId id;

    private int _cachedHashCode;

    Request(Optional<BearerAuth> authOverride, EstimateId id) {
      this.authOverride = authOverride;
      this.id = id;
    }

    public Optional<BearerAuth> getAuthOverride() {
      return authOverride;
    }

    public EstimateId getId() {
      return id;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && id.equals(other.id);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.id);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Retrieve.Request{" + "authOverride: " + authOverride + ", id: " + id + "}";
    }

    public static IdStage builder() {
      return new Builder();
    }

    public interface IdStage {
      _FinalStage id(EstimateId id);

      Builder from(Request other);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BearerAuth> authOverride);

      _FinalStage authOverride(BearerAuth authOverride);
    }

    static final class Builder implements IdStage, _FinalStage {
      private EstimateId id;

      private Optional<BearerAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        id(other.getId());
        return this;
      }

      @Override
      public _FinalStage id(EstimateId id) {
        this.id = id;
        return this;
      }

      @Override
      public _FinalStage authOverride(BearerAuth authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      @Override
      public _FinalStage authOverride(Optional<BearerAuth> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      @Override
      public Request build() {
        return new Request(authOverride, id);
      }
    }
  }
}
