package com.patch.api.client.estimates;

import com.patch.api.client.BearerAuth;
import com.patch.api.client.estimates.endpoints.CreateFlightEstimate;
import com.patch.api.client.estimates.endpoints.Retrieve;
import com.patch.api.client.estimates.endpoints.RetrieveList;
import com.patch.api.client.estimates.exceptions.CreateFlightEstimateException;
import com.patch.api.client.estimates.exceptions.RetrieveException;
import com.patch.api.client.estimates.exceptions.RetrieveListException;
import com.patch.api.client.estimates.types.Estimate;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.List;
import java.util.Optional;

public final class EstimatesServiceClient {
  private final EstimatesService service;

  private final Optional<BearerAuth> auth;

  public EstimatesServiceClient(String url) {
    this.service = EstimatesService.getClient(url);
    this.auth = Optional.empty();
  }

  public EstimatesServiceClient(String url, BearerAuth auth) {
    this.service = EstimatesService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public Estimate retrieve(Retrieve.Request request) throws RetrieveException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for retrieve")));
    return this.service.retrieve(authValue, request.getId());
  }

  public List<Estimate> retrieveList(RetrieveList.Request request) throws RetrieveListException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for retrieveList")));
    return this.service.retrieveList(authValue);
  }

  public Estimate createFlightEstimate(CreateFlightEstimate.Request request) throws
      CreateFlightEstimateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for createFlightEstimate")));
    return this.service.createFlightEstimate(authValue, request.getBody());
  }
}
