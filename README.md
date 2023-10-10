# AtivDevWeb
Web Development Learning Assignment




Ativ 01
Suppose your municipal library needs a system to manage data from its book collection. Therefore, one of the things that needs to be created, in order to store and manage book data, is the library database.

Given the context and the problem, carry out the following activities to create the database and manage the information it will store:

1. Create a table to model user data;
a) The table must be called “user” and have the fields id, name, email, password, status;

2. Create a table to model the book data;
a) The table must be called “book” and have the fields id, name, isbn, author, publisher;

3. Create a table to demonstrate the list of book loans so that it is possible to know which book was loaned to a specific user
a) The table must be called “loan” and have the fields id, book_id (id of the book that was borrowed), user_id (id of the user who made the loan), date (date on which the loan was made) and situation. In this case, the situation field must assume the available or borrowed values.

4. Create a table to model the admin data, which in this case could be the librarian.
a) The table must be called “admin” and have the fields id, name, email and password.

To create the database and tables, use the DBMS (Database Management System) MySQL. Additionally, use the following credentials to connect to the database:

url = “localhost”
usuario = “aluno”
senha = “123456”

After creating the database and its tables, create a class with the Java programming language to access the database and manage the information contained in it. In this case, create such a class according to the DAO (Data Access Object) standard to manage only the book data (book table), for now. The class created with the DAO standard must contain methods to access and manipulate records in the book table such as list (needs to return a list with all books previously registered in the database), insert, change and delete.

Regarding the delivery of the activity, it is mandatory to send the files referring to the script that was used to create the tables in the database and the Java class referring to the DAO created to manipulate the data in the books.






Ativ 02
This activity is based on the previous discursive activity. Therefore, the code and data used in it can also be used to carry out this activity.

Suppose your municipal library needs a system to manage data from its book collection. Previously, a database was created with the book table and a DAO class in Java to manage the library's book data. However, it is a Web system, and it is necessary to create one or more pages that work in an integrated way with the Java DAO class and the database (book table) so that the library administrator is able to manage the library data. collection of books.

Given the context and the problem, carry out the following activities to create the Web application integrated with the database and complete it:

1. Create a page capable of displaying a list of each of the books registered in the database. Tip: Create a table on the web page with the HTML language so that the data for each book is displayed in the table rows. Thus, for each row in the table, enter the data for a specific book such as id, title, author, isbn and publisher.

2. Create the option to register new books. It is recommended to create a button on the screen that displays the list of books. Thus, when the administrator clicks on this button, he is redirected to a new screen with the new book registration form. In this case, it is necessary to create a book registration screen containing a form for the administrator to enter the book's data such as title, author, isbn and publisher. Use the data and types from the database book table as a basis. After the administrator finishes filling out the fields in the registration form, he can trigger the save function that records the new book's data in the database's book table.

3. Create book details screen. This screen should display data for a specific book such as title, author, isbn and publisher.

4. Create function to delete book records. This function must execute so that the record for a specific book is deleted from the database.

Tips:

Regarding the activity in item 3, create a link associated with each book that is displayed on the book listing screen (activity in item 1) so that, when clicked, the administrator is directed to the details screen with the information of that book. Use the book ID as a parameter for database searches.
In the case of activity in item 3, create a button associated with each book that is displayed on the book list screen (activity in item 1) so that, when clicked, the function responsible for deleting that book's record in the database. Use the book ID as a parameter for database deletion operations.
Additionally, use the following credentials to connect to the database:

url = “localhost”
user = “student”
password = “123456”

Regarding the delivery of the activity, it is mandatory to send the complete project, in a compressed file, containing all classes, JSP pages, HTML pages, CSS code and package organization in the correct locations. The project must also have the servlet and database connection settings defined so that it is possible to run the application on any machine without problems.

The file referring to the script that was used to create the tables in the database must also be sent, even if it has already been sent in the previous activity.

Guidelines for carrying out this activity:
The Java class must be compatible with the database table, being able to manipulate all its fields.
