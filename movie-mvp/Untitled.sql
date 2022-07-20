use tt;

show databases;

create table theaters(
	 theater_id bigint NOT NULL PRIMARY KEY auto_increment,
     theater_name varchar(30)
)

select * from theaters;
desc theaters;

- 상영관
    - 상영관번호(pk)
    - 상영관명
    - 좌석
    - 영화관번호(fk)
    - 등급번호(fk)

- 상영관 등급
    - 등급번호(pk)
    - 등급
    - 가격

- 영화
    - 영화번호(pk)
    - 영화명
    - 러닝타임

show tables;
desc cinemas;
desc movies;
desc screens;
desc theaters;
desc cinema_grade;

drop table cinemas;
drop table movies;
drop table screens;
drop table theaters;
drop table cinema_grade;



create table cinemas(
	 cinema_id bigint NOT NULL PRIMARY KEY auto_increment,
     cinema_name varchar(30), 
     chairs int,
     theater_id bigint,
     cinema_grade_id bigint
);



alter table cinemas
add FOREIGN KEY (theater_id) REFERENCES theaters (theater_id);

alter table cinemas
add FOREIGN KEY (cinema_grade_id) REFERENCES cinema_grade (cinema_grade_id);

desc cinemas;




create table cinema_grade(
	 cinema_grade_id bigint NOT NULL PRIMARY KEY auto_increment,
     grade varchar(20),
     price int
);

create table movies(
	movie_id bigint NOT NULL PRIMARY KEY auto_increment,
    movie_title varchar(50),
    running_time int
);

create table screens(
	screen_id bigint NOT NULL PRIMARY KEY auto_increment,
    round int,
    extra_seat int,
    cinema_id bigint,
    movie_id bigint
);


alter table screens
add FOREIGN KEY (cinema_id) REFERENCES cinemas (cinema_id);

alter table screens
add FOREIGN KEY (movie_id) REFERENCES movies (movie_id);


------

select * from movies;

INSERT INTO movies (movie_title, running_time)
values("토르 러브엔썬더", 128);
INSERT INTO movies (movie_title, running_time)
values("브로커", 152);


select * from theaters;

INSERT INTO theaters(theater_name)
values("안양 롯데시네마");
INSERT INTO theaters(theater_name)
values("범계 롯데시네마");



select * from cinema_grade;

INSERT INTO cinema_grade(grade, price)
values("basic", 7000);

INSERT INTO cinema_grade(grade, price)
values("special", 15000);




select * from cinemas;

INSERT INTO cinema_grade(grade, price)
values("basic", 7000);

INSERT INTO cinema_grade(grade, price)
values("special", 15000);







