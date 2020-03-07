Feature: Book a Flight - Happy Path

  Scenario Outline: (01) A registered user books a flight from Zurich To Paris on Pangea Airlines (Happy Path)
    Given user registers with the following values:
      | FirstName | LastName | Phone       | Email                   | Address   | City  | UserName          | Password          | ConfirmPassword |
      | Silicon   | Expert   | 01027233449 | ayasadeksaleh@gmail.com | Nasr City | Cairo | "<userNameValue>" | "<passwordValue>" | 123456          |
    And user logs in as "<userNameValue>" with "<passwordValue>"
    When user books a flight with the following details:
      | DepartingFrom | Month   | Day | Airline        |
      | Zurich        | January | 9   | Pangea Airline |
    Then user makes sure that the booking details are true with the following details:
      | DepartingFrom | Month | Day | Airline        |
      | Zurich        | 1     | 9   | Pangea Airline |
    And user checks out the lowest price destination
    Examples:
      | userNameValue  | passwordValue |
      | Silicon Expert | 123456        |

  Scenario: (02) User that is not registered tries to book a flight (Validations)
    Given user opened the website URL
    When user tries to open flights page
    Then home page is still opened and user can't go to flights page


  Scenario Outline: (03) User tries to book a flight with invalid username or password (Validations)
    Given user opened the website URL
    When user tries to login with "<userNameValue>" with "<passwordValue>"
    Then sign on page is still opened and user can't go to home page
    Examples:
      | userNameValue         | passwordValue |
      | Silicon Expert User 1 | 123456        |
      | Silicon Expert        | 123           |
      | Silicon Expert User 1 | 123           |
      | -*/&%                 | 123456        |
      | Silicon Expert        |               |

    Scenario: (04) Make sure that user is not logged out when user navigates back after login
      Given user opened the website URL
      And user is logged in as "Silicon Expert" with "123456"
      When user navigates back from browser and forward again to home page
      Then user is still logged in and home page opens successfully





