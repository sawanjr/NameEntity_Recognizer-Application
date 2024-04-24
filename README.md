---

# NER Application
## Application Screenshot

![NER Application Screenshot](https://github.com/sawanjr/NameEntity_Recognizer-Application/blob/master/src/main/resources/templates/ner_snap.png)

This Java Spring Boot application utilizes Stanford CoreNLP for Named Entity Recognition (NER).

## Table of Contents
- [Overview](#overview)
- [Project Structure](#project-structure)
- [Dependencies](#dependencies)
- [Running the Application](#running-the-application)
- [Endpoints](#endpoints)
- [Configuration](#configuration)

## Overview

The NER Application is built to perform Named Entity Recognition tasks using Stanford CoreNLP. It provides RESTful endpoints for NER processing based on different entity types.

## Project Structure

The project structure is organized as follows:
- `com.sawan_jr.nerapplication`: Contains the main application class and configuration.
- `com.sawan_jr.nerapplication.controller`: Includes the NERController responsible for handling NER requests.
- `com.sawan_jr.nerapplication.model`: Defines the entity types used for NER.
- `com.sawan_jr.nerapplication.core`: Contains the pipeline configuration for Stanford CoreNLP.

## Dependencies

The application uses the following dependencies:
- Spring Boot Starter Web for RESTful API functionality.
- Spring Boot Starter Thymeleaf for view rendering (not utilized in this API).
- Stanford CoreNLP for NLP processing and NER.
- JAXB dependencies for XML data binding.
- Spring Boot Starter Test for testing.

## Running the Application

To run the application, make sure you have Java 17 and Maven installed.

1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn spring-boot:run` to start the application.

## Endpoints

The application exposes the following endpoint for NER processing:

- POST `/api/v1/ner`: Endpoint to perform NER on input text based on specified entity type.

Request Body:
```json
{
  "input": "Text to analyze for named entities",
  "type": "ENTITY_TYPE"
}
```
Replace `"ENTITY_TYPE"` with one of the supported entity types:
- PERSON
- CITY
- STATE_OR_PROVINCE
- COUNTRY
- EMAIL
- TITLE

Response:
```json
["Named Entity 1", "Named Entity 2", ...]
```

## Configuration

* The Stanford CoreNLP pipeline is configured in the `Pipeline` class under `com.sawan_jr.nerapplication.core`. The annotators used include tokenization, sentence splitting, part-of-speech tagging, lemmatization, and named entity recognition.
* the local is set to port: 8081

## Contributors

This project was developed by:
- [Sawan Kumar](https://github.com/sawanjr)
- [Nimish Shandilya](https://github.com/Anonymous-Technopath)


---

