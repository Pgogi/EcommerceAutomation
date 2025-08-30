Feature: Ecommerce Login and Cart

  Scenario Outline: Verify login and add to cart functionality
    Given Open the application
    When User enters "<username>" and "<password>"
    And Click on login button
    Then Verify the title of the page
    When User adds product to cart
    And increases quantity "3"
    Then Verify total price is correct

    Examples:
      | username                       | password        |  
      | InvalidUser@gmail.com          | WrongPass       |  
      | prabhakargogi543@gmail.com     | Prabhu@17091989 |  
      | InvalidAgain@gmail.com         | Invalid         | 