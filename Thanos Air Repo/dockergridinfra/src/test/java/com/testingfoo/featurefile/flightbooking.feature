Feature: Flight Booking. 
	Existing user should be able to book flight tickets
		 by adding additional bags.
		 
Scenario Outline: Flight Booking with additional bags 
	Given User navigates to qantas website 
	And User selects the destination 
	And User selects One way Option 
	And User selects dates 
	When User clicks on Search 
	Then User should be taken to the search page
	Given User selects Red e-deal
	When user selects add trip
	Then SubTotal Value should be Zero
	Given User clicks on continue button in flight selection page
	And User clicks on continue button in flight points page
	And User clicks on Accept Fare button in the fare condition page
	When User selects Add Bags option in the Flight Options page
	Then User should be able to add "<bags>" additional baggage to the journey 
	
	Examples:
    | bags| 
    |  1  | 
    |  2  | 
    |  3  | 
    |  4  | 
    |  5  |