#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
#Feature: Title of your feature
  #I want to use this template for my feature file
#
  #@tag1
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes
#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
Feature: Manage BankCRUD accounts

  @bankCreate @regression
  Scenario: Create a customer's bank account
    When I am sending "POST" request to this endpoint "/api/accounts" with JSON body
      """
      {
        "customerName": "muhammad",
        "accountNumber": "1",
        "balance": 99999999
      }
      """
    Then the response status code should be 200
    And Verifying the following values
      | VAL | customerName  | muhammad        |
      | VAL | accountNumber | 1 |
      | VAL | balance       |          99999999 |

  @GET_one @regression
  Scenario Outline: Retrieve an existing account
    When I am sending "GET" request to this endpoint "/api/accounts/<id>"
    Then the response status code should be 200
    And Verifying the following values
      | VAL | customerName  | <customerName>  |
      | VAL | accountNumber | <accountNumber> |
      | VAL | balance       | <balance>       |

    Examples:
      | id | customerName | accountNumber | balance |
      |  4 | up_mahfuz    |          9999 |    2222 |
      #|  2 | first        | 1111111111111 | 123456789.0 |
      #|  3 | habibi       |         33333 |  55055500.0 |

  @PUT_UPDATE @regression
  Scenario: Update an existing customer's bank account
    When I am sending "GET" request to this endpoint "/api/accounts/<id>"
    When I am sending "PUT" request to this endpoint "/api/accounts/<id>" with JSON body
      """
      {
        "customerName": "up_mahfuz",
        "accountNumber": "9999",
        "balance": 2222
      }
      """
    Then the response status code should be 200
    And Verifying the following values
      | VAL | customerName  | <customerName>  |
      | VAL | accountNumber | <accountNumber> |
      | VAL | balance       | <balance>       |
    When I am sending "GET" request to this endpoint "/api/accounts/<id>"
    Then the response status code should be 200
    And Verifying the following values
      | VAL | customerName  | <customerName>  |
      | VAL | accountNumber | <accountNumber> |
      | VAL | balance       | <balance>       |

    Examples:
      | id | customerName | accountNumber | balance |
      |  4 | up_mahfuz    |          9999 |    2222 |

  @DELETE_one
  Scenario Outline: Delete one bank account
    When I am sending "DELETE" request to this endpoint "/api/accounts/<id>"
    Then the response status code should be 200
    And the response body should be "Bank account deleted successfully"

    Examples:
      | id |
      |  5 |

  @getAccountsByID @regression
  Scenario Outline: get one account by ID
    When I am sending "GET" request to this endpoint "/api/accounts/<id>"
    Then the response status code should be 200

    Examples:
      | id |
      |  3 |

  @all_accounts @regression
  Scenario Outline: get all the customer info
    When I am sending "GET" request to this endpoint "/api/accounts"
    Then the response status code should be 200
