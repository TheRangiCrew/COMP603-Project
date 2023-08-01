package ResortProject;


public class RentalEquipment {
    
    public class Skis {
        
        private int skiLength; // ski size (in cm)
        private boolean available; // availability 
        private String rideType; // all mountain / freeride / park / On piste
        private boolean skiPoles; // If poles were included
        private int skiId; // ID number for skis
        
        public Skis(int skiLength, boolean available, String rideType, boolean skiPoles, int skiId) {
            this.skiLength = skiLength;
            this.available = available;
            this.rideType = rideType;
            this.skiPoles = skiPoles;
            this.skiId = skiId;
        }

        // Returns skiId
        public int getSkiId() {
            return skiId;
        }

        // Returns the skiLength
        public int getSkiLength() {
            return skiLength;
        }

        // Returns the available
        public boolean isAvailable() {
            return available;
        }

        // Returns the rideType
        public String getRideType() {
            return rideType;
        }
        
        // Returns the skiPoles
        public boolean isSkiPoles() {
            return skiPoles;
        }
    }
    
    public class Snowboard {
        
        private int boardLength; // Board size (in cm)
        private boolean available; // Availability
        private String rideType; // All mountain / freeride / park / on piste
        private int boardId; // ID number for snowboard

        public Snowboard(int boardLength, boolean available, String rideType, int boardId) {
            this.boardLength = boardLength;
            this.available = available;
            this.rideType = rideType;
            this.boardId = boardId;
        }

        // Returns boardId
        public int getBoardId() {
            return boardId;
        }

        // Returns boardsLength
        public int getBoardLength() {
            return boardLength;
        }

        // Returns abailable
        public boolean isAvailable() {
            return available;
        }

        // returns rideType
        public String getRideType() {
            return rideType;
        }
    }
    
    public class Boots {
        
        private boolean available; // Availability
        private String bootType; // Ski boots or board boots
        private int size; // Shoe size
        private int bootId; // ID number for boots

        public Boots(String bootType, int size, int bootId, boolean available) {
            this.bootType = bootType;
            this.size = size;
            this.bootId = bootId;
            this.available = available;
        }

        // Returns available
        public boolean isAvailable() {
            return available;
        }

        // Returns bootId
        public int getBootId() {
            return bootId;
        }

        // Returns bootType
        public String getBootType() {
            return bootType;
        }

        // Returns size
        public int getSize() {
            return size;
        }
    }
    
    public class tabogan {
        
        private boolean available; // Availability
        private String size; // Adults or childs size tabogan
        private int taboganId; // ID number for tabogan

        public tabogan(String size, int taboganId, boolean available) {
            this.size = size;
            this.taboganId = taboganId;
            this.available = available;
        }

        // Returns available
        public boolean isAvailable() {
            return available;
        }

        // Returns the size
        public String getSize() {
            return size;
        }

        // Returns taboganId
        public int getTaboganId() {
            return taboganId;
        }
    }
    
    public class SnowJacket {
        
        private int jacketId; // ID number for jacket
        private String size; // size of jacket
        private String gender; // male or female style/fit

        public SnowJacket(int jacketId, String size, String gender) {
            this.jacketId = jacketId;
            this.size = size;
            this.gender = gender;
        }

        // Returns jacketId
        public int getJacketId() {
            return jacketId;
        }

        // Returns size
        public String getSize() {
            return size;
        }

        // Returns gender
        public String getGender() {
            return gender;
        }
    }
    
    public class SnowPants {
        
        private int pantsId; // ID number for pants
        private String size; // size of pants
        private String gender; // male or female style/fit

        public SnowPants(int pantsId, String size, String gender) {
            this.pantsId = pantsId;
            this.size = size;
            this.gender = gender;
        }

        // Returns pantsId
        public int getPantsId() {
            return pantsId;
        }

        // Returns size
        public String getSize() {
            return size;
        }

        // Returns gender
        public String getGender() {
            return gender;
        }
    }
    
    public class ChildSnowSuit {
        
        private int suitId; // Child snow suit ID number
        private String size; // size of snow suit
        private String gender; // male or female style/fit

        public ChildSnowSuit(int suitId, String size, String gender) {
            this.suitId = suitId;
            this.size = size;
            this.gender = gender;
        }

        // Returns suitId
        public int getSuitId() {
            return suitId;
        }

        // Returns Size
        public String getSize() {
            return size;
        }

        // Returns gender
        public String getGender() {
            return gender;
        }
    }
}
