Create table Person
(
    id integer not null ,
    name varchar(255),
    location varchar(255),
    birth_date timestamp,
    primary key(id)
);

Insert into Person
Values(1001,'Abhishek','Adra',CURRENT_Date());

Insert into Person
Values(1002,'Rio','China',CURRENT_Date());

Insert into Person
Values(1003,'Helsinky','US',CURRENT_Date());

