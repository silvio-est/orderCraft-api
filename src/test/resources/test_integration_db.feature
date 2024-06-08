Feature: Test Integration to the data base OrderCraft_DB

  Scenario: Test to table order_craft_user
    Given Register credentials user of the data base
    When The data is userName = "userTest", password = passwordTest and Role = "ADMIN"
    Then The user save in the data base