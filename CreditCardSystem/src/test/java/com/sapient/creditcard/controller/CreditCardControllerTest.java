package com.sapient.creditcard.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.creditcard.model.CreditCard;
import com.sapient.creditcard.repository.CardRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql")
class CreditCardControllerTest {
  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper mapper;

  @Autowired private  CardRepository repository;

  @Test
  @DisplayName("When all cards are requested then they are all returned")
  void allCardsRequested() throws Exception {
    mockMvc
        .perform(get("/getAll"))
        .andExpect(status().is2xxSuccessful())
        .andExpect(jsonPath("$", hasSize((int) repository.count())));
  }

  @Test
  @DisplayName("When a card creation is requested then it is persisted")
  void cardCreatedCorrectly() throws Exception {
   
	CreditCard newCard = new CreditCard(1l,"Steve", "79927398713", 1000, 0.0);

    Long newCardId =
        mapper
            .readValue(
                mockMvc
                    .perform(
                        post("/add")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(mapper.writeValueAsString(newCard)))
                    .andExpect(status().isCreated())
                    .andReturn()
                    .getResponse()
                    .getContentAsString(),
                CreditCard.class)
            .getId();

    newCard.setId(newCardId); // Populate the ID of the card after successful creation

    assertThat(
        repository
            .findById(newCardId)
            .orElseThrow(
                () -> new IllegalStateException("New Card has not been saved in the repository")),
        equalTo(newCard));
  }
  
  @Test
  @DisplayName("When a invalid card creation is requested then bad request is thrown")
  void cardNotCreated() throws Exception {
	  CreditCard newCard = new CreditCard(1l,"Sam", "11112222333344441", 1000, 0.0);
	  mockMvc
	  .perform(
			  post("/add")
			  .contentType(MediaType.APPLICATION_JSON)
			  .content(mapper.writeValueAsString(newCard)))
	  .andExpect(status().isBadRequest());

  }
}
