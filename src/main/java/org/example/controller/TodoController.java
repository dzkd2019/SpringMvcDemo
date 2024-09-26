package org.example.controller;

import org.example.entity.Person;
import org.example.entity.Todo;
import org.example.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mrawa_ltf
 */
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TodoController {
    private final TodoMapper mapper;
    private final TodoMapper todoMapper;
    private static int nextId = 1;
    private final ApplicationContext context;


    @Autowired
    public TodoController(TodoMapper mapper, TodoMapper todoMapper, ApplicationContext context) {
        this.mapper = mapper;
        this.todoMapper = todoMapper;
        this.context = context;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello, Spring MVC!";
    }

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/data")
    public Person data() {
//        return context.getBean("dataFromP", String.class);
        return context.getBean(Person.class);
    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return mapper.selectList(null);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") int id) {
        var todo = todoMapper.selectById(id);
        if(todo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(todo);
    }

    @PostMapping("/todo")
    public int addTodo(@RequestBody Todo todo) {
        int id = nextId++;
        var newTodo = new Todo(id, todo.content(), todo.emergency(), todo.deadline());
        todoMapper.insert(newTodo);
        return id;
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") int id) {
        int status = todoMapper.deleteById(id);
        if(status == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
