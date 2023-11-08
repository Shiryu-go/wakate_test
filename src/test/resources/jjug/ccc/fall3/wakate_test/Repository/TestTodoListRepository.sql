CREATE TABLE ToDoList (
    ListId INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE ToDo (
    ListId INT NOT NULL,
    id INT PRIMARY KEY,
    ToDo_Title VARCHAR(255) NOT NULL,
    ToDo_Description TEXT,
    Done BOOLEAN NOT NULL,
    deadline DATE,
    FOREIGN KEY (ListId) REFERENCES ToDoList(ListId)
);

