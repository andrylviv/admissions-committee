CREATE TABLE user (
                     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                     email varchar(45) UNIQUE,
                     role varchar(45),
                     password varchar(200)
                     );

CREATE TABLE user_info (
                     id INT NOT NULL PRIMARY KEY,
                     first_name varchar(45),
                     last_name varchar(45),
                     patronymic varchar(45),
                     city varchar(45),
                     region varchar(45),
                     school varchar(45),
                     uk_lang int,
                     uk_liter int,
                     eng int,
                     algebra int,
                     informatics int,
                     geometry int,
                     uk_history int,
                     ph_training int,
                     physics int,
                     eie_uk_lang int,
                     eie_math int,

                     FOREIGN KEY (id) REFERENCES user(id)
                       );

CREATE TABLE faculty (
                     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                     faculty varchar(45),
                     st_funded_places int,
                     tot_places int
                     );

CREATE TABLE user_faculty (
                           user_id int,
                           faculty_id int,
                           FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
                           FOREIGN KEY (faculty_id) REFERENCES faculty(id) ON DELETE CASCADE);

INSERT INTO user VALUES (DEFAULT , '');
