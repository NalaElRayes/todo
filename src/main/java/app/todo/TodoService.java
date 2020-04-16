package app.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;


    public Todo createTodo(String text) {
        var todo = new Todo();
        todo.setText(text);
        return todoRepository.save(todo);
    }

    public List<Todo> getAll() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll()
                .forEach(todos::add);
        return todos;

    }
    public List<Todo> getAllActive(){
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);

        todos.stream().filter(todo -> todo.getActive() == true).collect(Collectors.toList());
        return todos;
    }

    public void deleteTodo(int id) {
        todoRepository.deleteById(id);
    }

    public void updateActive(int id, Todo todo) {
        todoRepository.save(todo);
    }
}
