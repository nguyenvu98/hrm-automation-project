# Selenium TestNG Page Factory Extended

### This is a sample project to demonstrate high readable test automation implementation with Selenium + Page Factory and Page Object Model + TestNG + Java.
The framework uses:
* Java
* Selenium
* TestNG
* ExtentReport

### Steps to create test cases:
1. Package introduction:
- **commons**: contains BasePageFactory files containing methods to interact with Selenium Webdriver and BaseTest contains functions that initialize precondition for test cases. In addition, it also contains other files used to store data.
- **pageObject**: I have @FindBy supports accessing elements on the page through a variety of attributes such as TagName, PartialLinkText, Name, LinkText, Id, Css, ClassName, XPath. This will help users create Page Objects more quickly and easily. In addition, this also contains the main methods used to perform the behavior of the pages according to the test scenario.
- **reportConfig**: contains functions that handle extentReport.
- **pageUIs**: contains the locators used for that page.
- **resource**: contains the runtest file.

2. Reporting
In this project I use Extent Report version 2
