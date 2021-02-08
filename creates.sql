CREATE TABLE user_bank (
    id int PRIMARY KEY,
    name varchar(255) NOT NULL,
    username varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL
);

CREATE TABLE account (
    id int PRIMARY KEY,
    current_balance varchar(255) NOT NULL,
    fk_user int NOT NULL,
    FOREIGN KEY (fk_user) REFERENCES user_bank(id)
);

CREATE TABLE transaction (
    id int PRIMARY KEY,
    amount varchar(255) NOT NULL,
    date int NOT NULL UNIQUE,
    description varchar(255) NOT NULL,
    type varchar(255) NOT NULL,
    fk_source_account int NOT NULL,
    fk_destination_account int NOT NULL,
    FOREIGN KEY (fk_source_account) REFERENCES account(id),
    FOREIGN KEY (fk_destination_account) REFERENCES account(id)
);