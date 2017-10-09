package lab2

import com.gmongo.GMongo
import com.mongodb.DBCursor
import com.mongodb.MongoURI



// EDIT THE FOLLOWING PARAMETERS
def USERNAME = 'username'
def PWD = 'password'
def HOST = 'ds033754.mlab.com'
def PORT = 33754
def DATABASE = 'database'


// MAKING THE CONNECTION
def connectionString = new MongoURI("mongodb://${USERNAME}:${PWD}@${HOST}:${PORT}/${DATABASE}")
def mongo = new GMongo(connectionString)

def db = mongo.getDB(DATABASE)

// EXERCISE 1:
// Create a collection 'lab2' and create the following document
// This is an example of a Facebook JSON file which you might see 
// when getting data from the Facebook API. It might also be used to 
// contain profile information which can be easily shared across 
// your system components using the simple JSON format.
// source: https://www.sitepoint.com/facebook-json-example/
//	 [
//	      {
//	         "id": "X999_Y999",
//	         "from": {
//	            "name": "Tom Brady", "id": "X12"
//	         },
//	         "message": "Looking forward to 2010!",
//	         "actions": [
//	            {
//	               "name": "Comment",
//	               "link": "http://www.facebook.com/X999/posts/Y999"
//	            },
//	            {
//	               "name": "Like",
//	               "link": "http://www.facebook.com/X999/posts/Y999"
//	            }
//	         ],
//	         "type": "status",
//	         "created_time": "2010-08-02T21:27:44+0000",
//	         "updated_time": "2010-08-02T21:27:44+0000"
//	      },
//	      {
//	         "id": "X998_Y998",
//	         "from": {
//	            "name": "Peyton Manning", "id": "X18"
//	         },
//	         "message": "Where's my contract?",
//	         "actions": [
//	            {
//	               "name": "Comment",
//	               "link": "http://www.facebook.com/X998/posts/Y998"
//	            },
//	            {
//	               "name": "Like",
//	               "link": "http://www.facebook.com/X998/posts/Y998"
//	            }
//	         ],
//	         "type": "status",
//	         "created_time": "2010-08-02T21:27:44+0000",
//	         "updated_time": "2010-08-02T21:27:44+0000"
//	      }
//	   ]


// EXERCISE 2
// Update message field of document with id "X999_Y999" to "Remembering what happened in 2010"

// EXERCISE 3
// Delete the document with id: "id": "X998_Y998",



