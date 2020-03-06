Feature: Book a Flight - Happy Path

  Scenario Outline: (01) A registered user books a flight from Zurich To Paris on Pangea Airlines (Happy Path)
    Given user is registered with the following values:
      | FirstName | LastName | Phone       | Email                   | Address   | City  | UserName          | Password          | ConfirmPassword |
      | Silicon   | Expert   | 01027233449 | ayasadeksaleh@gmail.com | Nasr City | Cairo | "<userNameValue>" | "<passwordValue>" | 123456          |
    And user logged in as "<userNameValue>" with "<passwordValue>"
    When user books a flight with the following details:
      | DepartingFrom | Month   | Day | Airline        |
      | Zurich        | January | 9   | Pangea Airline |
    Then user makes sure that the booking details are true with the following details:
      | DepartingFrom | Month | Day | Airline        |
      | Zurich        | 1     | 9   | Pangea Airline |
    Examples:
      | userNameValue  | passwordValue |
      | Silicon Expert | 123456        |





