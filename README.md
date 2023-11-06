# tecnical_test_capitole
Capitole Consulting Tecnical Test

# Get price, Type: GET
Endpoint type GET that accepts the following input parameters: application date, product Id, brand Id.
Returns the following output data: application date, productId, brandId and final price to apply.

Example request.

curl --location 'http://localhost:8080/capitoleTest/getPrice?date=2020-06-14%2010.00.00&productId=35455&brandId=1'


Example response.

{
    "applicationDate": "2020-06-14 10.00.00",
    "productId": 35455,
    "brandId": 1,
    "price": 35.5,
    "priceList": 1
}