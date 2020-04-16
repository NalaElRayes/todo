package app.todo;

import org.springframework.data.repository.CrudRepository;

//Interface that extends an crud class, the crud class has most of the methods I want use for spring JPA to connect to the database.
public interface TodoRepository extends CrudRepository<Todo, Integer> {

}
