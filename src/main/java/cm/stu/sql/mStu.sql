create table application_approval
(
    id                          int auto_increment
        primary key,
    course_id                   int           not null,
    student_id                  varbinary(10) not null,
    application_time            datetime      null,
    application_reason          varchar(100)  null,
    instructor_id               varbinary(10) null,
    instructor_approval         bit           null,
    instructor_is_finish        int           null,
    instructor_approval_time    datetime      null,
    instructor_approval_comment varchar(100)  null,
    supervisor_id               varbinary(10) null,
    supervisor_approval         bit           null,
    supervisor_is_finish        int           null,
    supervisor_approval_time    datetime      null,
    supervisor_approval_comment varchar(100)  null,
    all_is_finished             bit           null,
    constraint application_approval_id_uindex
        unique (id)
);

create table course
(
    courseID          int unsigned not null
        primary key,
    courseName        varchar(30)  not null,
    courseDescription varchar(30)  not null,
    applyCondition    varchar(100) not null
);

create table person
(
    userAccount   varbinary(10) not null
        primary key,
    userName      varbinary(50) null,
    userSex       varchar(5)    null,
    userBirthday  varbinary(22) null,
    userIdCard    varbinary(18) null,
    userPassword  varbinary(20) null,
    userIdentify  int           null,
    userOtherName varbinary(30) null
);

create table studenttask
(
    taskAccount    varchar(10)  null,
    studentAccount varchar(10)  null,
    studentAnswer  varchar(500) null,
    isFinish       int          null,
    isScore        int          null
);

create table task
(
    taskAccount    varchar(10)  null,
    teacherAccount varchar(10)  null,
    taskDate       varchar(20)  null,
    taskName       varchar(400) null
);

create table teacher_role
(
    trID       int auto_increment
        primary key,
    teacher_ID varbinary(10) null,
    course_ID  int           null,
    role       int           null,
    constraint teacher_role_trID_uindex
        unique (trID)
);

create table userteacher
(
    userAccount    varchar(10) null,
    teacherAccount varchar(10) null
);

