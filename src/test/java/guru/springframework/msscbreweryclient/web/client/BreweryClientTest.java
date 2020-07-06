package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BreweryClientTest {

  @Autowired private BreweryClient client;

  @Test
  void getBeerById() {
    BeerDto beerDto = client.getBeerById(UUID.randomUUID());

    assertNotNull(beerDto);
  }

  @Test
  void createNewBeer_successfulTest() {
    //given
    BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

    URI uri = client.createNewBeer(beerDto);

    assertNotNull(uri);

    assertNotNull(uri.getPath().contains(BreweryClient.BEER_API_PATH));


  }
}
