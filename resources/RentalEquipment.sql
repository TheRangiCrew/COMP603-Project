INSERT INTO RentalEquipmentTypes (rentalEquipmentTypeName, rentalEquipmentPrice)
VALUES ('SNOWBOARD', 35), ('SKI', 35), ('SKIPOLE', 5), ('BOOTS', 15), ('CLOTHING', 30), ('TABOGGAN', 10);

INSERT INTO RentalEquipment (equipmentName, equipmentSize, equipmentSizeUnit, equipmentAvailability, equipmentType)
VALUES
    -- Snowboard
    ('Snowboard', '160', 'cm', 10, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SNOWBOARD')),
    ('Snowboard', '155', 'cm', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SNOWBOARD')),
    ('Snowboard', '158', 'cm', 12, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SNOWBOARD')),
    ('Snowboard', '162', 'cm', 6, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SNOWBOARD')),
    ('Snowboard', '150', 'cm', 15, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SNOWBOARD')),
    ('Snowboard', '163', 'cm', 9, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SNOWBOARD')),
    ('Snowboard', '157', 'cm', 11, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SNOWBOARD')),
    ('Snowboard', '159', 'cm', 7, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SNOWBOARD')),
    ('Snowboard', '154', 'cm', 13, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SNOWBOARD')),
    ('Snowboard', '161', 'cm', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SNOWBOARD')),

    -- Ski
    ('Ski', '170', 'cm', 10, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKI')),
    ('Ski', '165', 'cm', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKI')),
    ('Ski', '160', 'cm', 12, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKI')),
    ('Ski', '175', 'cm', 6, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKI')),
    ('Ski', '155', 'cm', 15, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKI')),
    ('Ski', '168', 'cm', 9, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKI')),
    ('Ski', '163', 'cm', 11, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKI')),
    ('Ski', '157', 'cm', 7, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKI')),
    ('Ski', '166', 'cm', 13, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKI')),
    ('Ski', '172', 'cm', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKI')),

    -- Ski Pole
    ('Ski Pole', '120', 'cm', 18, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKIPOLE')),
    ('Ski Pole', '125', 'cm', 16, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKIPOLE')),
    ('Ski Pole', '130', 'cm', 14, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKIPOLE')),
    ('Ski Pole', '115', 'cm', 20, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKIPOLE')),
    ('Ski Pole', '110', 'cm', 22, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKIPOLE')),
    ('Ski Pole', '135', 'cm', 12, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKIPOLE')),
    ('Ski Pole', '140', 'cm', 10, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'SKIPOLE')),

    -- Boots
    ('Boots', '42', 'EU', 10, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'BOOTS')),
    ('Boots', '44', 'EU', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'BOOTS')),
    ('Boots', '40', 'EU', 12, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'BOOTS')),
    ('Boots', '38', 'EU', 6, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'BOOTS')),
    ('Boots', '43', 'EU', 15, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'BOOTS')),
    ('Boots', '41', 'EU', 9, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'BOOTS')),
    ('Boots', '45', 'EU', 11, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'BOOTS')),
    ('Boots', '39', 'EU', 7, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'BOOTS')),
    ('Boots', '46', 'EU', 13, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'BOOTS')),
    ('Boots', '37', 'EU', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'BOOTS')),

    -- Clothing
    ('Clothing', 'XXS', 'N/A', 20, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'CLOTHING')),
    ('Clothing', 'XXL', 'N/A', 22, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'CLOTHING')),
    ('Clothing', 'XS', 'N/A', 16, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'CLOTHING')),
    ('Clothing', 'M', 'N/A', 15, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'CLOTHING')),
    ('Clothing', 'XL', 'N/A', 19, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'CLOTHING')),
    ('Clothing', 'S', 'N/A', 21, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'CLOTHING')),
    ('Clothing', 'L', 'N/A', 14, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'CLOTHING')),

    -- Toboggan
    ('Taboggan', 'Red', 'N/A', 10, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'TABOGGAN')),
    ('Taboggan', 'Blue', 'N/A', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'TABOGGAN')),
    ('Taboggan', 'Green', 'N/A', 12, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'TABOGGAN')),
    ('Taboggan', 'Yellow', 'N/A', 6, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'TABOGGAN')),
    ('Taboggan', 'Orange', 'N/A', 15, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'TABOGGAN')),
    ('Taboggan', 'Pink', 'N/A', 9, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'TABOGGAN')),
    ('Taboggan', 'Purple', 'N/A', 11, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'TABOGGAN')),
    ('Taboggan', 'Black', 'N/A', 7, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'TABOGGAN')),
    ('Taboggan', 'White', 'N/A', 13, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'TABOGGAN')),
    ('Taboggan', 'Gray', 'N/A', 8, (SELECT rentalEquipmentTypeID FROM RentalEquipmentTypes WHERE rentalEquipmentTypeName = 'TABOGGAN'));
