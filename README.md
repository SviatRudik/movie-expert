# Movie Review Application

This project allows users to write reviews for movies and subscribe to favorite users. It integrates with the TMDb API for movie information.

## Running the Application

### Requirements
- Apache Tomcat
- Docker
- TMDb API token

### Steps
1. Clone the repository
2. Register for a TMDb account to obtain the API token.
3. Replace ${API_TOKEN} in client.properties with your TMDb API token.
4. Run the Docker Compose file to start the DB.
5. Start Apache Tomcat with the root path for usermgmt set to /users and / path to core.

## Endpoints

- `POST /users/public/registration`: Register a new user.
  Request body example:
  ```json
  {
      "username": "Slava",
      "email": "Slava@mail.com",
      "password": "Password1!"
  }
  ```
- `POST /users/public/login`: User login. Returns the authentication token.
  Request body example:
  ```json
  {
      "username": "Slava",
      "password": "Password1!"
  }
  ```

- `GET /movies?name=pulp+fiction&page=1`: Get a list of movies by name.
- `POST /reviews`: Post a new review.
  Request body example:
  ```json
  {
      "title": "Wow! Cool!",
      "rating": 5,
      "content": "Best movie ever!",
      "externalMovieId": 438631
  }
  ```
- `GET /reviews?page=1`: Get the latest reviews.
- `GET /reviews/subscription?page=1`: Get the latest reviews from subscribed users.
- `GET /subscription?userId=1`: Subscribe to a user. (userId - content maker's id)
- `GET /movies/internal?page=1`: Get movies that exist in the service (have reviews).

## Security

- All endpoints except those under `/users/public` require an authentication token.
- To obtain a token, use the `POST /users/public/login` endpoint with your username and password.

## Note

Remember, this is just a code sample that is still a work in progress (or abandoned).