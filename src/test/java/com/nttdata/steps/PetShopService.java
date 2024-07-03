package com.nttdata.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.given;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;

public class PetShopService {

    static private final String BASE_URL = "https://petstore.swagger.io/v2/store";
    Response response;

    @Step("I create a new order with {int}, {int}, {int}, {string}, {string} and {string}")
    public void orderCreation(String id, String petId, String quantity, String shipDate, String status, String complete) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": " + Integer.parseInt(id) + ",\n" +
                        "  \"petId\": " + Integer.parseInt(petId) + ",\n" +
                        "  \"quantity\": " + Integer.parseInt(quantity) + ",\n" +
                        "  \"shipDate\": \"" + shipDate + "\",\n" +
                        "  \"status\": \"" + status + "\",\n" +
                        "  \"complete\": " + Boolean.parseBoolean(complete) + "\n" +
                        "}")
                .log().all()
                .post(BASE_URL + "/order")
                .then()
                .log().all();
    }

    public void validateCodeResponse(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    public void validateId(String id) {
        assertThat(lastResponse().getBody().path("id"), equalTo(Integer.parseInt(id)));
    }

    public void validatePetId(String petId) {
        assertThat(lastResponse().getBody().path("petId"), equalTo(Integer.parseInt(petId)));
    }

    public void validateQuantity(String quantity) {
        assertThat(lastResponse().getBody().path("quantity"), equalTo(Integer.parseInt(quantity)));
    }

    public void validateShipDate(String shipDate) {
        String responseShipDate = lastResponse().getBody().path("shipDate");
        assertNotNull(responseShipDate);
    }

    public void validateStatus(String status) {
        assertThat(lastResponse().getBody().path("status"), equalTo(status));
    }

    public void validateComplete(String complete) {
        assertThat(lastResponse().getBody().path("complete"), equalTo(Boolean.parseBoolean(complete)));
    }

    @When("consulto la orden con orderId {int}")
    public void consultOrder(String id) {
        response = given()
                .pathParam("orderId", id)
                .when()
                .get(BASE_URL + "/order/{orderId}")
                .then()
                .extract().response();
    }

    public void validateResponseId(String id) {
        assertThat(lastResponse().jsonPath().getInt("id"), equalTo(Integer.parseInt(id)));
    }

    public void validateResponsePetId(String petId) {
        assertThat(lastResponse().jsonPath().getInt("petId"), equalTo(Integer.parseInt(petId)));
    }

    public void validateResponseQuantity(String quantity) {
        assertThat(lastResponse().jsonPath().getInt("quantity"), equalTo(Integer.parseInt(quantity)));
    }

    public void validateResponseDate(String date) {
        assertThat(lastResponse().jsonPath().getString("shipDate"), equalTo(date));
    }

    public void validateResponseStatus(String status) {
        assertThat(lastResponse().jsonPath().getString("status"), equalTo(status));
    }

    public void validateResponseComplete(String complete) {
        assertThat(lastResponse().jsonPath().getBoolean("status"), equalTo(Boolean.parseBoolean(complete)));
    }
}
