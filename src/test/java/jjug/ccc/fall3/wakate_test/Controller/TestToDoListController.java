package jjug.ccc.fall3.wakate_test.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jjug.ccc.fall3.wakate_test.Record.ToDo;
import jjug.ccc.fall3.wakate_test.Record.ToDoList;
import jjug.ccc.fall3.wakate_test.Service.ToDoListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ToDoListController.class)
class TestToDoListController {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ToDoListService toDoListService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void test_getTodoList()throws Exception{
        List<ToDo> list = new ArrayList<>();
        ToDo todo1 = new ToDo("白菜","説明を入力",false,new Date(2023/11/7));
        ToDo todo2 = new ToDo("にんにく","説明を入力",false,new Date(2023/11/7));
        list.add(todo1);
        list.add(todo2);
        ToDoList toDoList = new ToDoList("今日の買い物リスト",list);
        doReturn(toDoList).when(toDoListService).findAll();

        String responseBody = mockMvc.perform(
                get("/")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$.toDo[0].ToDo_Title").value("白菜"))
                .andExpect(jsonPath("$.toDo[1].ToDo_Title").value("にんにく"))
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        String json = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(objectMapper.readTree(responseBody));
        System.out.println(json);

    }


}