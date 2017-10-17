package lab2

import com.gmongo.GMongo
import com.mongodb.DBCursor
import com.mongodb.MongoURI

def USERNAME = 'username'
def PWD = 'password'
def HOST = 'ds033754.mlab.com'
def PORT = 33754
def DATABASE = 'database'


// MAKING THE CONNECTION
def connectionString = new MongoURI("mongodb://${USERNAME}:${PWD}@${HOST}:${PORT}/${DATABASE}")
def mongo = new GMongo(connectionString)

def db = mongo.getDB(DATABASE)

// TESTING CONNECTION
println 'database: ' + db.getName()
db.getCollectionNames().each{ println it } 


// 	CREATE
// these three ways are equivalent
// with db.users we are accessing the users collection
db.users.insert([id: 1, name: 'John', role: 'developer', isEmployee: true])
db.users.insert(id: 2, name: 'Luke', role: 'tester', isEmployee: true)
db.users << [id: 3, name: 'Rajesh', role: 'developer', isEmployee: true]
// inserting several documents
db.users << [[id: 4, name: 'Yi', role: 'tester', isEmployee: true], [id: 5, name: 'Pau', role: 'developer', isEmployee: true]]

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

// UPDATE
println "before: " + db.users.findOne(name: 'John')
db.users.update([name: 'John'], [$set: [role: 'tester']])
println "after: " + db.users.findOne(name: 'John')


// UPSERT
println "before: "  + db.users.findOne(name: 'John')
db.users.update([name: 'John'], [$set: [role: 'manager']], true)
println "after: " +  db.users.findOne(name: 'John')

println "before deletion: " + db.users.find().count()

// DELETE
// Removing some documents
db.users.remove(name: 'John')
assert 0 == db.users.count(name: 'John')

// Removing all documents
db.users.remove([:])
assert 0 == db.users.count()


	