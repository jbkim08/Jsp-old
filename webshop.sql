# 데이이터베이스 웹샵이 없으면 새로 생성 uft8mb4 한글 뿐만아니라 이모지 포함한 문자 가능
create database if not exists webshop 
default character set utf8mb4 collate utf8mb4_unicode_ci;

use webshop; # 웹샵을 선택

# 테이블 유저가 있으면 삭제하고 새로 만듬
DROP TABLE IF exists users;
create table users (
	id int primary key auto_increment,  # 유저 아이디 자동생성
    email varchar(50), 					# 이메일
    password varchar(50)				# 비번
);
