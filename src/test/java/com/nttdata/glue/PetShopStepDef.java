package com.nttdata.glue;

import com.nttdata.steps.PetShopService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;


public class PetShopStepDef {

    @Steps
    PetShopService petShopService;

    @Given("Since I am in the store")
    public void sinceIAmInTheStore() {
    }

    @When("I create a new order with id {string}, petId {string}, quantity {string},shipDate {string}, status {string} and complete {string}")
    public void iCreateANewOrderWithIdPetIdQuantityShipDateStatusAndComplete(String id, String petId, String quantity, String shipDate, String status, String complete) {
        petShopService.orderCreation(id, petId, quantity, shipDate, status, complete);
    }

    @Then("the status code of the response is {int}")
    public void theStatusCodeOfTheResponseIs(int statusCode) {
        petShopService.validateCodeResponse(statusCode);
    }

    @Then("validate that the id is {string}")
    public void validateThatTheIdIs(String id) {
        petShopService.validateId(id);
    }

    @Then("validate that the petId is {string}")
    public void validateThatThePetIdIs(String petId) {
        petShopService.validatePetId(petId);
    }

    @Then("validate that the quantity is {string}")
    public void validateThatTheQuantityIs(String quantity) {
        petShopService.validateQuantity(quantity);
    }

    @Then("validate that the shipDate is {string}")
    public void validateThatTheShipDateIs(String shipDate) {
        petShopService.validateShipDate(shipDate);

    }

    @Then("validate that the status is {string}")
    public void validateThatTheStatusIs(String status) {
        petShopService.validateStatus(status);
    }

    @Then("validate that the complete is {string}")
    public void validateThatTheCompleteIs(String complete) {
        petShopService.validateComplete(complete);
    }

    @When("querying the order by ID it is {string}")
    public void queryingTheOrderByIDItIs(String id) {
        petShopService.consultOrder(id);
    }

    @Then("validate that the id response is {string}")
    public void validateThatTheIdResponseIs(String id) {
        petShopService.validateResponseId(id);
    }

    @Then("validate that the petId response is {string}")
    public void validateThatThePetIdResponseIs(String petId) {
        petShopService.validateResponsePetId(petId);
    }

    @Then("validate that the quantity response is {string}")
    public void validateThatTheQuantityResponseIs(String quantity) {
        petShopService.validateResponseQuantity(quantity);
    }

    @Then("validate that the shipping date response is {string}")
    public void validateThatTheShippingDateResponseIs(String date) {
        petShopService.validateResponseDate(date);
    }

    @Then("validate that the status response is {string}")
    public void validateThatTheStatusResponseIs(String status) {
        petShopService.validateResponseStatus(status);
    }

    @Then("validate that the complete response is {string}")
    public void validateThatTheResponseIs(String complete) {
        petShopService.validateResponseComplete(complete);
    }

    @Then("the validate status code of the response is {int}")
    public void theValidateStatusCodeOfTheResponseIs(int arg0) {
        petShopService.validateCodeResponse(arg0);
    }
}
