# SPGroup Social Friend Api

Friend Management Api

## Getting Started

Demo Project for Social Friend API

### Prerequisites

```
Java 8
Maven

```

### Installing and Running test


```
git clone https://github.com/parmod-arora/spgroup-social.git
mvn install
```
mvn install will create build and run test


### Approach

1) Create maven project in Eclipse.
2) Add spring-boot dependencies Web, JPA, H2database (https://start.spring.io/)
3) Install dependencies using maven refesh from IDE or run mvn install and wait for jars to download 
4) Create domain model for User 
  User can has many Friends(User)
  User can have many subscriptions
5) Create Controller for Subscription and Users and expose rest Apis
6) Bussiness logic is in Services and Dao is for communication with database.

### Run
Download build/spgroup-0.0.1.jar and execute the build using below command.
```
java -jar spgroup-0.0.1.jar
````
PostMan Collection for api is under build folder

Import SPGroup.postman_collection.json and start exploring APIs

1) Add Friend http://localhost:8080/friends/add
```
"headerData": [
  {
    "key": "Content-Type",
    "value": "application/json"
  },
  {
    "key": "Accept",
    "value": "application/json"
  }
]
requestBody : {
	"friends":[
		"test1@test.com",
		"test19@test.com"
	]
}
```

2) User's Friend http://localhost:8080/friends
```
"headerData": [
  {
    "key": "Content-Type",
    "value": "application/json"
  },
  {
    "key": "Accept",
    "value": "application/json"
  }
]
requestBody : {
		"email": "test1@test.com"
}
```
3) Common Friends http://localhost:8080/friends/common
```
"headerData": [
  {
    "key": "Content-Type",
    "value": "application/json"
  },
  {
    "key": "Accept",
    "value": "application/json"
  }
]
requestBody : {
	"friends":[
		"test2@test.com",
		"test1@test.com"
	]
}
```

4) Block Subscription http://localhost:8080/user/subscriptions/block
```
"headerData": [
  {
    "key": "Content-Type",
    "value": "application/json"
  },
  {
    "key": "Accept",
    "value": "application/json"
  }
]
requestBody : {
	"requestor": "test1@test.com",
	"target": "test19@test.com"
}
```

5) Block Subscription http://localhost:8080/user/subscriptions/add
```
"headerData": [
  {
    "key": "Content-Type",
    "value": "application/json"
  },
  {
    "key": "Accept",
    "value": "application/json"
  }
]
requestBody : {
	"requestor": "test1@test.com",
	"target": "test11@test.com"
}
```

6) Subscriptions http://localhost:8080/user/subscriptions
```
"headerData": [
  {
    "key": "Content-Type",
    "value": "application/json"
  },
  {
    "key": "Accept",
    "value": "application/json"
  }
]
requestBody : {
	"sender": "test1@test.com",
	"text": "Hello buddy test20@test.com"
}
```
