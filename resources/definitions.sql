/**
Document of all the table definitions for the MountainResort DB
**/

/** Users **/
CREATE TABLE Users (
    userID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    firstName VARCHAR(30),
    lastName VARCHAR(30),
    email VARCHAR(255),
    password VARCHAR(255),
    phone VARCHAR(12),
    dob DATE,
    credit DECIMAL(10,2) WITH DEFAULT 0.00
    
);

/** Lifts **/
CREATE TABLE Lifts (
    liftID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    liftName VARCHAR(50),
    openingTime TIME,
    closingTime TIME,
    liftStatus VARCHAR(15) CHECK (liftStatus IN ('CLOSED', 'OPEN', 'WIND_HOLD')),
    liftType VARCHAR(20) CHECK (liftType IN ('CHAIRLIFT_FIXED_GRIP', 'CHAIRLIFT_DETACHABLE', 'T_BAR', 'J_BAR', 'CONVEYOR', 'ROPE_TOW', 'GONDOLA')),
    length INT,
    capacity INT
);

/** Passes **/
CREATE TABLE LiftPasses (
    passID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    validFrom TIMESTAMP,
    validTo TIMESTAMP,
    userID INT,
    FOREIGN KEY (userID) REFERENCES Users(userID)
);

/** Cafe Items **/
CREATE TABLE CafeItems (
    itemID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    category VARCHAR(20) CHECK (category IN ('BREAKFAST', 'LUNCH_DINNER', 'DRINKS')),
    itemName VARCHAR(50),
    price DECIMAL(4,2),
    description VARCHAR(125)
);

/** Rental Equipment Types **/
CREATE TABLE RentalEquipmentTypes (
    rentalEquipmentTypeID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    rentalEquipmentTypeName VARCHAR(50)
);


/** Rental Equipment **/
CREATE TABLE RentalEquipment (
    equipmentID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    equipmentName VARCHAR(25),
    equipmentSize VARCHAR(10),
    equipmentSizeUnit VARCHAR(20),
    equipmentAvailability INT,
    equipmentType INT,
    FOREIGN KEY (equipmentType) REFERENCES RentalEquipmentTypes(rentalEquipmentTypeID)
);

/** Rentals **/
CREATE TABLE Rentals (
  rentalID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  rentedFrom TIMESTAMP,
  rentedTo TIMESTAMP,
  equipmentID INT,
  userID INT,
  FOREIGN KEY (equipmentID) REFERENCES RentalEquipment(equipmentID),
  FOREIGN KEY (userID) REFERENCES Users(userID)
);