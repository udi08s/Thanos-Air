# Thanos Air - Selenium Test Example 

This is the sample project to demostrate the usage of selenium Webdriver tool to automate Flight booking system.


# <h3>Software Requirement:
* Java 8 - JDK
* Eclipse/ IntelliJ
* TestNG plugin for Eclipse
* Maven
* Chrome Browser
  
# <h3>Project Structure:
  * All the tests goes under below package:<br />
      
      >com.testingfoo.thanosair.test
  
  * All the Page Files goes under below package:<br />
      
      >com.testingfoo.thanosair.pages
      
  * Chromedriver goes under **Resources -> Executable folder**. 
  
  * Update the Local Machine OS and Browser details in the **Config.properties** file under **Resources -> Properties folder**. <br/>
  
# <h3>How to run this test?
  
  Two ways to run the test:
  1. **Using IDE**:
     * Clone this repository to the local machine.
     * Open the IDE of your choice. ( Say : Eclipse)
     * Click on File -> Import -> Maven -> Import Existing maven project.
     * Once the import is successful, Right click on POM.xml file. Select Run as -> Maven Build.
     * Once the Maven build is successful, Right click on POM.xml file. Select Run as -> Maven Clean.
     * Navigate to Resources-> Runner-> Right click on runnertestng.xml file. Select Run as -> TestNG Suite.
  
  2. **Using Terminal**:
     * Clone this repository to the local machine.
     * Open the terminal and navigate to the folder with POM.xml file.
     * Run the below command to run a specific test file.
      ( **Ex**: TestClass: FlightBooking )
       
       >mvn test -Dtest=FlightBooking
       
**Note**: </br>
1.If script doesnt work due to incorrect chromedriver version, download the chrome driver for the respective chrome browser version & OS and replace the same under Resources -> Executable folder. </br>
**Ex**: If the script is executed in Chrome and Windows OS, then download the latest version of chromedriver.exe and copy paste the downloaded chromedriver.exe under Resource -> Executable folder. </br> 
2. Dont forget to update the config.properties folder before executing the test. </br> 
3. Try to maintain same names for chromedriver and geckodriver in the resource folder. If the script fails due to incorrect file names, you can change the destination of chromedriver in the TestBase.java class for respective OS & browser.
  
 

