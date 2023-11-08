package jjug.ccc.fall3.wakate_test.Repository;

import jjug.ccc.fall3.wakate_test.Record.ToDoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Sql("TestTodoListRepository.sql")
public class TestTodoListRepository {
    @Autowired
    JdbcTemplate jdbecTemplate;

    ToDoListRepository toDoListRepository;

    @BeforeEach
    void setUp(){
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
