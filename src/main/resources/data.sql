insert into question_sets(question_set_id, name, count)
       values (1, 'test_set', 0);

insert into questions(question_id, title, body, category, question_set_id)
values (1, 'test1', 'test1 body', 'ONE', 1);

insert into questions(question_id, title, body, category, question_set_id)
values(2, '2번째 타이틀', '2번째 바디', 'ONE', 1);

insert into questions(question_id, title, body, category, question_set_id)
values(3, '3번째 타이틀', '3번째 바디', 'ONE', 1);

insert into questions(question_id, title, body, category, question_set_id)
values(4, '5번째 타이틀', '5번째 바디', 'ONE', 1);

