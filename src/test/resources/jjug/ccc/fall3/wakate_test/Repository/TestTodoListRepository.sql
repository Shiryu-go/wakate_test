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

INSERT INTO ToDoList
(ListId, title) VALUES
(1, '買い物リスト')
,(2, 'スタンプラリー箇所')
;

INSERT INTO ToDo
(ListId, id , ToDo_Title , ToDo_Description , Done , deadline) VALUES
(1,1, '白菜','入力してください',false,'2023-11-08')
,(1,2, 'ほうれん草','入力してください',false,'2023-11-08')
;

