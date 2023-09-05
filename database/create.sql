create database timetable
default character set utf8
collate utf8_hungarian_ci;

grant all privileges
on timetable.*
to timetable@localhost
identified by 'titok';


create table team (
    id int not null primary key auto_increment,
    name varchar(50)
);

create table subject(
    id int not null primary key auto_increment,
    name varchar(50)
);

create table zone (
    id int not null primary key auto_increment,
    name varchar(50),
    hour int
);

create table chance (
    id int not null primary key auto_increment,
    date date,
    teamId int,
    subjectId int,
    zoneId int
);
