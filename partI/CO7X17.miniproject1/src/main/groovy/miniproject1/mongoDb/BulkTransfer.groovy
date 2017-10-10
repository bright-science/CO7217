package miniproject1.mongoDb

import groovy.json.JsonSlurper

class BulkTransfer {
	static void main(String... args) {

		MongoDB mongo = new MongoDB()
		JsonSlurper slurper = new JsonSlurper()
		def friends = slurper.parseText(new File('./friends.json').text)
		def followers = slurper.parseText(new File('./followers.json').text)
		def tweets = slurper.parseText(new File('./tweets.json').text)
		
		mongo.initDb()
		
		// tag::exercise[]
		
		// TODO Exercise 1
		
		//end::exercise[]
	}
}

