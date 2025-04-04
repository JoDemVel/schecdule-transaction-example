# Schedule in Transactions

You don't need a docker container, a cloud database is used.

## API
### TransactionDay
### Get
`http://localhost:8080/api/transaction-day?page=1&size=10`

Example Response:
```angular2html
{
    "content": [],
    "pageable": {
        "pageNumber": 1,
        "pageSize": 10,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 10,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalElements": 0,
    "totalPages": 0,
    "size": 10,
    "number": 1,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": false,
    "numberOfElements": 0,
    "empty": true
}
```

### CREATE 
POST
``http://localhost:8080/api/transaction-day``

ExampleResponse
```angular2html
{
    "name": "John Doe",
    "numTransaction": "TXN123456",
    "amount": 150.75,
    "type": "PURCHASE"
}
```

### Transaction History
### Get
``http://localhost:8080/api/transaction-history?page=1&size=10``
### Example Response
```angular2html
{
    "content": [],
    "pageable": {
        "pageNumber": 1,
        "pageSize": 10,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 10,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalElements": 1,
    "totalPages": 1,
    "size": 10,
    "number": 1,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": false,
    "numberOfElements": 0,
    "empty": true
}
```