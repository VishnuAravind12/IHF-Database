# Iowa Hawkeyes Farming Database (IHF-Database)

## Overview
The Iowa Hawkeyes Farming Database is a full-stack application that merges the interests of farmers and basketball enthusiasts. Developed by a team of twelve developers over two trimesters (2023 - 2024), the project features a variety of functionalities including a statistical simulation for predicting NBA player performance and a farming simulator game with an integrated marketplace for harvested crops.

## Features

### Monte Carlo Simulation
- **Statistical Simulation**: Implemented a Monte Carlo simulation using historical data to predict future game statistics for NBA players.
- **Prediction Models**: Developed linear and logistic regression models to analyze and predict individual NBA player statistics.

### Farming Simulator Game
- **Gameplay**: Engaging farming simulator where users can manage their virtual farms, plant crops, and harvest them.
- **Marketplace**: Integrated marketplace allowing users to trade harvested crops with other players.

## Technologies Used
- **Backend**: Java, Spring Boot
- **Frontend**: HTML, CSS, JavaScript
- **Database**: MySQL
- **Containerization**: Docker, Docker Compose

## Getting Started
### Prerequisites
- Java JDK 17 (adoptopenjdk:17)
- Docker

### Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/Del-Norte-Farmers-Iowa-Hawkeyes-Fanclub/IHF-Database.git
    ```
2. Navigate to the project directory:
    ```bash
    cd IHF-Database
    ```
3. Build the project using Maven:
    ```bash
    ./mvnw clean install
    ```
4. Run the application:
    ```bash
    ./mvnw spring-boot:run
    ```

### Docker Deployment
1. Build the Docker image:
    ```bash
    docker build -t ihf-database .
    ```
2. Run the Docker container:
    ```bash
    docker-compose up
    ```

## Project Structure
- **`src/main/java/`**: Contains the Java source files
    - **`controllers/`**: HTTP route and HTML file relationships
- **`src/main/resources/`**: Contains HTML templates and supporting files
    - **`templates/`**: HTML templates
    - **`static/`**: Static resources (CSS, JS, images)
- **`Dockerfile`**: Docker configuration for containerizing the application
- **`docker-compose.yml`**: Docker Compose configuration for multi-container applications
