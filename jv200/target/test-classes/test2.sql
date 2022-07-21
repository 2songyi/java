2)
create user 'too_much_talkers'@localhost identified by 'strong_typing_and_loud laughter';
create database noisyclass default character set utf8mb4;
grant all privileges on noisyclass.* to 'too_much_talkers'@localhost with grant option;
flush privileges;
