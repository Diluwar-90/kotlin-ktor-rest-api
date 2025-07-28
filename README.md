# ktor-rest_api

This project was created using the [Ktor Project Generator](https://start.ktor.io).

This is a **User Management REST API** built with **Kotlin** and **Ktor**, using **PostgreSQL** as the database.

## 🛠️ Tech Stack
- **Language**: Kotlin
- **Framework**: Ktor
- **Database**: PostgreSQL
- 
## Features

Here's a list of features included in this project:
- Create, read, update, and delete users
- RESTful architecture
- Built with lightweight Ktor framework

| Name                                                                   | Description                                                                        |
| ------------------------------------------------------------------------|------------------------------------------------------------------------------------ |
| [Routing](https://start.ktor.io/p/routing)                             | Provides a structured routing DSL                                                  |
| [kotlinx.serialization](https://start.ktor.io/p/kotlinx-serialization) | Handles JSON serialization using kotlinx.serialization library                     |
| [Content Negotiation](https://start.ktor.io/p/content-negotiation)     | Provides automatic content conversion according to Content-Type and Accept headers |
| [Postgres](https://start.ktor.io/p/postgres)                           | Adds Postgres database to your application                                         |
| [Exposed](https://start.ktor.io/p/exposed)                             | Adds Exposed database to your application                                          |

## 🧰 Setup Instructions

1. **Clone the repository**  
   ```bash
   git clone https://github.com/Diluwar-90/kotlin-ktor-rest-api.git
   cd your-repo-name
2. Install PostgreSQL
Ensure PostgreSQL is installed and running on your system.
3. Configure the database
Update the application.yaml file with your PostgreSQL credentials.
4. Run the project
Open the project in IntelliJ IDEA and run it using the IDE's run configuration.

## Building & Running

To build or run the project, use one of the following tasks:

| Task                          | Description                                                          |
| -------------------------------|---------------------------------------------------------------------- |
| `./gradlew test`              | Run the tests                                                        |
| `./gradlew build`             | Build everything                                                     |
| `buildFatJar`                 | Build an executable JAR of the server with all dependencies included |
| `buildImage`                  | Build the docker image to use with the fat JAR                       |
| `publishImageToLocalRegistry` | Publish the docker image locally                                     |
| `run`                         | Run the server                                                       |
| `runDocker`                   | Run using the local docker image                                     |

If the server starts successfully, you'll see the following output:

```
2024-12-04 14:32:45.584 [main] INFO  Application - Application started in 0.303 seconds.
2024-12-04 14:32:45.682 [main] INFO  Application - Responding at http://0.0.0.0:8080
```

