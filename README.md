# todo
Backend project

To check the app on youtube copy the link: https://youtu.be/NqSOrh3-Eww

My entity class is an information for the database of what my schema will be named and what primary key it has and also which colums it will have. The database datasourse and ddl is set to create. Which means every time I start my applikation over it will create the schema again and it will be reseted.  
All the request that will be requested will go through the restapis in the controller class. In the Controller class it will later call the methods on the service class.In the service class is where all the methods is defined for saving, deleting or retriving from the mysql database through JPA Hibernate. The service classes methods will be called on the repository interface which is an interrface that extends the CrudRepository class. This class has all the methods that talks to the database. And thats why we have an instence of the repository class in the service class. 
Spring boot has a saying "convention over configuration". Thats why there is no creation of the classes with the new keyword. Springs takes care of that through the annotation @Autowired. Which is used in the controller-, service- and Repository class. This is @Auotowired annotation should not be used if there is a lot of dependencies in a class or if the application is big. But for thiss app it is fine to use autowired on a field. 

I have choosen to modify my er diagram to have an entity of todo and its attributes to be id, text and boolean. Instead of my original ones that I choose. This makes more sence for the app. 
Id is a self generated int that will be generated in creation of an todo. The text is a string that will be set to whatever the user writes in. The boolen is set to false by defeult. 
The user stories has not been modifyied. 


How to accses the restful apis from Postman

Defeult url for the application http://localhost:8080/todo

Method createTodo()
This method is accsesed through a postrequest, which posts a Key (text) and a value the id is selfgenerated and the boolean is set to false by defeult. In postman go the url http://localhost:8080/todo set the method to post and write the key and value in the body. 

Method getList()
Accsesed through a get request. Uses the defeult url. set the method to get and send. And all the todo object will be delivered. 

Method deleteTodo()
This is a delete request and deletes whatever object you wanna delete. To choose the object: write the objects id in the url, set the request to delete and send. 

Method getAllActive()
To get all the object that has its active to set to true. Go to the defeult url and add "/allActive". set the request to get and send.

Method updateActive()
Request method is put and updates an object to the input that is set to the body. The user chooses which object to modify through its id. Add the id of the object to the defeult url, set the method to put and write the ney values and send. 

Method deleteActiveTodo()
Deletes all the objects with boolean set to true. 
Set the request to delete, add the "/delete/active" url to the defeult url and press send. 


I have choosen to use Hibernate for my data base connectivity. Since it is very hands on and simply to use. Hibernate lets me speak with the databse through java methods that is implemented in the crudrepositroy class that is extended from the repository interface. Hibernate is a cleancode way to avoid boilerplate code. I could have used a jdbc driver or spring jpa and write and define sql statments but that would have resultad in so much more code. 

Since the app is modified to work with the front end. The controllers api has also been modified, Check the older commits to see how it was when it was made to just be a funktionening backend undepending on the frontend. 

Hope you like it
Nala El Rayes



