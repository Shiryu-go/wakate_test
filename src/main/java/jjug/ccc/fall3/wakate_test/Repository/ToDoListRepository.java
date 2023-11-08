package jjug.ccc.fall3.wakate_test.Repository;

import jjug.ccc.fall3.wakate_test.Record.ToDoList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ToDoListRepository {
    private final JdbcTemplate jdbcTemplate;

    public ToDoListRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ToDoList findAll() {
        return null;
    }
}
