CREATE TABLE IF NOT EXISTS users
(
    id UUID PRIMARY KEY ,
    login  text NOT NULL ,
    email text NOT NULL ,
    phone VARCHAR(20)  NOT NULL,
    lastName text NOT NULL,
    firstName text NOT NULL,
    middleName text
    );
