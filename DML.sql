insert into questions (question_text) values 
('Какой город является столицей России?'),
('В какой стране город Женева?'),
('В каком океане расположен остров Бали?'),
('Какая страна самая большая в мире?'),
('Какой город является столицей Франции?');

insert into answers (question_id, answer_number,  answer_text, answer_true) values 
(1, 1, 'Ростов-на-Дону', false),
(1, 2, 'Москва', true),
(1, 3, 'Тамбов', false),
(1, 4, 'Екатеринбург', false),
(2, 1, 'Россия', false),
(2, 2, 'Япония', false),
(2, 3, 'Щвейцария', true),
(3, 1, 'Тихий', false),
(3, 2, 'Индийский', true),
(3, 3, 'Атлантический', false),
(4, 1, 'Китай', false),
(4, 2, 'Россия', true),
(4, 3, 'Новая Зеландия', false),
(5, 1, 'Париж', true),
(5, 2, 'Москва', false);


select q.id, q.question_text, a.answer_number, a.answer_text, a.answer_true 
from questions q inner join answers a on q.id = a.question_id;

