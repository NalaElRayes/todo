package app.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/todo")
public class Controller {

    @Autowired
    private TodoService todoService;


    @PostMapping
    public Todo createTodo(@RequestParam Map<String, String> body){
         return todoService.createTodo(body.get("text"));
    }

    @GetMapping
    public List<Todo> getList(){
        return todoService.getAll();

    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
    }

    @GetMapping("/allActive")
    public List<Todo> getAllActive(){
        return todoService.getAllActive();
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateActive(@RequestBody Todo todo, @PathVariable int id) {
        todoService.updateActive(id, todo);
    }



}
