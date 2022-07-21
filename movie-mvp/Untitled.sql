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

INSERT INTO movies (title, running_time)
values("토르 러브엔썬더", 128);
INSERT INTO movies (title, running_time)
values("브로커", 152);
INSERT INTO movies (title, running_time)
values("미니언즈2", 92);
INSERT INTO movies (title, running_time)
values("외계+인 1부", 138);


select * from theaters;

INSERT INTO theaters(theater_name)
values("안양 롯데시네마");
INSERT INTO theaters(theater_name)
values("범계 롯데시네마");
INSERT INTO theaters(theater_name)
values("신도림 롯데시네마");



select * from cinema_grade;

INSERT INTO cinema_grade(grade, price)
values("basic", 7000);

INSERT INTO cinema_grade(grade, price)
values("special", 15000);




select * from cinemas;
select * from cinemas where theater_id = 1;

INSERT INTO cinemas(cinema_name, chairs, theater_id, cinema_grade_id)
values("1상영관", 70, 1, 1);

INSERT INTO cinemas(cinema_name, chairs, theater_id, cinema_grade_id)
values("2상영관", 380, 1, 1);

INSERT INTO cinemas(cinema_name, chairs, theater_id, cinema_grade_id)
values("3상영관", 82, 1, 2);

INSERT INTO cinemas(cinema_name, chairs, theater_id, cinema_grade_id)
values("4상영관", 232, 1, 1);

INSERT INTO cinemas(cinema_name, chairs, theater_id, cinema_grade_id)
values("5상영관", 62, 1, 2);

INSERT INTO cinemas(cinema_name, chairs, theater_id, cinema_grade_id)
values("1상영관", 392, 2, 1);

INSERT INTO cinemas(cinema_name, chairs, theater_id, cinema_grade_id)
values("2상영관", 282, 2, 1);

INSERT INTO cinemas(cinema_name, chairs, theater_id, cinema_grade_id)
values("3상영관", 198, 2, 1);

INSERT INTO cinemas(cinema_name, chairs, theater_id, cinema_grade_id)
values("1상영관", 72, 3, 2);




select * from screens;

# 좌석 수, 해당 상영관보다 클 경우 에러(계산 로직 필요)
INSERT INTO screens(round, extra_seat, cinema_id, movie_id)
values(1, 58, 1, 1);

INSERT INTO screens(round, extra_seat, cinema_id, movie_id)
values(1, 288, 2, 2);

#...














