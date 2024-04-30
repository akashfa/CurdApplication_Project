# CurdApplication_Progect
The project uses the Model-View-Controller (MVC) design pattern and  appears to be designed to perform CRUD operations on Student objects.


src: This directory contains the source code for the application.

com.akash.controller: This package contains the controller classes for the application. These classes handle user interaction and business logic.
IStudentController.java: This interface defines the methods for the student controller.
StudentControllerImp.java: This class implements the IStudentController interface and provides the actual logic for CRUD operations on Student objects.

com.akash.dataobject: This package contains the data objects for the application. These classes represent the data that the application works with.
StudentBo.java: This class (likely) represents a Business Object and might encapsulate the business logic related to Student objects.
StudentDto.java: This class (likely) represents a Data Transfer Object and might be used to transfer student data between different layers of the application.
StudentVo.java: This class (likely) represents a View Object and might be used to represent student data in a way that is specific to the view layer of the application.

com.akash.factory: This package contains factory classes for the application. These classes are responsible for creating instances of other objects.
StudentControllerFactory.java: This class likely creates instances of the StudentController class.
StudentRepoFactory.java: This class likely creates instances of the StudentRepo class.
StudetnServiceFactory.java: There seems to be a typo in the class name. It should likely be StudentServiceFactory. This class likely creates instances of the StudentService class.

com.akash.MainApp: This class is likely the main class for the application. It is the entry point for the application.

com.akash.Properties: This package likely contains properties files for the application. These files contain configuration settings for the application.
database.properties: This file likely contains configuration settings for the database connection.

com.akash.Repo: This package contains the repository classes for the application. These classes are responsible for accessing and manipulating data from the database.
IStudentRepo.java: This interface defines the methods for the student repository.
StudentRepolmp.java: This class implements the IStudentRepo interface and provides the actual logic for accessing and manipulating student data from the database.

com.akash.service: This package contains the service classes for the application. These classes contain the business logic for the application.
IStudentService.java: This interface defines the methods for the student service.
StudentServicelmp.java: This class implements the IStudentService interface and provides the actual logic for the business logic related to Student objects.

com.akash.utility: This package contains utility classes for the application. These classes provide general-purpose functionality that can be used by other parts of the application.
jdbcUtility.java: This class likely provides utility methods for working with JDBC (Java Database Connectivity).
