package com.patch.api.client.orders.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = Order.Builder.class
)
public final class Order {
  private final OrderId id;

  private final String createdAt;

  private final boolean production;

  private final String state;

  private final int amount;

  private final String unit;

  private final int price;

  private final int patchFee;

  private final Optional<String> currency;

  private final Optional<String> registryUrl;

  private final Optional<String> metadata;

  private final List<LineItem> lineItems;

  private final Optional<IssuedTo> issuedTo;

  private int _cachedHashCode;

  Order(OrderId id, String createdAt, boolean production, String state, int amount, String unit,
      int price, int patchFee, Optional<String> currency, Optional<String> registryUrl,
      Optional<String> metadata, List<LineItem> lineItems, Optional<IssuedTo> issuedTo) {
    this.id = id;
    this.createdAt = createdAt;
    this.production = production;
    this.state = state;
    this.amount = amount;
    this.unit = unit;
    this.price = price;
    this.patchFee = patchFee;
    this.currency = currency;
    this.registryUrl = registryUrl;
    this.metadata = metadata;
    this.lineItems = lineItems;
    this.issuedTo = issuedTo;
  }

  @JsonProperty("id")
  public OrderId getId() {
    return id;
  }

  @JsonProperty("created_at")
  public String getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("production")
  public boolean getProduction() {
    return production;
  }

  @JsonProperty("state")
  public String getState() {
    return state;
  }

  @JsonProperty("amount")
  public int getAmount() {
    return amount;
  }

  @JsonProperty("unit")
  public String getUnit() {
    return unit;
  }

  @JsonProperty("price")
  public int getPrice() {
    return price;
  }

  @JsonProperty("patch_fee")
  public int getPatchFee() {
    return patchFee;
  }

  @JsonProperty("currency")
  public Optional<String> getCurrency() {
    return currency;
  }

  @JsonProperty("registry_url")
  public Optional<String> getRegistryUrl() {
    return registryUrl;
  }

  @JsonProperty("metadata")
  public Optional<String> getMetadata() {
    return metadata;
  }

  @JsonProperty("line_items")
  public List<LineItem> getLineItems() {
    return lineItems;
  }

  @JsonProperty("issued_to")
  public Optional<IssuedTo> getIssuedTo() {
    return issuedTo;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Order && equalTo((Order) other);
  }

  private boolean equalTo(Order other) {
    return id.equals(other.id) && createdAt.equals(other.createdAt) && production == other.production && state.equals(other.state) && amount == other.amount && unit.equals(other.unit) && price == other.price && patchFee == other.patchFee && currency.equals(other.currency) && registryUrl.equals(other.registryUrl) && metadata.equals(other.metadata) && lineItems.equals(other.lineItems) && issuedTo.equals(other.issuedTo);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.createdAt, this.production, this.state, this.amount, this.unit, this.price, this.patchFee, this.currency, this.registryUrl, this.metadata, this.lineItems, this.issuedTo);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Order{" + "id: " + id + ", createdAt: " + createdAt + ", production: " + production + ", state: " + state + ", amount: " + amount + ", unit: " + unit + ", price: " + price + ", patchFee: " + patchFee + ", currency: " + currency + ", registryUrl: " + registryUrl + ", metadata: " + metadata + ", lineItems: " + lineItems + ", issuedTo: " + issuedTo + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    CreatedAtStage id(OrderId id);

    Builder from(Order other);
  }

  public interface CreatedAtStage {
    ProductionStage createdAt(String createdAt);
  }

  public interface ProductionStage {
    StateStage production(boolean production);
  }

  public interface StateStage {
    AmountStage state(String state);
  }

  public interface AmountStage {
    UnitStage amount(int amount);
  }

  public interface UnitStage {
    PriceStage unit(String unit);
  }

  public interface PriceStage {
    PatchFeeStage price(int price);
  }

  public interface PatchFeeStage {
    _FinalStage patchFee(int patchFee);
  }

  public interface _FinalStage {
    Order build();

    _FinalStage currency(Optional<String> currency);

    _FinalStage currency(String currency);

    _FinalStage registryUrl(Optional<String> registryUrl);

    _FinalStage registryUrl(String registryUrl);

    _FinalStage metadata(Optional<String> metadata);

    _FinalStage metadata(String metadata);

    _FinalStage lineItems(List<LineItem> lineItems);

    _FinalStage lineItems(LineItem lineItems);

    _FinalStage addAllLineItems(List<LineItem> lineItems);

    _FinalStage issuedTo(Optional<IssuedTo> issuedTo);

    _FinalStage issuedTo(IssuedTo issuedTo);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IdStage, CreatedAtStage, ProductionStage, StateStage, AmountStage, UnitStage, PriceStage, PatchFeeStage, _FinalStage {
    private OrderId id;

    private String createdAt;

    private boolean production;

    private String state;

    private int amount;

    private String unit;

    private int price;

    private int patchFee;

    private Optional<IssuedTo> issuedTo = Optional.empty();

    private List<LineItem> lineItems = new ArrayList<>();

    private Optional<String> metadata = Optional.empty();

    private Optional<String> registryUrl = Optional.empty();

    private Optional<String> currency = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(Order other) {
      id(other.getId());
      createdAt(other.getCreatedAt());
      production(other.getProduction());
      state(other.getState());
      amount(other.getAmount());
      unit(other.getUnit());
      price(other.getPrice());
      patchFee(other.getPatchFee());
      currency(other.getCurrency());
      registryUrl(other.getRegistryUrl());
      metadata(other.getMetadata());
      lineItems(other.getLineItems());
      issuedTo(other.getIssuedTo());
      return this;
    }

    @Override
    @JsonSetter("id")
    public CreatedAtStage id(OrderId id) {
      this.id = id;
      return this;
    }

    @Override
    @JsonSetter("created_at")
    public ProductionStage createdAt(String createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    @Override
    @JsonSetter("production")
    public StateStage production(boolean production) {
      this.production = production;
      return this;
    }

    @Override
    @JsonSetter("state")
    public AmountStage state(String state) {
      this.state = state;
      return this;
    }

    @Override
    @JsonSetter("amount")
    public UnitStage amount(int amount) {
      this.amount = amount;
      return this;
    }

    @Override
    @JsonSetter("unit")
    public PriceStage unit(String unit) {
      this.unit = unit;
      return this;
    }

    @Override
    @JsonSetter("price")
    public PatchFeeStage price(int price) {
      this.price = price;
      return this;
    }

    @Override
    @JsonSetter("patch_fee")
    public _FinalStage patchFee(int patchFee) {
      this.patchFee = patchFee;
      return this;
    }

    @Override
    public _FinalStage issuedTo(IssuedTo issuedTo) {
      this.issuedTo = Optional.of(issuedTo);
      return this;
    }

    @Override
    @JsonSetter(
        value = "issued_to",
        nulls = Nulls.SKIP
    )
    public _FinalStage issuedTo(Optional<IssuedTo> issuedTo) {
      this.issuedTo = issuedTo;
      return this;
    }

    @Override
    public _FinalStage addAllLineItems(List<LineItem> lineItems) {
      this.lineItems.addAll(lineItems);
      return this;
    }

    @Override
    public _FinalStage lineItems(LineItem lineItems) {
      this.lineItems.add(lineItems);
      return this;
    }

    @Override
    @JsonSetter(
        value = "line_items",
        nulls = Nulls.SKIP
    )
    public _FinalStage lineItems(List<LineItem> lineItems) {
      this.lineItems.clear();
      this.lineItems.addAll(lineItems);
      return this;
    }

    @Override
    public _FinalStage metadata(String metadata) {
      this.metadata = Optional.of(metadata);
      return this;
    }

    @Override
    @JsonSetter(
        value = "metadata",
        nulls = Nulls.SKIP
    )
    public _FinalStage metadata(Optional<String> metadata) {
      this.metadata = metadata;
      return this;
    }

    @Override
    public _FinalStage registryUrl(String registryUrl) {
      this.registryUrl = Optional.of(registryUrl);
      return this;
    }

    @Override
    @JsonSetter(
        value = "registry_url",
        nulls = Nulls.SKIP
    )
    public _FinalStage registryUrl(Optional<String> registryUrl) {
      this.registryUrl = registryUrl;
      return this;
    }

    @Override
    public _FinalStage currency(String currency) {
      this.currency = Optional.of(currency);
      return this;
    }

    @Override
    @JsonSetter(
        value = "currency",
        nulls = Nulls.SKIP
    )
    public _FinalStage currency(Optional<String> currency) {
      this.currency = currency;
      return this;
    }

    @Override
    public Order build() {
      return new Order(id, createdAt, production, state, amount, unit, price, patchFee, currency, registryUrl, metadata, lineItems, issuedTo);
    }
  }
}
