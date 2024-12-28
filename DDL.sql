create table questions (
id serial4 not null,
question_text varchar(100),
constraint questions_pk PRIMARY KEY (id),
constraint questions_un UNIQUE (question_text)
);

create table answers (
id serial4 not null,
question_id int4 not null,
answer_number int4 not null,
answer_text varchar(100) not null,
answer_true boolean,
constraint answers_pk PRIMARY KEY (id),
CONSTRAINT answers_fk FOREIGN KEY (question_id) REFERENCES public.questions(id)
);


drop table answers; 
drop table questions; 