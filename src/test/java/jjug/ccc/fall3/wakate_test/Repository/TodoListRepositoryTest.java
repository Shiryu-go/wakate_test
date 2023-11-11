package jjug.ccc.fall3.wakate_test.Repository;

import jjug.ccc.fall3.wakate_test.Record.ToDoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

/*
データベースのテストを行うための宣言
 */
@JdbcTest
/*
組み込みデータベースに対して、Sqlの実行を行なっている。
このテストクラスでは、このSQlの処理を行なったデータベースに対してアクセスを行う。
 */
@Sql("TestTodoListRepository.sql")
public class TodoListRepositoryTest {
    /*
    今回はjdbcTestを使用します。
     */
    @Autowired
    JdbcTemplate jdbecTemplate;

    ToDoListRepository toDoListRepository;

    @BeforeEach
    void setUp(){
        /*
        jdbcTemplateの使用準備
         */
        toDoListRepository = new ToDoListRepository(jdbecTemplate);
    }

    @Test
    void TestFindAll() {
        ToDoList toDoList = new ToDoList(1,"買い物リスト",toDoListRepository.findAll());
        assertThat(toDoList.title()).isEqualTo("買い物リスト");
        assertThat(toDoList.toDo().size()).isEqualTo(2);
        assertThat(toDoList.toDo().get(0).ToDo_Title()).isEqualTo("白菜");
    }
}