package jjug.ccc.fall3.wakate_test.Service;

import jjug.ccc.fall3.wakate_test.Record.ToDoList;
import jjug.ccc.fall3.wakate_test.Repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {
    @Autowired
    ToDoListRepository toDoListRepository;
    public ToDoList findAll() {
        return toDoListRepository.findAll();
    }
}
