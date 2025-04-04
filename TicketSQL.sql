CREATE DATABASE ticketSystem;

CREATE TABLE Ticket (
    id INT PRIMARY KEY,
    reporter VARCHAR(255),
    description TEXT,
    status VARCHAR(255),
    created_at TIMESTAMP
);

ALTER TABLE Ticket MODIFY id INT AUTO_INCREMENT;

select * FROM Ticket;
