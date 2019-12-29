# Money-Transfer API
Simple example of money-transfer rest api using pure java only

**How to build and run**

You can use Apache Netbeans or Eclipse to build and run the project from an IDE if you prefer, you can also use rich text-editor to build and run the project such as; Visual Studio Code. However, the project comes with distribution file which is a `jar` file and it requires java runtime. You can execute the file using following command.

First, go to the the `/dist/` folder and then,

`java -jar money-transfer-api-0.0.1.jar`

**Application's Limitation**

Instead of trying to build a production ready app, I have tried to show how a rest-api could be built using core java only, there are a few things missing and if I would get oppurtunity to do it for production I would do following:-

- More unit testing and additional functional testing using proper objects/methods mocking.
- Add end-2-end testing using some front-end testing technology such as; Selenium.
- Consider IoC container for dependency injection.
- The service logic needs a good amount of polishing.
- The api layer needs proper error handling as well as, returning proper message when api is failed or broken.
- And, in database side, I would be wiring up proper DB to store account information and transactions.
