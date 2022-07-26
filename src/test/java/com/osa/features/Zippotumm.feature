Feature: All the common steps we will have in this feature file



Scenario: customer api POST call varification
    Given the authentication is completed here
#	 	When I am sending "POST" request to this endpoint "/customers"
#				|STA|statusCode     |200   |
#	 		 	|BOD|myTestData.xlsx|A:3   |
#	 		 	|VAR|_id            |xyz|
#	 	Given the authentication is completed here
   # When I am sending "GET" request to this endpoint "/customers/<xyz>"
    When I am sending "GET" request to this endpoint "/de/24848"
    
#			|STA|statusCode|200|
	Then Verifying the following values
      |VAL|places[0].'place name'|Alt Bennebek|
      |VAL|country|Germany|
      |VAL|'country abbreviation'	|DE	 		|
    	|VAL|'post code'		|24848					|
    #	|VAL|email		|mitul.li@yahoo.com	|
