<link rel='stylesheet' href='web/swiss.css'/>

# Lab session 3: Business Intelligence from Twitter Data

In this exercise, we are going to develop a web application that obtains some business intelligence from Twitter data, already extracted via [twurl](https://github.com/twitter/twurl).

The [codebase](./), implementing the skeleton of the web app, facilitated to do the exercise is built atop the [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#spring-web) framework using Groovy for implementing the logic and the views are implemented using [JavaServer Pages](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-view-jsp).

The codebase provided for this exercise is going to be very similar to the one provided for doing the [miniproject](https://github.com/uol-inf/CO7X17-17-18/blob/master/partI/miniproject1.md).


## Programming exercises 


* To run the web app, choose one of the following options (as explained in [lecture recording 3b](https://github.com/uol-inf/CO7X17-17-18/blob/master/partI/mu3.md#lectures)):
  * From a Bash shell: 
    * `cd` to the folder of the project
    * `./gradlew clean bootRun` starts the web server
    * `CTRL-C` stops the server
  * From the STS, in perspective `Spring` and view `Boot Dashboard`, click on the project `twitter_exercises` and the run button. 
* The JSON files under [src/main/resources/twitter](./src/main/resources/twitter) provide some sample data that can be retrieved from Twitter using `twurl`. 

Access the web app at [http://localhost:8080](http://localhost:8080).

### Exercise 1: followers report 

In the controller [IndexController](./src/main/groovy/lab3/reports/IndexController.groovy), add code to the handler method `followers()` in order to list all the friends that are also followers.

Your code should extract data from the files `friends.json`  and `followers.json`  under [src/main/resources/twitter](./src/main/resources/twitter) using `JsonSlurper`.

### Exercise 2: friends report 

In the controller [IndexController](./src/main/groovy/lab3/reports/IndexController.groovy), add code to the handler method `friends()` in order to mine some intelligence about the provided Twitter data.

For each friend, add an object `FriendDto` into the list `friends` with the following information:
  * `name`: your friend `name`
  * `description`: your friend description
  * `noTweets`: their number of tweets (up to 10)
  * `noFavoriteTweets`: the overall number of *likes* (aggregated favorite count for all tweets) for their selected tweets (those counted above) 
  * `noPopularTweets`: the number of popular tweets (whose whose favorite count is greater than 5) for their selected tweets (those counted above) 

Your code should extract data from the files under [src/main/resources/twitter](./src/main/resources/twitter) using `JsonSlurper`.



