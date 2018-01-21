-- CREATE DATABASE library;
use library;

-- DROP TABLE IF
drop table if exists book_reserve;
drop table if exists borrower;
drop table if exists book_info;
drop table if exists book;

-- CREATE TABLE
CREATE TABLE borrower(
borrower_ssn int(4) primary key auto_increment,
borrower_name varchar(50) not null, 
borrower_address varchar(100) not null,
borrower_phone int(8) not null,
borrower_mail varchar(100) not null, 
borrower_library_status boolean default true
);

CREATE TABLE book(
book_ISBN int(13) not null primary key,
book_title varchar(100) not null, 
book_author varchar(100) not null,
book_language varchar(50) not null,
book_publisher varchar(100) not null
);

CREATE TABLE book_info(
book_info_copyno int(4) primary key auto_increment,
book_info_borrowed_from varchar(50), 
book_info_borrowed_to varchar(50),
book_info_status boolean default true,
book_info_placing varchar(100) not null,
fk_book_ISBN int(13) not null,
foreign key(fk_book_ISBN) references book(book_ISBN)
);

CREATE TABLE book_reserve(
book_reserve_from varchar(50),
book_reserve_to varchar(50),
fk_book_info_copyno int(4) not null,
foreign key(fk_book_info_copyno) references book_info(book_info_copyno),
fk_borrower_ssn int(4),
foreign key(fk_borrower_ssn) references borrower(borrower_ssn)
);


-- INSERT INTO BOOK
INSERT INTO `library`.`book` (`book_ISBN`, `book_title`, `book_author`, `book_language`, `book_publisher`) VALUES 
('0747532699', 'Harry Potter And The Sorcerer\'s Stone', 'J.K. Roling', 'ENG', 'Bloomsbury');

INSERT INTO `library`.`book` (`book_ISBN`, `book_title`, `book_author`, `book_language`, `book_publisher`) VALUES 
('0747538492', 'Harry Potter And The Chamber Of Secrets', 'J.K. Roling', 'ENG', 'Bloomsbury');

INSERT INTO `library`.`book` (`book_ISBN`, `book_title`, `book_author`, `book_language`, `book_publisher`) VALUES 
('0747542155', 'Harry Potter And The Prisoner Of Azkaban', 'J.K. Roling', 'ENG', 'Bloomsbury');

INSERT INTO `library`.`book` (`book_ISBN`, `book_title`, `book_author`, `book_language`, `book_publisher`) VALUES 
('0747546241', 'Harry Potter And The Goblet Of Fire', 'J.K. Roling', 'ENG', 'Bloomsbury');

INSERT INTO `library`.`book` (`book_ISBN`, `book_title`, `book_author`, `book_language`, `book_publisher`) VALUES 
('0747551006', 'Harry Potter And The Order Of The Phoenix', 'J.K. Roling', 'ENG', 'Bloomsbury');

INSERT INTO `library`.`book` (`book_ISBN`, `book_title`, `book_author`, `book_language`, `book_publisher`) VALUES 
('0747581088', 'Harry Potter And The Half-Blood Prince', 'J.K. Roling', 'ENG', 'Bloomsbury');

INSERT INTO `library`.`book` (`book_ISBN`, `book_title`, `book_author`, `book_language`, `book_publisher`) VALUES 
('0545010225', 'Harry Potter And The Deathly Hallows', 'J.K. Roling', 'ENG', 'Bloomsbury');


-- INSERT INTO BOOK_INFO
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747532699');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747538492');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747542155');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747546241');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747551006');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747581088');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0545010225');

-- MORE COPYS OF SAME BOOK
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747532699');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747538492');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747542155');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747546241');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747551006');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747581088');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0545010225');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747532699');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747538492');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747542155');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747546241');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747551006');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747581088');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0545010225');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747532699');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747538492');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747542155');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747546241');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747551006');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0747581088');
INSERT INTO `library`.`book_info` (`book_info_placing`, `fk_book_ISBN`) VALUES ('Fiction', '0545010225');

-- INSERT INTO BORROWER
INSERT INTO `library`.`borrower` (`borrower_ssn`, `borrower_name`, `borrower_address`, `borrower_phone`, `borrower_mail`) VALUES 
('1111', 'Stephan', 'Tagensvej', '12345678', 'Stephan@gmail.com');

INSERT INTO `library`.`borrower` (`borrower_name`, `borrower_address`, `borrower_phone`, `borrower_mail`) VALUES 
('Gunni', 'Istegade', '12345678', 'Gunni@gmail.com');

INSERT INTO `library`.`borrower` (`borrower_name`, `borrower_address`, `borrower_phone`, `borrower_mail`) VALUES 
('2biass', 'Under vandet overflade', '12345678', '2biass@gmail.com');

INSERT INTO `library`.`borrower` (`borrower_name`, `borrower_address`, `borrower_phone`, `borrower_mail`) VALUES 
('Lone', 'Klubben', '12345678', 'Lone@gmail.com');

INSERT INTO `library`.`borrower` (`borrower_ssn`, `borrower_name`, `borrower_address`, `borrower_phone`, `borrower_mail`) VALUES 
('1234', 'cc', 'ccvej', '12345678', 'hest@hest.dk');


-- INSERT INTO BOOK_RESERVE
INSERT INTO `library`.`book_reserve` (`book_reserve_from`, `book_reserve_to`, `fk_book_info_copyno`, `fk_borrower_ssn`) VALUES ('1999-12-24', '2000-01-24', '7', '1111');
INSERT INTO `library`.`book_reserve` (`book_reserve_from`, `book_reserve_to`, `fk_book_info_copyno`, `fk_borrower_ssn`) VALUES ('2000-02-14', '2000-03-14', '7', '1112');
INSERT INTO `library`.`book_reserve` (`book_reserve_from`, `book_reserve_to`, `fk_book_info_copyno`, `fk_borrower_ssn`) VALUES ('2000-05-04', '2000-06-04', '7', '1113');
INSERT INTO `library`.`book_reserve` (`book_reserve_from`, `book_reserve_to`, `fk_book_info_copyno`, `fk_borrower_ssn`) VALUES ('2001-06-16', '2001-07-16', '7', '1114');







