# FacebookService
REST Service which gather information from the Facebook Graph API

The Facebook Service is used by the director in order to understand if a particular request is sent by an authenticated user. 
To do that the Facebook Service requires a token for each request that comes. Then it sends a request the Facebook Graph API asking for user information starting from the given token. If the result of the query is a valid json, then the request sent to the director was valid and made by an authenticated user.