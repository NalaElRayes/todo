package app.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//Service class that has all the methods and service for the repository class which I instanceat through the Autowired annotation.
//This class and its methods will called from the controller class.
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    //Creates an entity of the object and saves it in the database
    public Todo createTodo(String text) {
        var todo = new Todo();
        todo.setText(text);
        return todoRepository.save(todo);
    }

    //Creates a list with all the objects in the database and returns the list
    public List<Todo> getAll() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll()
                .forEach(todos::add);
        return todos;

    }

    //Creates an arraylist with all the objects and filters the none true boolean objects away.
    // Returns a list with objects of the true value.
    public List<Todo> getAllActive(){
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);

        return todos.stream().filter(todo -> todo.getActive() == true).collect(Collectors.toList());

    }
    //Creates an array of all objects and filters the objects with true booleans out. Returns an list with objects of the boolen false.
    public List<Todo> getAllNotActive(){
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);

        return todos.stream().filter(todo -> todo.getActive() == false).collect(Collectors.toList());

    }

    //Deletes an object through its id
    public void deleteTodo(int id) {
        todoRepository.deleteById(id);
    }

    //takes an object and sets it boolean value to true or false
    public void updateActive(Todo todo) {
        todoRepository.save(todo);
    }

    //Method that filters every object that has its boolean to true and calls the deleteTodo function in the class.
    public void deleteActiveTodo() {
        List<Todo> todos = new ArrayList<>();

        todoRepository.findAll().forEach(todos :: add);
        todos.stream().filter(todo -> todo.getActive() == true).forEach(todo -> deleteTodo(todo.getId()));
    }


}
