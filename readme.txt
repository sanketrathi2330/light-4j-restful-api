1. The API Exposes all the required six endpoints.
2. The API Expects mongodb to run on the default port. -> 27017.
3. The API runs on port 8443 for requests from https.

The following are the example of executing each end-point from cURL.

1. curl -k  https://127.0.0.1:8443/v1/load
2. curl -k  https://127.0.0.1:8443/v1/users/2
3. curl -k -X POST https://127.0.0.1:8443/v1/users/2 -H "Content-type:application/json" -d "{\"email\":\"Spring Forever\"}"  --> 
(all properties except name and id can be modified. Properties are not updated if not specified explictly).
4. curl -k -X PUT https://127.0.0.1:8443/v1/users -H "Content-type:application/json" -d "{\"name\":\"Spring Forever\", \"id\": 17}"
5. curl -k -X DELETE  https://127.0.0.1:8443/v1/users/1
6. curl -k -X DELETE  https://127.0.0.1:8443/v1/users

Exceptions are handled up to a certain extent with try catch with the time i was able to find.

To start the API:
mvn clean install exec:exec

example output: 

{
  "website" : "anastasia.net",
  "address" : {
    "street" : "Victor Plains",
    "suite" : "Suite 879",
    "city" : "Wisokyburgh",
    "zipcode" : "90566-7771",
    "geo" : {
      "lat" : "-43.9509",
      "lng" : "-34.4618"
    }
  },
  "phone" : "010-692-6593 x09125",
  "name" : "Ervin Howell",
  "company" : {
    "name" : "Deckow-Crist",
    "catchPhrase" : "Proactive didactic contingency",
    "bs" : "synergize scalable supply-chains"
  },
  "id" : 2,
  "email" : "Shanna@melissa.tv",
  "username" : "Antonette"
}
