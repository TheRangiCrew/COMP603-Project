/**
Document of all the table definitions for the MountainResort DB
**/

/** Users **/
CREATE TABLE Users (
    ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    firstName VARCHAR(30),
    lastName VARCHAR(30),
    email VARCHAR(255),
    password VARCHAR(255),
    phone VARCHAR(12),
    dob DATE,
    credit DECIMAL(10,2)
    
);

/** Lifts **/
CREATE TABLE Lifts (
    ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(50),
    openingTime TIME,
    closingTime TIME,
    status VARCHAR(15) CHECK (status IN ('CLOSED', 'OPEN', 'WIND_HOLD')),
    type VARCHAR(20) CHECK (type IN ('CHAIRLIFT_FIXED_GRIP', 'CHAIRLIFT_DETACHABLE', 'T_BAR', 'J_BAR', 'CONVEYOR', 'ROPE_TOW', 'GONDOLA')),
    length INT,
    capacity INT
);

/** Passes **/
CREATE TABLE LiftPasses (
    ID INT GENERATE ALWAYS AS IDENTITY PRIMARY KEY,
    validFrom TIMESTAMP,
    validTo TIMESTAMP,
    userID INT,
    FOREIGN KEY (userID) REFERENCES Users(ID)
)


