package jjug.ccc.fall3.wakate_test.Service;


import jjug.ccc.fall3.wakate_test.Record.ToDo;
import jjug.ccc.fall3.wakate_test.Record.ToDoList;
import jjug.ccc.fall3.wakate_test.Repository.ToDoListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class TestToDoLiseService {
    @InjectMocks
    ToDoListService toDoListService;
    @Mock
    ToDoListRepository toDoListRepository;

    @Test
    void test_findAll(){
        List<ToDo> list = new ArrayList<>();
        ToDo todo1 = new ToDo(1,1,"白菜","説明を入力",false,"2023-11-07");
        ToDo todo2 = new ToDo(1,2,"にんにく","説明を入力",false,"2023-11-07");
        list.add(todo1);
        list.add(todo2);
        ToDoList toDoList = new ToDoList(1,"今日の買い物リスト",list);
        doReturn(toDoList).when(toDoListRepository).findAll();
        ToDoList toDoList1 = toDoListService.findAll();

        assertThat(toDoList1.toDo().get(0).ToDo_Title()).isEqualTo("白菜");
    }
}
