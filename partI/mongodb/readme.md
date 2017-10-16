<link rel='stylesheet' href='web/swiss.css'/>

# Lab session 2: Accessing MongoDB 


## Tutorial

In this tutorial we are going to use [MongoDb Java Driver](https://docs.mongodb.com/ecosystem/drivers/java/) to access a MongoDB available over Infrastructure-as-a-Service (IaaS) on [mLab](https://mlab.com). In the tutorial we will see how the use of DSLs help develop cloud systems, focussing on the persistence layer and on cloud computing. In particular, we are going to use [GMongo](https://github.com/poiati/gmongo), a groovy version of the MongoDb Java driver API 

### Create an account on MongoLab

First, we need to set up our MongoDB instance. We are going to use mLab, a cloud database provider built atop Infrastructure-as-a-Service (IaaS) providers, so that we do not need to install and configure the database server locally.

* Sign up and create a new account on [mLab](https://mlab.com/welcome/)
* Once you have confirmed you email address, create a new database by clicking on `Create New`.
* Choose your cloud provider of choice from `Amazon Web Services`, `Google Cloud Platform`, `Windows Azure` and the location. For example: `Amazon Web Services` and `Amazon EU (Ireland)`.
* Choose a single-node plan: the free option is enough for this lab session.
* Give your database a name.
* Click on `Create New MongoDB Deployment`.
* A table will show your MongoDB instances (databases), click on the one you have just created.
* Click on tab `Users` and a new user by providing a `MY_USERNAME` and a `MY_PASSWORD` (please choose different names but remember them).
* Look at the information on the screen: you will see a line giving you the terminal console command to reach your MongoDB instance, should you had a MongoDB client installed on your machine, starting with `mongo ds033754.mlab.com:33754/DATABASE -u <dbuser> -p <dbpassword>`. This line contains information about your database, host and port. In this case:
<ul>
	<li>`MY_HOST=ds033754.mlab.com`</li>
	<li>`MY_PORT=33754`</li>
	<li>`MY_DATABASE=DATABASE`</li>
</ul>
* We are all set. Your MongoDB instance is up and running on the cloud!

### Getting started with Spring Data and MongoDb

* Pull the general git repository (clone it first if you haven't done it yet)
* Copy the project `mongodb` under `partI` in the master repository to your private repository
* Import the Gradle project into the STS using `File>Import>Existing Gradle Project`
  * Choose gradle wrapper
  * Choose to overwrite eclipse settings 
* The Gradle build script imports two dependencies: one for compiling groovy code and the other one for using gmongo
	
	compile "org.codehaus.groovy:groovy-all:$groovyVersion"
	compile "com.gmongo:gmongo:1.5"
	
## File GMongoDb

This is a Groovy script containing example code showing how to implement CRUD operations using a MongoDB store.

The header is as follows:

	import com.gmongo.GMongo
	import com.mongodb.DBCursor
	import com.mongodb.MongoURI
	
	def USERNAME = 
	def PWD = 
	def HOST = 
	def PORT = 
	def DATABASE = 
	
	// MAKING THE CONNECTION
	def connectionString = new MongoURI("mongodb://${USERNAME}:${PWD}@${HOST}:${PORT}/${DATABASE}")
	def mongo = new GMongo(connectionString)
	
	def db = mongo.getDB(DATABASE)

Please configure your credentials by looking at the URI given in the header of your dabatase on mLab.

The following code checks that the connection can be performed and you should be able to see the names of all the collections on your database: 

	// TESTING CONNECTION
	println 'database: ' + db.getName()
	db.getCollectionNames().each{ println it } 

For creating documents in a database we will use the following code:

	// 	CREATE
	// these three ways are equivalent
	// with db.users we are accessing the users collection
	db.users.insert([id: 1, name: 'John', role: 'developer', isEmployee: true])
	db.users.insert(id: 2, name: 'Luke', role: 'tester', isEmployee: true)
	db.users << [id: 3, name: 'Rajesh', role: 'developer', isEmployee: true]
	// inserting several documents
	db.users << [[id: 4, name: 'Yi', role: 'tester', isEmployee: true], [id: 5, name: 'Pau', role: 'developer', isEmployee: true]]

For making queries:

	// READ
	// get the first document
	println db.users.findOne()
	
	// fetch a specific one
	def user = db.users.findOne(id: 2)
	user.name = 'Luke E.'
	db.users.save user
	assert db.users.findOne(id: 2).name == 'Luke E.'

	// fetching all the elements of a collection 
	println db.users.find()

	// fetching all elements that meet a condition
	db.users.find(role: 'developer').each{ println it }

	// Counting the number of documents in the collection
	println "counting: " + db.users.find(role: 'developer').count()
	// is equivalent to
	println "counting: " + db.users.count(role: 'developer')

For applying modifications to some documents, the first parameter of the the `update` operation is a filter for finding the document where to apply modifications and the second parameter indicates the type of update to be performed. For example `[$set: [role: 'tester']]` expresses that the field `role` will be set to `'tester'`.

	// UPDATE
	println "before: " + db.users.findOne(name: 'John')
	db.users.update([name: 'John'], [$set: [role: 'tester']])
	println "after: " + db.users.findOne(name: 'John')

The upsert operation inserts a document if it does not exist yet so duplicates can be avoided (notice the last parameter of the update operation):

	// UPSERT
	println "before: "  + db.users.findOne(name: 'John')
	db.users.update([name: 'John'], [$set: [role: 'manager']], true)
	println "after: " +  db.users.findOne(name: 'John')

Finally, we can delete a particular document by indicating a filter:

	// DELETE
	// Removing some documents
	db.users.remove(name: 'John')
	assert 0 == db.users.count(name: 'John')
	
Or we can delete all documents in a collection as follows:	
	
	// Removing all documents
	db.users.remove([:])
	assert 0 == db.users.count()

### Executing the script

In the gradle build script, you will find the task

	task runScript (dependsOn: 'classes', type: JavaExec) {
		main = "lab2.Exercise"
		classpath = sourceSets.main.runtimeClasspath
	}

The main field should point to the script file. From the command line, execute:

	./gradlew runScript

## Exercises 

### Exercise 1

Create a collection 'lab2' and create the following document
This is an example of a Facebook JSON file which you might see 
when getting data from the Facebook API. It might also be used to 
contain profile information which can be easily shared across 
your system components using the simple JSON format.
source: [https://www.sitepoint.com/facebook-json-example/](https://www.sitepoint.com/facebook-json-example/)

	 [
	      {
	         "id": "X999_Y999",
	         "from": {
	            "name": "Tom Brady", "id": "X12"
	         },
	         "message": "Looking forward to 2010!",
	         "actions": [
	            {
	               "name": "Comment",
	               "link": "http://www.facebook.com/X999/posts/Y999"
	            },
	            {
	               "name": "Like",
	               "link": "http://www.facebook.com/X999/posts/Y999"
	            }
	         ],
	         "type": "status",
	         "created_time": "2010-08-02T21:27:44+0000",
	         "updated_time": "2010-08-02T21:27:44+0000"
	      },
	      {
	         "id": "X998_Y998",
	         "from": {
	            "name": "Peyton Manning", "id": "X18"
	         },
	         "message": "Where's my contract?",
	         "actions": [
	            {
	               "name": "Comment",
	               "link": "http://www.facebook.com/X998/posts/Y998"
	            },
	            {
	               "name": "Like",
	               "link": "http://www.facebook.com/X998/posts/Y998"
	            }
	         ],
	         "type": "status",
	         "created_time": "2010-08-02T21:27:44+0000",
	         "updated_time": "2010-08-02T21:27:44+0000"
	      }
	   ]

### Exercise 2 

Update message field of document with id "X999_Y999" to "Remembering what happened in 2010".

### Exercise 3

Delete the document with id: "id": "X998_Y998"

## Sources

* Official API documentation [MongoDb API](http://api.mongodb.com/java/2.13/)
* [GitHub repository of GMongo](https://github.com/poiati/gmongo) 


***
&copy; Artur Boronat, 2015-17 
