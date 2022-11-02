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
    builder = LineItem.Builder.class
)
public final class LineItem {
  private final ItemId id;

  private final Project project;

  private final int vintageYear;

  private final int amount;

  private final String unit;

  private final int price;

  private final String currency;

  private int _cachedHashCode;

  LineItem(ItemId id, Project project, int vintageYear, int amount, String unit, int price,
      String currency) {
    this.id = id;
    this.project = project;
    this.vintageYear = vintageYear;
    this.amount = amount;
    this.unit = unit;
    this.price = price;
    this.currency = currency;
  }

  @JsonProperty("id")
  public ItemId getId() {
    return id;
  }

  @JsonProperty("project")
  public Project getProject() {
    return project;
  }

  @JsonProperty("vintage_year")
  public int getVintageYear() {
    return vintageYear;
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

  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LineItem && equalTo((LineItem) other);
  }

  private boolean equalTo(LineItem other) {
    return id.equals(other.id) && project.equals(other.project) && vintageYear == other.vintageYear && amount == other.amount && unit.equals(other.unit) && price == other.price && currency.equals(other.currency);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.project, this.vintageYear, this.amount, this.unit, this.price, this.currency);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LineItem{" + "id: " + id + ", project: " + project + ", vintageYear: " + vintageYear + ", amount: " + amount + ", unit: " + unit + ", price: " + price + ", currency: " + currency + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    ProjectStage id(ItemId id);

    Builder from(LineItem other);
  }

  public interface ProjectStage {
    VintageYearStage project(Project project);
  }

  public interface VintageYearStage {
    AmountStage vintageYear(int vintageYear);
  }

  public interface AmountStage {
    UnitStage amount(int amount);
  }

  public interface UnitStage {
    PriceStage unit(String unit);
  }

  public interface PriceStage {
    CurrencyStage price(int price);
  }

  public interface CurrencyStage {
    _FinalStage currency(String currency);
  }

  public interface _FinalStage {
    LineItem build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IdStage, ProjectStage, VintageYearStage, AmountStage, UnitStage, PriceStage, CurrencyStage, _FinalStage {
    private ItemId id;

    private Project project;

    private int vintageYear;

    private int amount;

    private String unit;

    private int price;

    private String currency;

    private Builder() {
    }

    @Override
    public Builder from(LineItem other) {
      id(other.getId());
      project(other.getProject());
      vintageYear(other.getVintageYear());
      amount(other.getAmount());
      unit(other.getUnit());
      price(other.getPrice());
      currency(other.getCurrency());
      return this;
    }

    @Override
    @JsonSetter("id")
    public ProjectStage id(ItemId id) {
      this.id = id;
      return this;
    }

    @Override
    @JsonSetter("project")
    public VintageYearStage project(Project project) {
      this.project = project;
      return this;
    }

    @Override
    @JsonSetter("vintage_year")
    public AmountStage vintageYear(int vintageYear) {
      this.vintageYear = vintageYear;
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
    public CurrencyStage price(int price) {
      this.price = price;
      return this;
    }

    @Override
    @JsonSetter("currency")
    public _FinalStage currency(String currency) {
      this.currency = currency;
      return this;
    }

    @Override
    public LineItem build() {
      return new LineItem(id, project, vintageYear, amount, unit, price, currency);
    }
  }
}
