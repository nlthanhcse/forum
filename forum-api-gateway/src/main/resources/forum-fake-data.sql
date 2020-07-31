ALTER TABLE category AUTO_INCREMENT = 1;
insert into category
values (null, "Angular"),
       (null, "Javascript"),
       (null, "Spring Boot"),
       (null, "AWS"),
       (null, "Spring MVC");

ALTER TABLE user AUTO_INCREMENT = 1;
insert into user
values (null, "Nguyễn Lâm Thành", "nlthanhcse", "$2y$12$uJDGUyOh/z5QQp1u0aVoHeXVWZmFjvy86GQGcYTjaVYwOoKNAg4dS
", "img", "ROLE_ADMIN"),
       (null, "Michael Nguyễn", "michaelcse", "$2y$12$uJDGUyOh/z5QQp1u0aVoHeXVWZmFjvy86GQGcYTjaVYwOoKNAg4dS
", "img", "ROLE_ADMIN"),
       (null, "Nguyễn Lâm Thành 1", "nlthanhcse1", "$2y$12$uJDGUyOh/z5QQp1u0aVoHeXVWZmFjvy86GQGcYTjaVYwOoKNAg4dS
", "img", "ROLE_USER"),
       (null, "Nguyễn Lâm Thành2", "nlthanhcse2", "$2y$12$uJDGUyOh/z5QQp1u0aVoHeXVWZmFjvy86GQGcYTjaVYwOoKNAg4dS
", "img", "ROLE_USER"),
       (null, "Michael Nguyễn1", "michael2", "$2y$12$uJDGUyOh/z5QQp1u0aVoHeXVWZmFjvy86GQGcYTjaVYwOoKNAg4dS
", "img", "ROLE_USER");

ALTER TABLE post AUTO_INCREMENT = 1;
insert into post
values (null, "Test content 1", "2020-07-31", 1, 2, 1, 1),
       (null, "Test content 2", "2020-07-31", 2, 2, 1, 2),
       (null, "Test content 3", "2020-07-31", 2, 2, 4, 3),
       (null, "Test content 4", "2020-07-31", 2, 2, 5, 2),
       (null, "Test content 5", "2020-07-31", 2, 2, 3, 5),
       (null, "Test content 6", "2020-07-31", 2, 2, 4, 4),
       (null, "Test content 7", "2020-07-31", 2, 2, 5, 1),
       (null, "Test content 8", "2020-07-31", 2, 2, 5, 3),
       (null, "Test content 9", "2020-07-31", 2, 2, 1, 5),
       (null, "Test content 10", "2020-07-31", 2, 2, 2, 1);

ALTER TABLE comment AUTO_INCREMENT = 1;
insert into comment
values (null, "Test comment of post 1", "2020-07-31", 2, 2, 1, 1),
       (null, "Test comment of post 2", "2020-07-31", 2, 2, 2, 1),
       (null, "Test comment of post 3", "2020-07-31", 2, 2, 3, 2),
       (null, "Test comment of post 4", "2020-07-31", 2, 2, 4, 5),
       (null, "Test comment of post 9", "2020-07-31", 2, 2, 9, 4),
       (null, "Test comment of post 5", "2020-07-31", 2, 2, 3, 1),
       (null, "Test comment of post 6", "2020-07-31", 2, 2, 2, 1),
       (null, "Test comment of post 4", "2020-07-31", 2, 2, 6, 2),
       (null, "Test comment of post 10", "2020-07-31", 2, 2, 7, 5),
       (null, "Test comment of post 7", "2020-07-31", 2, 2, 5, 4);

ALTER TABLE user_comment AUTO_INCREMENT = 1;
insert into user_comment
values ("like", 1, 1),
       ("unlike", 2, 1),
       ("like", 2, 2),
       ("like", 3, 2),
       ("unlike", 3, 1);

ALTER TABLE user_post AUTO_INCREMENT = 1;
insert into user_post
values ("like", 1, 1),
       ("unlike", 2, 1),
       ("like", 2, 2),
       ("like", 3, 2),
       ("unlike", 3, 1);
