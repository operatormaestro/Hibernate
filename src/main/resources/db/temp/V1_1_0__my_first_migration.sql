create table netology.persons
(
    name           varchar not null,
    surname        varchar not null,
    age            int     not null,
    phone_number   varchar not null,
    city_of_living varchar not null,
    primary key (name, surname, age)
);

insert into netology.persons values ('Игорь', 'Иванов', 35, '+7(999)-999-99-99','MOSCOW');
insert into netology.persons values ('Анна', 'Иванова', 32, '+7(999)-999-99-91','MOSCOW');
insert into netology.persons values ('Jack', 'Jones', 54, '+20(999)-999-99-92','LONDON');
insert into netology.persons values ('Ruud', 'Swedenborg', 17, '+31(999)-999-99-93','BERN');
insert into netology.persons values ('Мария', 'Купатова', 41, '+7(999)-999-99-94','MOSCOW');
insert into netology.persons values ('Ринат', 'Юсупов', 77, '+7(999)-999-99-94','KAZAN');
