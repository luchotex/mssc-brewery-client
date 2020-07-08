package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * @author Luis M. Kupferberg Ruiz (lkupferberg@overactive.com)
 * @created 2020-07-05 23:42
 */
@Component
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

  public static final String BEER_API_PATH = "/api/v1/beer/";
  private String apihost;

  private RestTemplate restTemplate;

  public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public BeerDto getBeerById(UUID beerId) {
    return restTemplate.getForObject(apihost + BEER_API_PATH + beerId.toString(), BeerDto.class);
  }

  public URI createNewBeer(BeerDto beerDto) {
    return restTemplate.postForLocation(apihost + BEER_API_PATH, beerDto);
  }

  public void updateBeerById(UUID beerId, BeerDto beerDto) {
    restTemplate.put(apihost + BEER_API_PATH + beerId.toString(), beerDto);
  }

  public void setApihost(String apihost) {
    this.apihost = apihost;
  }
}
