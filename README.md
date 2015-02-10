# FacebookService
REST Service which gathers information from the Facebook Graph API. It is hosted on [http://restinfacebookservice.herokuapp.com/](http://restinfacebookservice.herokuapp.com/).

The Facebook Service is used by the process centric service, the DB REST service and the DB SOAP service in order to understand if a particular request is sent by an authenticated user.
To do that the Facebook Service requires a token for each request that comes. Then it sends a request to the Facebook Graph API asking for user's information starting from the given token. If the result of the query is a valid json, then the request sent to the director was valid and made by an authenticated user.


Request:
```
https://restinfacebookservice.herokuapp.com/project-facebook/auth?token=<token>
```

Response in case the token is valid:
```
{
	"id" : "10203701191346680",
	"first_name" : "Roberto",
	"status" :
	{
		"message" : "Valid Request",
		"code" : 200
	},
	"location" : "Trento, Italy"
}
```

Response in case the token is not valid:
```
{
	"status":
	{
		"message" : "Invalid OAuth access token",
		"code" : 1
	}
}
```

Contributors: [Roberto Zen](https://github.com/robzenn92) 100%
