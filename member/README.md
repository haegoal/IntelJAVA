## database
```sql
create table member_table(
    id bigint primary key auto_increment,
    memberEmail varchar(30) unique,
    memberPassword varchar(20) not null,
    memberName varchar(20) not null,
    memberBirth date not null,
    memberMobile varchar(30) not null
);
```