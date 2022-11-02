package com.patch.api.client.estimates;

import com.fern.java.jackson.ClientObjectMappers;
import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.patch.api.client.BearerAuth;
import com.patch.api.client.estimates.exceptions.CreateFlightEstimateException;
import com.patch.api.client.estimates.exceptions.RetrieveException;
import com.patch.api.client.estimates.exceptions.RetrieveListException;
import com.patch.api.client.estimates.types.CreateFlightEstimateRequest;
import com.patch.api.client.estimates.types.Estimate;
import com.patch.api.client.estimates.types.EstimateId;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/estimates")
interface EstimatesService {
  @GET
  @Path("/{id}")
  Estimate retrieve(@HeaderParam("Authorization") BearerAuth auth, @PathParam("id") EstimateId id)
      throws RetrieveException;

  @GET
  @Path("/")
  List<Estimate> retrieveList(@HeaderParam("Authorization") BearerAuth auth) throws
      RetrieveListException;

  @POST
  @Path("/flight")
  Estimate createFlightEstimate(@HeaderParam("Authorization") BearerAuth auth,
      CreateFlightEstimateRequest body) throws CreateFlightEstimateException;

  static EstimatesService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ClientObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ClientObjectMappers.JSON_MAPPER))
        .errorDecoder(new EstimatesServiceErrorDecoder()).target(EstimatesService.class, url);
  }
}
