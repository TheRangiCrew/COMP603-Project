INSERT INTO RentalEquipmentTypes (rentalEquipmentTypeName)
VALUES ('Snowboard'), ('Ski'), ('Ski Pole'), ('Boots'), ('Clothing'), ('Taboggan');

INSERT INTO RentalEquipment (equipmentName, equipmentSize, equipmentSizeUnit, equipmentAvailability, equipmentType)
VALUES
    -- Snowboard
    ('Snowboard', '160', 'cm', 10, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Snowboard')),
    ('Snowboard', '155', 'cm', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Snowboard')),
    ('Snowboard', '158', 'cm', 12, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Snowboard')),
    ('Snowboard', '162', 'cm', 6, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Snowboard')),
    ('Snowboard', '150', 'cm', 15, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Snowboard')),
    ('Snowboard', '163', 'cm', 9, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Snowboard')),
    ('Snowboard', '157', 'cm', 11, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Snowboard')),
    ('Snowboard', '159', 'cm', 7, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Snowboard')),
    ('Snowboard', '154', 'cm', 13, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Snowboard')),
    ('Snowboard', '161', 'cm', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Snowboard')),

    -- Ski
    ('Ski', '170', 'cm', 10, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski')),
    ('Ski', '165', 'cm', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski')),
    ('Ski', '160', 'cm', 12, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski')),
    ('Ski', '175', 'cm', 6, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski')),
    ('Ski', '155', 'cm', 15, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski')),
    ('Ski', '168', 'cm', 9, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski')),
    ('Ski', '163', 'cm', 11, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski')),
    ('Ski', '157', 'cm', 7, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski')),
    ('Ski', '166', 'cm', 13, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski')),
    ('Ski', '172', 'cm', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski')),

    -- Ski Pole
    ('Ski Pole', '120', 'cm', 18, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski Pole')),
    ('Ski Pole', '125', 'cm', 16, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski Pole')),
    ('Ski Pole', '130', 'cm', 14, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski Pole')),
    ('Ski Pole', '115', 'cm', 20, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski Pole')),
    ('Ski Pole', '110', 'cm', 22, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski Pole')),
    ('Ski Pole', '135', 'cm', 12, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski Pole')),
    ('Ski Pole', '140', 'cm', 10, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Ski Pole')),

    -- Boots
    ('Boots', '42', 'EU', 10, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Boots')),
    ('Boots', '44', 'EU', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Boots')),
    ('Boots', '40', 'EU', 12, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Boots')),
    ('Boots', '38', 'EU', 6, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Boots')),
    ('Boots', '43', 'EU', 15, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Boots')),
    ('Boots', '41', 'EU', 9, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Boots')),
    ('Boots', '45', 'EU', 11, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Boots')),
    ('Boots', '39', 'EU', 7, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Boots')),
    ('Boots', '46', 'EU', 13, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Boots')),
    ('Boots', '37', 'EU', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Boots')),

    -- Clothing
    ('Clothing', 'XXS', 'N/A', 20, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Clothing')),
    ('Clothing', 'XXL', 'N/A', 22, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Clothing')),
    ('Clothing', 'XS', 'N/A', 16, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Clothing')),
    ('Clothing', 'M', 'N/A', 15, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Clothing')),
    ('Clothing', 'XL', 'N/A', 19, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Clothing')),
    ('Clothing', 'S', 'N/A', 21, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Clothing')),
    ('Clothing', 'L', 'N/A', 14, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Clothing')),

    -- Toboggan
    ('Toboggan', 'Red', 'N/A', 10, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Toboggan')),
    ('Toboggan', 'Blue', 'N/A', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Toboggan')),
    ('Toboggan', 'Green', 'N/A', 12, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Toboggan')),
    ('Toboggan', 'Yellow', 'N/A', 6, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Toboggan')),
    ('Toboggan', 'Orange', 'N/A', 15, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Toboggan')),
    ('Toboggan', 'Pink', 'N/A', 9, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Toboggan')),
    ('Toboggan', 'Purple', 'N/A', 11, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Toboggan')),
    ('Toboggan', 'Black', 'N/A', 7, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Toboggan')),
    ('Toboggan', 'White', 'N/A', 13, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Toboggan')),
    ('Toboggan', 'Gray', 'N/A', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'Toboggan'));
