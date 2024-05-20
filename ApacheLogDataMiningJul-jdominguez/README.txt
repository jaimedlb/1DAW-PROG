Primary key:
hash de el String entero del log
CREATE TABLE APACHE_LOG_TBL (
HASH number NOT NULL,
IP VARCHAR2(17) NOT NULL,
TIMESTAMP VARCHAR2(60) NOT NULL,
REQUEST VARCHAR2(1600) NOT NULL,
RESULT VARCHAR2(3) NOT NULL,
BYTES NUMBER NOT NULL,
UA VARCHAR2(500) NOT NULL,
constraint HASH_PK primary key (HASH)
);
Calculos adicionales: 
veces que se hacen request en cada hora
//esto puede servir para añadir mas recursos a cierta hora para que el servidor no se sature en las horas pico

numero de bytes totales transferidos cada mes
//esto puede servir para que en ciertos meses donde la carga sea menor o mayor ajustar el servidor

Multi-SGBD:MARIADB implementada mediante variable llamada "BBDD"
