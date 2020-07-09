package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
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
    // given
    BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

    URI uri = client.createNewBeer(beerDto);

    assertNotNull(uri);

    assertNotNull(uri.getPath().contains(BreweryClient.BEER_API_PATH));
  }

  @Test
  void updateBeerById_successfulTest() {
    // given
    UUID beerId = UUID.randomUUID();

    BeerDto beerDto = BeerDto.builder().id(beerId).beerName("New Beer").build();

    client.updateBeerById(beerId, beerDto);
  }

  @Test
  void deleteBeerById_successfulTest() {

    client.deleteBeerById(UUID.randomUUID());
  }

  @Test
  void getCustomerById() {
    CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());

    assertNotNull(customerDto);
  }

  @Test
  void createNewCustomer_successfulTest() {
    // given
    CustomerDto customerDto = CustomerDto.builder().name("New Customer").build();

    URI uri = client.createNewCustomer(customerDto);

    assertNotNull(uri);

    assertNotNull(uri.getPath().contains(BreweryClient.CUSTOMER_API_PATH));
  }

  @Test
  void updateCustomerById_successfulTest() {
    // given
    UUID customerId = UUID.randomUUID();

    CustomerDto customerDto = CustomerDto.builder().id(customerId).name("New Customer").build();

    client.updateCustomerById(customerId, customerDto);
  }

  @Test
  void deleteCustomerById_successfulTest() {

    client.deleteCustomerById(UUID.randomUUID());
  }
}
