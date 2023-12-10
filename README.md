# Quarkus Project: Pokemon Card Battle

This is a Quarkus project for a Pokemon card battle application.

## How to Execute with Quarkus Dev

1. Make sure you have Java JDK 11 or higher installed on your machine.

2. Clone this repository to your local machine.

3. Open a terminal and navigate to the project's root directory.

4. Run the following command to start the application in development mode:

    ```shell
    ./mvnw quarkus:dev
    ```

    This will start the Quarkus development mode and automatically reload the application whenever changes are made.

5. Access the application by opening your web browser and navigating to [http://localhost:8080/pokemon/index.html](http://localhost:8080/pokemon/index.html).

## How to Play

1. Select each Pokemon in the dropdown menu.

2. Click on "Start Battle" to start the battle.

3. The winner is determined by calculating the sum of attack, defense, and hp for each Pokemon. The Pokemon with the higher total value will be declared the winner.

4. The result of the battle (whether Pokemon 1 or Pokemon 2 wins, or if it's a tie) will appear on the screen.

# Unit Tests

This class contains unit tests for the `Pokemon` class using Junit

## Test: testNomePokemon

This test verifies that the name of the `pikachu` Pokemon is correctly set to "pikachu" in English.

## Test: testTipoPokemon

This test verifies that the type of the `pikachu` Pokemon is correctly set to "elétrico".

## Test: testBasePokemon

This test verifies that the base stats of the `pikachu` Pokemon are correctly set.


# Component Tests

This class contains a set of tests for the `TesteComponentePokemon` component using Rest Assured

## Test Get Pokemon Dex Endpoint

This test verifies if the `/pokemon/info/{id}` endpoint returns a status code of 200 (OK).

## Test Get Pokemon Dex Endpoint JSON

This test verifies if the `/pokemon/info/{id}` endpoint returns a status code of 200 (OK) and the response content type is JSON.

## Test Get Pokemon Dex Endpoint Not Found

This test verifies if the `/pokemon/info/{id}` endpoint returns a status code of 404 (Not Found) when the provided ID is not valid.

## Test Get Pokemon Dex Endpoint Not Content

This test verifies if the `/pokemon/info/{id}` endpoint returns a status code of 204 (No Content) when the provided ID is 0.

## Test Get Pokemon Image Endpoint

This test verifies if the `/pokemon/image/{id}` endpoint returns a status code of 200 (OK).

## Test Get Pokemon Image Endpoint PNG

This test verifies if the `/pokemon/image/{id}` endpoint returns a status code of 200 (OK) and the response content type is PNG image.

## Test Get Pokemon Image Endpoint Not Found

This test verifies if the `/pokemon/image/{id}` endpoint returns a status code of 404 (Not Found) when the provided ID is not valid.

## Contributing

If you would like to contribute to this project, please follow the guidelines in [CONTRIBUTING.md](CONTRIBUTING.md).

## License

This project is licensed under the [MIT License](LICENSE).

