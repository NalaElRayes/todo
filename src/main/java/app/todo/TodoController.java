package app.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    /*takes an id of an object and deletes it. */
    @PostMapping("/deleteitem")
    public String deleteItem(@RequestParam int id){
        todoService.deleteTodo(id);
        return "redirect:todo";
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
    @RequestMapping(value = "/api",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateItem(@RequestBody Todo todo){
        todoService.updateActive(todo);
    }


    //Buttons

    //See all todoes
    @PostMapping("/all")
    public String all(Model model){
        return "redirect:todo";
    }

    //Deletes every to do in the list that has its boolean to true
    //Delete all checked (true) todoes
    @PostMapping("/deleteallcompleted")
    public String deleteAllCompleted(){
        todoService.deleteActiveTodo();
        return "redirect:todo";
    }

}
