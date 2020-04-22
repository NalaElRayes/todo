package app.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//Controller class which has all the endpoints that will comunicate with the servise class through the Autowired annotation.
@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    //Start webpage, which will renderre all the created objects
    @GetMapping("/todo")
    public String startPage(Model model){
        List<Todo> listTodo = todoService.getAll();
        model.addAttribute("todos", listTodo);
        return "todo";
    }

    //Creates a todoObject, takes one parameter and sends it to the service class.
    @PostMapping("/create")
    public String saveTodo(@RequestParam("t1") String text){
        todoService.createTodo(text);
        return "redirect:todo";
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

    @GetMapping("/allNotActive")
    public List<Todo> getAllNotActive(){
        return todoService.getAllNotActive();
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



}
