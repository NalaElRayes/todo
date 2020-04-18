package app.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//Controller class which has all the endpoints that will comunicate with the servise class through the Autowired annotation.
@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    //Creates a todoObject
    @PostMapping
    public Todo createTodo(@RequestParam Map<String, String> body){
         return todoService.createTodo(body.get("text"));
    }

    /*returns a list of all todos*/
    @GetMapping
    public List<Todo> getList(){
        return todoService.getAll();

    }

    /*takes an id of an object and deletes it. */
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
    }

    /*Shows all objects with the boolean true in a list*/
    @GetMapping("/allActive")
    public List<Todo> getAllActive(){
        return todoService.getAllActive();
    }

    /* Takes in a an object, through its id and changes its boolean to true or false. The user choose*/
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateActive(@RequestBody Todo todo, @PathVariable int id) {
        todoService.updateActive(id, todo);
    }

    //Deletes every to do in the list that has its boolean to true
    @DeleteMapping("/delete/active")
    public void deleteActiveTodo(){
        todoService.deleteActiveTodo();
    }

    //Post method that gets posted through url, calles up on a method in the service class.
    @PostMapping ("/allactive")
    public List<Todo> setAllTodosToActive(){
        todoService.setAllTodosToActive();
        return todoService.setAllTodosToActive();
    }

   /* @GetMapping("/itemsleft")
    public List<Todo> itemsLeft(){
        todoService.itemsLeft();
    }*/

}
