CREATE TABLE messages
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    sender VARCHAR(100) NOT NULL,
    receiver VARCHAR(100) NOT NULL,
    date_time DATETIME NOT NULL
);
CREATE TABLE users
(
    name VARCHAR(100) PRIMARY KEY NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    password VARCHAR(256),
    age INT NOT NULL,
    sex VARCHAR(20) NOT NULL,
    city VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    contact_information LONGTEXT NOT NULL,
    blood_type VARCHAR(3) NOT NULL,
    quantity_needed INT,
    date_needed DATE,
    recent_medications LONGTEXT,
    allergies LONGTEXT,
    type INT NOT NULL,
    image LONGBLOB
);
ALTER TABLE messages ADD FOREIGN KEY (sender) REFERENCES users (name);
ALTER TABLE messages ADD FOREIGN KEY (receiver) REFERENCES users (name);
}