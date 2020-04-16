package app.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    //Creates a todo
    @PostMapping
    public Todo createTodo(@RequestParam Map<String, String> body){
         return todoService.createTodo(body.get("text"));
    }

    /*returns a list of todos*/
    @GetMapping
    public List<Todo> getList(){
        return todoService.getAll();

    }

    /*takes an id of an todo and deletes it. */
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
    }

    /*Shos all actives todo in a list*/
    @GetMapping("/allActive")
    public List<Todo> getAllActive(){
        return todoService.getAllActive();
    }

    /* Takes in a id of an todo and changes it to active or false, the user choose*/
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateActive(@RequestBody Todo todo, @PathVariable int id) {
        todoService.updateActive(id, todo);
    }



}
