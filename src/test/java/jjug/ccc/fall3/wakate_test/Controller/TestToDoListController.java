package jjug.ccc.fall3.wakate_test.Controller;

import jjug.ccc.fall3.wakate_test.Controller.ToDoListController;
import jjug.ccc.fall3.wakate_test.Service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ToDoListController.class)
class TestToDoListController {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ToDoListService catalogService;


}