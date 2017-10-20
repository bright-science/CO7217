# Miniproject I - Agile Cloud Automation (CO4217/CO7217/CO7517)

## Cloud integration: Twitter and mLab (MongoDB cloud provider)

In this miniproject, we are going to develop a web application that fetches information from a Twitter account using a [REST API](https://developer.twitter.com/en/docs) via OAuth1, storing it in a MongoDB instance on the Cloud using [mLab](https://mlab.com/). Our application will then obtain some business intelligence from the data extracted using the [Java MongoDB API](http://mongodb.github.io/mongo-java-driver/3.5/javadoc/) from Groovy (via [GMongo](https://github.com/poiati/gmongo)).

The [codebase](https://github.com/uol-inf/CO7X17-17-18/tree/master/partI/CO7X17.miniproject1), implementing the skeleton of the web app, facilitated to do the miniproject is built atop the [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#spring-web) framework using Groovy for implementing the logic and [JavaServer Pages](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-view-jsp) for implementing the views.


## Disclaimer on Plagiarism and Collusion

This is an **individual piece of coursework** that is assessed. Plagiarism, including collusion, is penalized. For further information check the [section Referencing and Academic Integrity in the BSc handbook](https://campus.cs.le.ac.uk/ForStudents/handbooks17/MScStudentHandbook2017-18.pdf).

By submitting your solution, you are stating that you are aware of the consequences, as summarized in the [Declaration of Academic Honesty](https://campus.cs.le.ac.uk/ForStudents/plagiarism/DoAIF.pdf) that you signed already, and that the solution provided for the worksheet is the result of your **sole individual work**.


## Programming exercises [60 marks]

## Setup

* Copy the project `CO7X17.miniproject1` under `partI` in the local copy of your private repository. 
* Import the project into your workspace using `Gradle Buildship 2`.


### Migration process setup

There are several clients for the Twitter API that allow us to query data on Twitter. We are going to make calls to the REST API directly via [twurl](https://developer.twitter.com/en/docs/tutorials/using-twurl) copying data in bulk once.

The data migration process is achieved by executing from a shell terminal the command `./twitterMigrate.sh`. The script will show a URL which should be pasted on to a browser and the PIN obtained should be pasted on the terminal. Once authorization is successful, friends and follower's tweets will be filtered and copied onto your MongoDB database on mLab (once you finish exercise 1).

The script will not work straight away. Please configure it as follows:
* Installation process: 
  * A Bash shell is needed for executing the script `./twitterMigrate.sh`. If you are working on Windows, follow [these instructions](https://github.com/uol-inf/CO7X17-17-18/blob/master/tooling.md#for-windows-10-users).
  * Install `twurl`, to connect to the Twitter REST API, as described [here](https://github.com/twitter/twurl). You may need to install [Ruby Gems](https://rubygems.org/pages/download).
  * Install `jq`, to pretty print JSON in files (optional), as described [here](https://stedolan.github.io/jq/download/) 
    * if you don't want to install it, remove `| jq .` from the commands in the script `./twitterMigrate.sh` 
* Configuration:  
  * Configure the data store connection as done for the lab2 exercise in class miniproject1.mongoDb.MongoDB
  * Do exercise 1.
* Execution: the script can be executed by using the command `./twitterMigrate.sh` on a Bash shell.
  * By default it uses an upper bound of `10` records when calling the Twitter API (i.e. return the first 10 friends or the first 10 tweets).
  * This can be changed by passing a number as argument to the script, e.g. `./twitterMigrate.sh 20`.

### Exercise 1: fetching data from Twitter [30 marks]

In class `miniproject1.mongoDb.BulkTransfer`, implement the code necessary to transfer data from the stored JSON files in your `MongoDB` instance on `mLab`.  The database should contain two collections of documents:
* `friends`: containing information about friends and their tweets. 
* `followers`: containing information about followers and their tweets. 

Take into account the following requirements:
* Denormalization is going to be applied and a user may be stored in both collections and, therefore, their tweets will also be stored twice.
* Each user (friend or follower) must contain its tweets in a new field `tweet`.
* Store the following information about friends and followers

		id_str,
		name,
		description,
		favorites_count,
		followers_count,
		friends_count,
		language,
		location,
		screen_name,
		url,
		utc_offset
			
* Store the following information about tweets
	
		id_str,
		created_at,
		entities,
		favorite_count,
		favorited,
		user.id_str,
		in_reply_to_screen_name,
		in_reply_to_status_id,
		in_reply_to_user_id,
		language_code,
		retweet_count,
		retweeted,
		source,
		text

To fetch JSON documents from Twitter for testing your scripts without pushing them to your MongoDB instance, comment the line `./gradlew migrateToMongoDb` in the shell script `twitterMigrate.sh` using `#`, that is:

	# ./gradlew migrateToMongoDb

#### Marking guidelines:

The migration process must be executable by running `./twitterMigrate 10` from a shell terminal. If there are compilation/runtime errors or this command cannot be executed for other technical reasons, a mark of **0** (**zero**) will be awarded. 

The implementation of functional requirements will be marked as follows:
* Information about friends is migrated to mLab. **[10 marks]**	
* Information about followers is migrated to mLab. **[10 marks]**	
* The command `./twitterMigrate 10` executes without problems, doing what it is intended to do. **[10 marks]**	

### Exercise 2: followers report [10 marks]

In the controller `IndexController`, add code to the handler method `followers` in order to list all your follower that have tweets that mention `martinfowler`, i.e. `screen_name=='martinfowler'` for an entity `user_mentions` in a tweet published by your follower. 

The controller **must get the information from the data on your MongoDB instance on mLab**, and not from the JSON files directly.

For the sample data provided in `src/main/resources/twitter/`, the result should be:

<img src="web/followers.png" height="300">

#### Marking guidelines:

The web app must be executable by using `./gradlew bootRun`. If there are compilation errors or this command cannot be executed for other technical reasons, a mark of **0** (**zero**) will be awarded. 

The implementation of functional requirements will be marked as follows:
* Followers are listed. **[2.5 marks]**
* Only those followers who mentioned 'martinfowler' in their tweets are listed. **[7.5 marks]**


### Exercise 3: friends report [20 marks]

In the controller `IndexController`, add code to the handler method `friends` in order to mine some intelligence about your Twitter account:

For each friend, add an object `FriendDto` into the list `friends` with the following information:
  * `name`: your friend `name`
  * `description`: your friend description
  * `noTweets`: their number of tweets (up to 10)
  * `noRetweets`: the overall number of *retweets* (aggregated retweet count for all tweets) for their selected tweets (those fetched from twurl or in the sample files)
  * `noActiveTweets`: the number of tweets that have caused discussion (whose whose retweet count is greater than 100) for their selected tweets (those fetched from twurl or in the sample files)  

The controller **must get the information from the data on your MongoDB instance on mLab**, and not from the JSON files directly.

For the sample data provided in `src/main/resources/twitter/`, the result should be:

<img src="web/friends.png" height="500">

#### Marking guidelines:

The web app must be executable by using `./gradlew bootRun`. If there are compilation errors or this command cannot be executed for other technical reasons, a mark of **0** (**zero**) will be awarded. 

The implementation of functional requirements will be marked as follows:
* fields `name`, `description` and `noTweets` extracted correctly for up to 10 friends. **[5 marks]**	
* field `noRetweets` extracted correctly for up to 10 friends. **[7.5 marks]**
* field `noActiveTweets` extracted correctly for up to 10 friends. **[7.5 marks]**	




## NoSQL (essay) [40 marks]

Discuss the architecture of Twitter from an scalability point of view, after watching this presentation on [Real-Time Delivery Architecture at Twitter](https://www.infoq.com/presentations/Real-Time-Delivery-Twitter) by [Raffi Krikorian](https://en.wikipedia.org/wiki/Raffi_Krikorian) at that time working for Twitter. Specifically:
  * Discuss the NoSQL data stores used addressing the following questions: **[max. 250 words (excl. images and references), 15 marks]**
    * What NoSQL store has been used?
    * What features are provided by that chosen NoSQL store?
    * Why has it been chosen?
  * Discuss how partitioning and replication is implemented in the architecture of Twitter. **[max. 250 words (excl. images and references), 25 marks]**

Other references that may be helpful are:
  * [The Architecture Twitter Uses To Deal With 150M Active Users, 300K QPS, A 22 MB/S Firehose, And Send Tweets In Under 5 Seconds](http://highscalability.com/blog/2013/7/8/the-architecture-twitter-uses-to-deal-with-150m-active-users.html)
  * [Scaling Twitter: Making Twitter 10000 Percent Faster](http://highscalability.com/scaling-twitter-making-twitter-10000-percent-faster)
  * [The infrastructure behind Twitter (scale)](https://blog.twitter.com/engineering/en_us/topics/infrastructure/2017/the-infrastructure-behind-twitter-scale.html) 
  * [The infrastructure behind Twitter (efficiency and optimization)](https://blog.twitter.com/engineering/en_us/topics/infrastructure/2016/the-infrastructure-behind-twitter-efficiency-and-optimization.html) 
  * Pramod J. Sadalage; Martin Fowler. NoSQL Distilled: A Brief Guide to the Emerging World of Polyglot Persistence. Addison-Wesley Professional.  (available on the [Library catalogue](http://proquest.safaribooksonline.com.ezproxy3.lib.le.ac.uk/book/databases/9780133036138))
  
Note that you are invited to do some research of your own. 

### Marking guidelines

* **Distinction**: The essay includes a objective view on the technology and techniques discussed in the module, demonstrating deep, analytic comprehension of the approaches and tools used to design a software architecture using NoSQL technology. The student is able to relate these to alternative approaches and tools that may not have been discussed in the module. The document is well written, following a logical structure and using a consistent style and professional layout.
* **Merit**: The essay includes a objective view on the technology and techniques discussed in the module, demonstrating a clear comprehension of the approaches and tools used.  The solution document is well written, using a consistent style and professional layout.
* **Pass**: The essay includes a discussion of the technology and techniques discussed in the module, demonstrating a basic comprehension of the approaches and tools used. The solution document is well written and clearly readable. 

### Support resources for the essay

* University online study guides:
  * [Academic writing](https://www2.le.ac.uk/offices/ld/resources/writing)
  * [Finding information](https://www2.le.ac.uk/offices/ld/resources/finding-information/finding-information)
* Referencing resources
  * [Referencing style](https://www2.le.ac.uk/library/help/referencing/author-date)
  * [Software for managing your references](https://www2.le.ac.uk/library/help/bibliographies)

## Submission procedures

Submit your project using git. Your project should be placed under folder `partI` in your private repository. That is, your project must be found at `partI/CO7X17.miniproject1` in your repository on GitHub:
* The commands `./twitterMigrate 10` and `./gradlew clean bootRun` must run without compilation/runtime errors.
* The essay must be available as a PDF file at `partI/CO7X17.miniproject1/essay.pdf`



