package org.example.Todopractice;

import org.example.Todopractice.todoPackage.ToDo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ToDoController {
    List<ToDo> mytodo;
public ToDoController() {
    mytodo = new ArrayList<>();
}
public List<ToDo> getalltodos(){
    return mytodo;
}
@GetMapping("todo/done")
public List<ToDo> getdonetodos(){
    List<ToDo> donetodos=new ArrayList<>();
    for(ToDo todos:mytodo){
        if(todos.isTodoDoneStatus()){
            donetodos.add(todos);
        }
    }
    return donetodos;
}

public String addtodo(@RequestBody ToDo todo){
    mytodo.add(todo);
    return "ToDo added.";
}

public String removetodo(@RequestParam Integer ToDoId){
    for(ToDo todo : mytodo){
        if(todo.getTodoId().equals(ToDoId)){
            mytodo.remove(todo);
            return "todo has been removed";
        }
    }return "Id could not be found";
}

public String markTodo(@PathVariable Integer todoId, @PathVariable boolean Status){
    for(ToDo todo : mytodo){
        if(todo.getTodoId().equals(todoId)){
            todo.setTodoDoneStatus(Status);
            return "Id has been updated";
        }
    }return "Id could not be found";
}
}
