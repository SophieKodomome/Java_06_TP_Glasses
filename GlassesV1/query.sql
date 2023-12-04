
create user solo identified by maso;
grant create all privileges to solo;
connect solo/maso

drop sequence montureIdSeq;
drop sequence lenseIdSeq;

drop table logAchat;
drop table monture;
drop table lense;

CREATE SEQUENCE montureIdSeq START WITH 1 INCREMENT BY 1 MINVALUE 0;
CREATE SEQUENCE lenseIdSeq START WITH 1 INCREMENT BY 1 MINVALUE 0; 

CREATE TABLE monture(
    id NUMBER,
    CONSTRAINT monturePK PRIMARY KEY(id),
    nom VARCHAR(20),
    img VARCHAR(20),
    prix NUMBER,
    stock NUMBER
);

CREATE TABLE lense(
    id NUMBER,
    CONSTRAINT lensePK PRIMARY KEY(id),
    nom VARCHAR(20),
    img VARCHAR(20),
    prix NUMBER,
    stock NUMBER
);

CREATE TABLE logAchat(
    id NUMBER,
    idMonture NUMBER,
    CONSTRAINT logAchatFK FOREIGN KEY(idMonture) REFERENCES monture(id),
    idLense NUMBER,
    CONSTRAINT logAchatFK2 FOREIGN KEY(idLense) REFERENCES lense(id),
    Prix NUMBER
);

INSERT INTO monture VALUES(montureIdSeq.NEXTVAL,'monture 1','img/bro/',100,20);
INSERT INTO monture VALUES(montureIdSeq.NEXTVAL,'monture 2','img/bro/',150,20);
INSERT INTO monture VALUES(montureIdSeq.NEXTVAL,'monture 3','img/bro/',200,20);
INSERT INTO monture VALUES(montureIdSeq.NEXTVAL,'monture 4','img/bro/',250,20);
INSERT INTO monture VALUES(montureIdSeq.NEXTVAL,'monture 5','img/bro/',300,20);

INSERT INTO lense VALUES(lenseIdSeq.NEXTVAL,'verre 1','1.png',100,20);
INSERT INTO lense VALUES(lenseIdSeq.NEXTVAL,'verre 2','2.png',150,20);
INSERT INTO lense VALUES(lenseIdSeq.NEXTVAL,'verre 3','3.png',200,20);
INSERT INTO lense VALUES(lenseIdSeq.NEXTVAL,'verre 4','4.png',250,20);
INSERT INTO lense VALUES(lenseIdSeq.NEXTVAL,'verre 5','5.png',300,20);

commit;