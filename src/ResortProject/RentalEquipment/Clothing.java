package ResortProject.RentalEquipment;

/**
 * Clothing extended from Equipment
 */
public class Clothing extends Equipment {

    private Gender gender; // male or female style/fit
    private ClothingType clothingType;

    /**
     * 
     * @param name      clothing type
     * @param size      clothing size
     * @param available available quantity
     * @param gender    gender
     * @see Gender
     * @see ClothingType
     */
    public Clothing(String name, String size, int available, String gender) {
        super(name, size, available, "clothing");
        this.gender = Gender.valueOf(gender.toUpperCase());
        this.clothingType = ClothingType.valueOf(name.toUpperCase());
    }

    /**
     * 
     * @return ClothingType
     * @see ClothingType
     */
    public ClothingType getClothingType() {
        return this.clothingType;
    }

    /**
     * @return the gender
     * @see Gender
     */
    public Gender getGender() {
        return gender;
    }
}
