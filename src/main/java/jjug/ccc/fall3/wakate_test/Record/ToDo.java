package jjug.ccc.fall3.wakate_test.Record;

import java.util.Date;

public record ToDo(
        int ListId,
        int id,
        String ToDo_Title,
        String ToDo_Description,
        Boolean Done,
        Date deadline
) {}
