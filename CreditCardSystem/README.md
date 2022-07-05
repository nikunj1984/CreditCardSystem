## Environment:
- Java version: 1.8
- Maven version: 3.*
- Spring Boot version: 2.3.4.RELEASE


##End Points
##1
 `POST` request to `/add` :
## Sample Request
Sample example of JSON data object:
```json
{
    "name":"steve",
    "cardNumber":"79927398713",
    "limit":1000
}

##Details:
* creates a new credit card record
* the response code is 201 and the response body is the created record, including its unique id

##2
 `GET` request to `/getAll`:

## Sample Response
Sample example of JSON data object:
```json
{
        "name": "Joe",
        "cardNumber": "1100111122222222",
        "limit": 700,
        "balance": 100.0
}

##Details:
* the response code is 200
* the response body is an array of matching records, ordered by their ids in increasing order
