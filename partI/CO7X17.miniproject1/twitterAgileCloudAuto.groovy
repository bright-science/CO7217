#!/usr/bin/env groovy

username = "AgileCloudAuto"
password = "9asfy;£FA"
numTweets = "10"

//If we have an argument use it
if (args && args[0].toFloat() > 0) numTweets = args[0]

//Use twitter API with cURL
def process = "curl -u $username:$password http://twitter.com/statuses/friends_timeline.xml?count=$numTweets".execute()
process.waitFor()
def output = process.text
println output 

//Parsing XML is Amazingly easy in Groovy
tweets = new XmlSlurper().parseText(output)
tweets.status.each { tweet->
    println "${tweet.user.name}: ${tweet.text}"
}