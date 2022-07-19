# Healthy Life Tracker Service
## App Links:
### [Swagger OpenApi Docs](http://localhost:8080/v3/api-docs/)

### [Swagger OpenApi UI](http://localhost:8080/swagger-ui/index.html)

## Docker Image

### Build: docker build --tag=ivannicksim/hlt-food-service:latest .

### Push: docker push ivannicksim/hlt-food-service:latest

### Run: docker run -p 8080:8080 ivannicksim/hlt-food-service:latest

## Run Application in Docker

### Run: docker-compose up

### Open [PgAdmin4](http://localhost:5050/browser/) and click "Add New Server"
#### Name: food (General Tab)
#### Hostname/address: postgres (Connection Tab)
#### Username: food (Connection Tab)
#### Password: foodpassword (Connection Tab)

### Create new Login/Group Role...
#### Name: food (General Tab)
#### Can login?: true (Privileges tab)
#### Superuser?: true (Privileges tab)

## Run Application Locally

### Open Postgres App and Set Server Settings 
#### Name: food
#### Port: 5432
#### Click "Start" to start the local postgres server

### Open PgAdmin4 and click "Add New Server"
#### Name: food (General Tab)
#### Hostname/address: localhost (Connection Tab)
#### Username: food (Connection Tab)
#### Password: foodpassword (Connection Tab)

### Create new Login/Group Role...
#### Name: postgres (General Tab)
#### Can login?: true (Privileges tab)
#### Superuser?: true (Privileges tab)

