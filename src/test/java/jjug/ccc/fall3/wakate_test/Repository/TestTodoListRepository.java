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
@Sql("TestTodoListRepository")
public class TestTodoListRepository {
    @Autowired
    JdbcTemplate jdbecTemplate;

    ToDoListRepository toDoListRepository;

    @BeforeEach
    void setUp(){
        toDoListRepository = new ToDoListRepository(jdbecTemplate);
    }

    @Test
    void findAll() {
        ToDoList toDoList = toDoListRepository.findAll();
        assertThat(product.getName()).isEqualTo("消しゴム");
        assertThat(product.getPrice()).isEqualTo(100);
        assertThat(product.getStock()).isEqualTo(10);
    }


}
