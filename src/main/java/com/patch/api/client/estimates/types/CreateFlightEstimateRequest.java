package com.patch.api.client.estimates.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = CreateFlightEstimateRequest.Builder.class
)
public final class CreateFlightEstimateRequest {
  private final Optional<Integer> distanceM;

  private final Optional<String> originAirport;

  private final Optional<String> destinationAirport;

  private final Optional<String> aircraftCode;

  private final Optional<CabinClass> cabinClass;

  private final Optional<Integer> passengerCount;

  private final Optional<String> projectId;

  private final Optional<Boolean> createOrder;

  private int _cachedHashCode;

  CreateFlightEstimateRequest(Optional<Integer> distanceM, Optional<String> originAirport,
      Optional<String> destinationAirport, Optional<String> aircraftCode,
      Optional<CabinClass> cabinClass, Optional<Integer> passengerCount, Optional<String> projectId,
      Optional<Boolean> createOrder) {
    this.distanceM = distanceM;
    this.originAirport = originAirport;
    this.destinationAirport = destinationAirport;
    this.aircraftCode = aircraftCode;
    this.cabinClass = cabinClass;
    this.passengerCount = passengerCount;
    this.projectId = projectId;
    this.createOrder = createOrder;
  }

  @JsonProperty("distance_m")
  public Optional<Integer> getDistanceM() {
    return distanceM;
  }

  @JsonProperty("origin_airport")
  public Optional<String> getOriginAirport() {
    return originAirport;
  }

  @JsonProperty("destination_airport")
  public Optional<String> getDestinationAirport() {
    return destinationAirport;
  }

  @JsonProperty("aircraft_code")
  public Optional<String> getAircraftCode() {
    return aircraftCode;
  }

  @JsonProperty("cabin_class")
  public Optional<CabinClass> getCabinClass() {
    return cabinClass;
  }

  @JsonProperty("passenger_count")
  public Optional<Integer> getPassengerCount() {
    return passengerCount;
  }

  @JsonProperty("project_id")
  public Optional<String> getProjectId() {
    return projectId;
  }

  @JsonProperty("create_order")
  public Optional<Boolean> getCreateOrder() {
    return createOrder;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateFlightEstimateRequest && equalTo((CreateFlightEstimateRequest) other);
  }

  private boolean equalTo(CreateFlightEstimateRequest other) {
    return distanceM.equals(other.distanceM) && originAirport.equals(other.originAirport) && destinationAirport.equals(other.destinationAirport) && aircraftCode.equals(other.aircraftCode) && cabinClass.equals(other.cabinClass) && passengerCount.equals(other.passengerCount) && projectId.equals(other.projectId) && createOrder.equals(other.createOrder);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.distanceM, this.originAirport, this.destinationAirport, this.aircraftCode, this.cabinClass, this.passengerCount, this.projectId, this.createOrder);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateFlightEstimateRequest{" + "distanceM: " + distanceM + ", originAirport: " + originAirport + ", destinationAirport: " + destinationAirport + ", aircraftCode: " + aircraftCode + ", cabinClass: " + cabinClass + ", passengerCount: " + passengerCount + ", projectId: " + projectId + ", createOrder: " + createOrder + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Integer> distanceM = Optional.empty();

    private Optional<String> originAirport = Optional.empty();

    private Optional<String> destinationAirport = Optional.empty();

    private Optional<String> aircraftCode = Optional.empty();

    private Optional<CabinClass> cabinClass = Optional.empty();

    private Optional<Integer> passengerCount = Optional.empty();

    private Optional<String> projectId = Optional.empty();

    private Optional<Boolean> createOrder = Optional.empty();

    private Builder() {
    }

    public Builder from(CreateFlightEstimateRequest other) {
      distanceM(other.getDistanceM());
      originAirport(other.getOriginAirport());
      destinationAirport(other.getDestinationAirport());
      aircraftCode(other.getAircraftCode());
      cabinClass(other.getCabinClass());
      passengerCount(other.getPassengerCount());
      projectId(other.getProjectId());
      createOrder(other.getCreateOrder());
      return this;
    }

    @JsonSetter(
        value = "distance_m",
        nulls = Nulls.SKIP
    )
    public Builder distanceM(Optional<Integer> distanceM) {
      this.distanceM = distanceM;
      return this;
    }

    public Builder distanceM(Integer distanceM) {
      this.distanceM = Optional.of(distanceM);
      return this;
    }

    @JsonSetter(
        value = "origin_airport",
        nulls = Nulls.SKIP
    )
    public Builder originAirport(Optional<String> originAirport) {
      this.originAirport = originAirport;
      return this;
    }

    public Builder originAirport(String originAirport) {
      this.originAirport = Optional.of(originAirport);
      return this;
    }

    @JsonSetter(
        value = "destination_airport",
        nulls = Nulls.SKIP
    )
    public Builder destinationAirport(Optional<String> destinationAirport) {
      this.destinationAirport = destinationAirport;
      return this;
    }

    public Builder destinationAirport(String destinationAirport) {
      this.destinationAirport = Optional.of(destinationAirport);
      return this;
    }

    @JsonSetter(
        value = "aircraft_code",
        nulls = Nulls.SKIP
    )
    public Builder aircraftCode(Optional<String> aircraftCode) {
      this.aircraftCode = aircraftCode;
      return this;
    }

    public Builder aircraftCode(String aircraftCode) {
      this.aircraftCode = Optional.of(aircraftCode);
      return this;
    }

    @JsonSetter(
        value = "cabin_class",
        nulls = Nulls.SKIP
    )
    public Builder cabinClass(Optional<CabinClass> cabinClass) {
      this.cabinClass = cabinClass;
      return this;
    }

    public Builder cabinClass(CabinClass cabinClass) {
      this.cabinClass = Optional.of(cabinClass);
      return this;
    }

    @JsonSetter(
        value = "passenger_count",
        nulls = Nulls.SKIP
    )
    public Builder passengerCount(Optional<Integer> passengerCount) {
      this.passengerCount = passengerCount;
      return this;
    }

    public Builder passengerCount(Integer passengerCount) {
      this.passengerCount = Optional.of(passengerCount);
      return this;
    }

    @JsonSetter(
        value = "project_id",
        nulls = Nulls.SKIP
    )
    public Builder projectId(Optional<String> projectId) {
      this.projectId = projectId;
      return this;
    }

    public Builder projectId(String projectId) {
      this.projectId = Optional.of(projectId);
      return this;
    }

    @JsonSetter(
        value = "create_order",
        nulls = Nulls.SKIP
    )
    public Builder createOrder(Optional<Boolean> createOrder) {
      this.createOrder = createOrder;
      return this;
    }

    public Builder createOrder(Boolean createOrder) {
      this.createOrder = Optional.of(createOrder);
      return this;
    }

    public CreateFlightEstimateRequest build() {
      return new CreateFlightEstimateRequest(distanceM, originAirport, destinationAirport, aircraftCode, cabinClass, passengerCount, projectId, createOrder);
    }
  }
}
