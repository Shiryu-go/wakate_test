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
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ToDoListController.class)
class TestToDoListController {

    @Autowired
    /*
    参考URL : https://spring.pleiades.io/guides/gs/testing-web/
    SpringのMVCモデル用のテスト用クラスの依存性解決。
    実際のHTTPリクエストの代わりに、シミュレーションを行なってくれる。
     */
    MockMvc mockMvc;


    @MockBean
    /*
    Beanの置き換え処理を行なってくれるアノテーション。
    */
    ToDoListService toDoListService;

    @Autowired
    /*
    JSON型の文字列を、Javaクラスインスタンスの所持する変数に置き換えてくれるクラス。
    依存性の自動注入を行なっている。
    */
    ObjectMapper objectMapper;

    @Test
    void test_getTodoList()throws Exception{
        /*
        Mockの動作定義処理に必要な前処理工程
         */

        List<ToDo> list = new ArrayList<>();
        ToDo todo1 = new ToDo(1,1,"白菜","説明を入力",false,"2023-11-07");
        ToDo todo2 = new ToDo(1,2,"にんにく","説明を入力",false,"2023-11-07");
        list.add(todo1);
        list.add(todo2);
        ToDoList toDoList = new ToDoList(1,"今日の買い物リスト",list);
        /*
         Mockの動作定義処理
         */
        doReturn(toDoList).when(toDoListService).findAll();

        /*
        MockMVCによるHTTPリクエストのシミュレーション
         */
        String responseBody = mockMvc.perform(
                get("/")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.toDo.length()").value(2))
                .andExpect(jsonPath("$.toDo[0].ToDo_Title").value("白菜"))
                .andExpect(jsonPath("$.toDo[1].ToDo_Title").value("にんにく"))
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        String json = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(objectMapper.readTree(responseBody));
        /*
        レスポンスボディのログ出力
         */
        System.out.println(json);
    }
}