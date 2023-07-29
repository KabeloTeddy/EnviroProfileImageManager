

## File Parser Application

The File Parser Application is a Java-based Spring Boot project designed to parse CSV (Comma-Separated Values) files containing information about user profiles, including their name, surname, image format, and image data. The application processes the CSV data, converts the Base64 image data into physical image files, and saves the user profile information along with the corresponding image links into a database using Spring Data JPA.

### Project Structure

The project consists of the following files and directories:

1. **README.md**: This file provides essential information about the File Parser Application, its functionalities, setup, and usage.

2. **pom.xml**: The Project Object Model (POM) file for Maven. It manages the project's dependencies and build configurations.

3. **src/main/java/com/eviro/assessment/grad001/kabeloteddymorris/demo/**: This directory contains the Java source code for the application.

    - **EnviroProjectApplication.java**: The main class that initializes the Spring Boot application.
    - **AccountProfile.java**: The entity class representing the user profile with name, surname, image format, and image data attributes.
    - **AccountProfileRepository.java**: The repository interface for interacting with the database using Spring Data JPA.
    - **FileParser.java**: The interface defining the methods for parsing CSV data and processing user profiles.
    - **FileParserImpl.java**: The implementation of the FileParser interface, responsible for parsing CSV data, converting images, and saving user profiles to the database.

4. **src/main/resources/**: This directory contains application-specific resources.

    - **application.properties**: The configuration file for the Spring Boot application, used to specify properties like the server port and database connection details.
    - **file.csv**: A sample CSV file containing user profile data in the format: `Name,Surname,ImageFormat,ImageData`. This file is used for testing the application.
    - **images/**: A directory to store converted image files. The application saves the images in this directory.

5. **src/test/java/com/eviro/assessment/grad001/kabeloteddymorris/demo/**: This directory contains test classes for unit testing the application.

6. **src/test/resources/**: This directory contains resources required for testing.

7. **.gitignore**: The Git configuration file that specifies files and directories to be excluded from version control.

8. **LICENSE**: The license file that defines the terms and conditions for using the application.

### How the Application Works

1. The application starts by initializing the Spring Boot context, loading the necessary beans and configurations.

2. When the application is run, it reads the sample CSV file (`file.csv`) placed in the `src/main/resources/` directory.

3. The CSV file contains user profile data, including name, surname, image format, and Base64-encoded image data.

4. The `FileParserImpl` class reads the CSV file using the `ResourceLoader` to get the resource from the classpath.

5. The CSV data is parsed line by line, and for each line, a new `AccountProfile` entity is created and populated with the profile data.

6. The Base64-encoded image data is converted to a physical image file (in PNG format) and saved in the `src/main/resources/images/` directory.

7. The application uses Spring Data JPA and the `AccountProfileRepository` to persist the user profiles into the underlying database.

8. For each saved profile, the application generates an HTTP link to access the physical image file.

### How to Use the Application

To use the File Parser Application, follow these steps:

1. Clone the project from the repository.

2. Ensure you have Java and Maven installed on your system.

3. Open the project in your favorite IDE.

4. Update the database connection settings in the `application.properties` file, if necessary.

5. Run the `EnviroProjectApplication` class to start the application.

6. The application will read the `file.csv` file, process the data, and save the user profiles along with their image links into the database.

7. You can access the converted image files in the `src/main/resources/images/` directory.

### Dependencies

The application uses the following major dependencies:

- Spring Boot: For creating the application and managing the application context.
- Spring Data JPA: For interacting with the database and saving user profiles.
- Spring Web: For handling HTTP requests and responses.
- H2 Database: An embedded in-memory database for storing user profiles during development and testing.

### License

This project is open-source and distributed under the [MIT License](LICENSE).

Feel free to contribute to the project or use it for educational and non-commercial purposes.

For any questions or issues, please feel free to reach out to the project maintainers.
