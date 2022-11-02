package com.patch.api.client.estimates;

import com.fern.java.jackson.ClientObjectMappers;
import com.patch.api.client.estimates.exceptions.CreateFlightEstimateException;
import com.patch.api.client.estimates.exceptions.RetrieveException;
import com.patch.api.client.estimates.exceptions.RetrieveListException;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class EstimatesServiceErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("retrieve")) {
        return decodeException(response, RetrieveException.class);
      }
      if (methodKey.contains("retrieveList")) {
        return decodeException(response, RetrieveListException.class);
      }
      if (methodKey.contains("createFlightEstimate")) {
        return decodeException(response, CreateFlightEstimateException.class);
      }
    }
    catch (IOException e) {
    }
    return new RuntimeException("Failed to read response body. Received status " + response.status() + " for method " + methodKey);
  }

  private static <T extends Exception> Exception decodeException(Response response, Class<T> clazz)
      throws IOException {
    return ClientObjectMappers.JSON_MAPPER.reader().withAttribute("statusCode", response.status()).readValue(response.body().asInputStream(), clazz);
  }
}
