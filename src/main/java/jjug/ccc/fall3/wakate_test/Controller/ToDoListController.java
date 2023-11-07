package jjug.ccc.fall3.wakate_test.Controller;

import jjug.ccc.fall3.wakate_test.Record.ToDoList;
import jjug.ccc.fall3.wakate_test.Service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoListController {
    @Autowired
    ToDoListService toDoListService;
    @GetMapping("/")
    public ToDoList getToDoList(){
        return toDoListService.findAll();
    }
}
