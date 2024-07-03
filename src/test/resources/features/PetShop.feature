@ServicePetShop
Feature: Shop
  @OrderCreation
  Scenario Outline: Order Creation
    Given Since I am in the store
    When I create a new order with id "<id>", petId "<petId>", quantity "<quantity>",shipDate "<shipDate>", status "<status>" and complete "<complete>"
    Then the status code of the response is 200
    Then validate that the id is "<id>"
    Then validate that the petId is "<petId>"
    Then validate that the quantity is "<quantity>"
    Then validate that the shipDate is "<shipDate>"
    Then validate that the status is "<status>"
    Then validate that the complete is "<complete>"
    Examples:
      | id | petId | quantity | shipDate             | status | complete |
      | 1  | 1     | 500      | 2024-06-22T06:09:23.477Z | placed | true     |


  @OrderConsultation
  Scenario Outline: Order consultation
    Given Since I am in the store
    When querying the order by ID it is "<id>"
    Then the validate status code of the response is 200
    Then validate that the id response is "<id>"
    Then validate that the petId response is "<petId>"
    Then validate that the quantity response is "<quantity>"
    Then validate that the shipping date response is "<shipDate>"
    Then validate that the status response is "<status>"
    Then validate that the complete response is "<complete>"
    Examples:
      | id | petId | quantity | shipDate             | status | complete |
      | 8  | 3     | 2      | 2024-07-03T00:00:36.617+0000 | placed | false     |


