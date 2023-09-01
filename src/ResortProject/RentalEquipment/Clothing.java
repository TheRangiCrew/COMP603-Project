package ResortProject.RentalEquipment;

public class Clothing extends Equipment {

    private Gender gender; // male or female style/fit
    private ClothingType clothingType;

    public Clothing(String name, String size, int available, String gender) {
        super(name, size, available, "clothing");
        this.gender = Gender.valueOf(gender.toUpperCase());
        this.clothingType = ClothingType.valueOf(name.toUpperCase());
    }

    public ClothingType getClothingType() {
        return this.clothingType;
    }

    /**
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }
}
