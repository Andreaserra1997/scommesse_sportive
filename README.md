# Sports Betting

Developed by **Andrea Serra**

## Installation

To run this application locally, make sure you have the following prerequisites installed:

- Java 17 or higher
- Maven
- MySQL (or another supported relational database)

Download the repository by this link:

```
https://github.com/Andreaserra1997/scommesse_sportive
```

Configure the database and update **application.properties** with your MySQL credentials:

```
#data source
spring.datasource.url=jdbc:mysql://localhost:3306/{name of your database}
spring.datasource.username={username}
spring.datasource.password={password}
```

**Start the application**

<br>

## Overview

The Bet API is a RESTful web service designed to manage sporting events and related betting. The application
provides a set of endpoints to create, view, update, and delete sporting events and bets, enabling
comprehensive management of the betting lifecycle.

## Key features

### Events

The application allows you to manage sports events. Each event is identified by a unique ID and includes details such
as:

<ul>
<li><strong>Event Name</strong>: the name of the game or competition.</li>
<li><strong>Date and time:</strong> when the event will take place.</li>
<li><strong>Quotes:</strong> the initial odds associated with the event, useful for calculating the value of bets.</li>
</ul>

Events represent the main betting context, and once an event is created, users can
associate bets with it. It is possible to update information on events and delete them when they are no longer
needed.

### Betting

Users can create bets on existing sporting events. Each bet is associated with a specific event through a one-to-many
relationship :

<ul>
<li>A <strong>event</strong> can have multiple <strong>bets</strong> (one-to-many relationship).</li>
<li>Each <strong>bet</strong> is linked to a single <strong>event</strong> (foreign key).</li>
</ul>

The bets contain the following information:

<ul>
<li><strong>Type of bet:</strong> defines the outcome you are betting on (e.g., team win, draw).</li>
<li><strong>Amount:</strong> the amount of money wagered.</li>
</ul>

<br>

## API Endpoints

### 1. Sports Events

### Description: Retrieves all sports events.

**Example of use in Postman:**

<ol>
<li>Create a new request</li>
<li>Select the method <strong>GET</strong></li>
<li>Enter the URL: <strong>http://localhost:8080/api/events</strong></li>
<li>Click on <strong>SEND</strong></li>
</ol>

**Answer**

```
[
  {
	"id": 1,
	"name": "Juventus vs Milan",
	"date": "2024-10-15T20:30:00",
	"odds": {
  	"team1Win": 1.5,
  	"team2Win": 3.2,
  	"draw": 2.8
	}
  }
]
```

### Description: Create a new sports event.

**Example of use in Postman:**

<ol>
<li>Create a new request</li>
<li>Select the method <strong>POST</strong></li> 
<li>Enter the URL: <strong>http://localhost:8080/api/events</strong></li>
<li>
<strong>Set the header:</strong> Be sure to specify the content type of the request to make Spring Boot interpret the payload correctly
<ul>
<li>Key: <strong>Content-Type</strong></li>
<li>Value: <strong>application/json</strong></li>
</ul>
</li>
<li>Go to the <strong>Body</strong> section, select <strong>raw</strong>, and set the type to <strong>JSON</strong></li>
<li>Enter the following <strong>JSON:</strong></li>

```
{
  "name": "Inter vs Napoli",
  "date": "2024-10-16T18:00:00",
  "odds": {
	"team1Win": 1.21,
	"team2Win": 4.65,
	"draw": 3.52
  }
}
```

<li>Click on <strong>SEND</strong></li>
</ol>

### Description: Updates the details of an existing sports event identified by the ID.

**Example of use in Postman:**

<ol>
<li>Create a new request</li>
<li>Select the method <strong>PUT</strong></li>
<li>Enter the URL: <strong>http://localhost:8080/api/events/{id}</strong></li>
<li>
<strong>Set the header:</strong> Be sure to specify the content type of the request to make Spring Boot correctly interpret the payload
<ul>
<li>Key: <strong>Content-Type</strong></li>
<li>Value: <strong>application/json</strong></li>
</ul>
</li>
<li>Go to the <strong>Body</strong> section, select <strong>raw</strong>, and set the type to <strong>JSON</strong></li>
<li>Enter the following <strong>JSON:</strong></li>

```
{
  "name": "Inter vs Napoli",
  "date": "2024-10-17T20:45:00",
  "odds": {
	"team1Win": 1.32,
	"team2Win": 4.25,
	"draw": 3.16
  }
}
```

<li>Click on <strong>SEND</strong></li>
</ol>

### Description: Deletes a specific event identified by its ID.

**Example of use in Postman:**

<ol>
<li>Creates a new request</li>
<li>Select the method <strong>DELETE</strong></li>
<li>Enter the URL: <strong>http://localhost:8080/api/events/2 (where 2 is the ID of the event to be deleted)</strong></li>
<li>Click on <strong>SEND</strong></li>
</ol>

### Description: View a single sporting event by ID.

**Example of use in Postman:**

<ol>
<li>Create a new request</li>
<li>Select the method <strong>GET</strong></li>
<li>Enter the URL: <strong>http://localhost:8080/api/events/{id}</strong></li>
<li>Click on <strong>SEND</strong></li>
</ol>

### 2. Bets

### Description: Retrieves all bets for a specific sporting event.

**Example of use in Postman:**

<ol>
<li>Create a new request</li>
<li>Select the method <strong>GET</strong></li>
<li>Enter the URL: <strong>http://localhost:8080/api/bets?eventId=1</strong></li>
<li>Click on <strong>SEND</strong></li>
</ol>

**Answer**

```
[
  {
	"betId": 1,
	"eventId": 1,
	"betType": "team1Win",
	"amount": 100.0
  },
  {
	"betId": 2,
	"eventId": 1,
	"betType": "draw",
	"amount": 50.0
  }
]
```

### Description: Creates a new bet for an event.

**Example of use in Postman:**

<ol>
<li>Create a new request</li>
<li>Select the method <strong>POST</strong></li>
<li>Enter the URL: <strong>http://localhost:8080/api/bets</strong></li>
<li>
<strong>Set the header:</strong> Be sure to specify the content type of the request to make Spring Boot interpret the payload correctly
<ul>
<li>Key: <strong>Content-Type</strong></li>
<li>Value: <strong>application/json</strong></li>
</ul>
</li>
<li>Go to the <strong>Body</strong> section, select <strong>raw</strong>, and set the type to <strong>JSON</strong></li>
<li>Enter the following <strong>JSON:</strong></li>

```
{
  "eventId": 1,
  "betType": "draw",
  "amount": 25.0
}

```

<li>Click on <strong>SEND</strong></li>
</ol>

### Description: Deletes a specific bet identified by its ID.

**Example of use in Postman:**

<ol>
<li>Create a new request</li>
<li>Select the method <strong>DELETE</strong></li>
<li>Enter the URL: <strong>http://localhost:8080/api/bets/2 (where 2 is the ID of the bet to be deleted)</strong></li>
<li>Click on <strong>SEND</strong></li>
</ol>

<br>