# Project README

## Group Members

- Francesco Romeo (ID: 885880)
- Alessandro Tenani (ID: 879248)
- Matteo Picozzi (ID: 890228)

## Project Components

This project, developed by our group, comprises the following components:

- **Client**: Located in the `client-web` folder.
- **Server**: Located in the `server-web` folder.
- **Database**: Located in the `database` folder.

## Communication

The client and server communicate through APIs provided by the server. There are three main API endpoints:

1. **GET**: Retrieve a list of all projections with their details.
2. **POST**: Add new reservations.
3. **DELETE**: Delete seats or reservations.

Server and database communication occurs through sockets. The server handles basic functions such as addition, deletion, and retrieval of values using reusable functions. The core business logic is managed by the server, with some aspects also handled by the client through JavaScript.

## Port Configuration

- The server listens to the client on **port 8080**.
- The database listens to the server on **port 3030** of localhost.

## Running the Project

To run the project, follow these steps:

1. Execute `Main.java` within the `database` directory.
2. Execute `Main.java` within the `server-web` directory.
3. Open the `index.html` file located in the `client-web` folder.

Feel free to reach out if you have any questions or need further assistance with the project.
