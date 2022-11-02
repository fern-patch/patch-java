package com.patch.api.client.estimates.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.patch.api.client.orders.types.Order;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = Estimate.Builder.class
)
public final class Estimate {
  private final EstimateId id;

  private final boolean production;

  private final String type;

  private final int massG;

  private final Optional<Order> order;

  private int _cachedHashCode;

  Estimate(EstimateId id, boolean production, String type, int massG, Optional<Order> order) {
    this.id = id;
    this.production = production;
    this.type = type;
    this.massG = massG;
    this.order = order;
  }

  @JsonProperty("id")
  public EstimateId getId() {
    return id;
  }

  @JsonProperty("production")
  public boolean getProduction() {
    return production;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("mass_g")
  public int getMassG() {
    return massG;
  }

  @JsonProperty("order")
  public Optional<Order> getOrder() {
    return order;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Estimate && equalTo((Estimate) other);
  }

  private boolean equalTo(Estimate other) {
    return id.equals(other.id) && production == other.production && type.equals(other.type) && massG == other.massG && order.equals(other.order);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.production, this.type, this.massG, this.order);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Estimate{" + "id: " + id + ", production: " + production + ", type: " + type + ", massG: " + massG + ", order: " + order + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    ProductionStage id(EstimateId id);

    Builder from(Estimate other);
  }

  public interface ProductionStage {
    TypeStage production(boolean production);
  }

  public interface TypeStage {
    MassGStage type(String type);
  }

  public interface MassGStage {
    _FinalStage massG(int massG);
  }

  public interface _FinalStage {
    Estimate build();

    _FinalStage order(Optional<Order> order);

    _FinalStage order(Order order);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IdStage, ProductionStage, TypeStage, MassGStage, _FinalStage {
    private EstimateId id;

    private boolean production;

    private String type;

    private int massG;

    private Optional<Order> order = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(Estimate other) {
      id(other.getId());
      production(other.getProduction());
      type(other.getType());
      massG(other.getMassG());
      order(other.getOrder());
      return this;
    }

    @Override
    @JsonSetter("id")
    public ProductionStage id(EstimateId id) {
      this.id = id;
      return this;
    }

    @Override
    @JsonSetter("production")
    public TypeStage production(boolean production) {
      this.production = production;
      return this;
    }

    @Override
    @JsonSetter("type")
    public MassGStage type(String type) {
      this.type = type;
      return this;
    }

    @Override
    @JsonSetter("mass_g")
    public _FinalStage massG(int massG) {
      this.massG = massG;
      return this;
    }

    @Override
    public _FinalStage order(Order order) {
      this.order = Optional.of(order);
      return this;
    }

    @Override
    @JsonSetter(
        value = "order",
        nulls = Nulls.SKIP
    )
    public _FinalStage order(Optional<Order> order) {
      this.order = order;
      return this;
    }

    @Override
    public Estimate build() {
      return new Estimate(id, production, type, massG, order);
    }
  }
}
