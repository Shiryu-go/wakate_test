package jjug.ccc.fall3.wakate_test.Repository;

import jjug.ccc.fall3.wakate_test.Record.ToDo;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToDoListRepository {
    private final JdbcTemplate jdbcTemplate;

    public ToDoListRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ToDo> findAll() {
        return jdbcTemplate.query("SELECT * FROM todo where ListId = 1",new DataClassRowMapper<>(ToDo.class));
    }
}
