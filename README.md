# BDD Demo

This is an extremely bare bone project to demonstrate a simple test on marksandspencer.com using Java, BDD and Cucumber.

- To run it, clone the repository using the URL: https://github.com/deepankur/BDD-Demo.git
- Import the project in your preferred IDE as a Maven project.
- Right click on the project and select run as Maven Test.
- Alternatively you can run the project from Jenkins by running the high level goal "test".
- The tests are configured to run on a standalone machine with Firefox installed. 

## Assumptions

- There is an assumption that first product, first color and first size is in stock
- In real life, additional checks within the selectors can be added to make a conditional decision
- Product/Size/Color with out of stock attribute can be avoided using these attributes within selectors

## Useful information for improving this project

In real life, to run the tests on remote machine with different browsers in parallel, a separate class is created which provides thread safe pool of Static Webdriver object's instances. A lot of conditional configuration is also done in this class to make sure the tests run on all browsers. Path to browsers binary is set in this class and browsers profile is also configured in this class.

No modular architecture like Page Object Model is used. Hence, you will find Thread.sleep , which off course makes tests fragile.
Tests can fail in some conditions because of this, simply try it again or increase the wait. However it should be long enough for a decent internet connection.
In real life, using tests like this will be troublesome. Hence, separate page objects should be created for Home page, product details page, basket page etc.
Locating and manipulating elements is not done as part of the tests.
