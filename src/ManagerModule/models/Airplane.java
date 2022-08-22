package ManagerModule.models;

public class Airplane {
    private String identifier;
    private AirplaneStand[][] stands;

    public Airplane(String identifier) {
        this.identifier = identifier;
        int standsTotalRows = 4;
        int standsTotalCol = 2;
        stands = new AirplaneStand[standsTotalRows][standsTotalCol];
    }

    public String getIdentifier() {
        return identifier;
    }

    public void ocupeStand(AirplaneStand stand) {

    }

    public void enableStand(AirplaneStand stand) {

    }

    public AirplaneStand[][] getAirplaneStands() {
        return stands;
    }

    public boolean hasAvailableStands(int file, int col, Boolean isAvailable) {
        if (file >= stands.length ) {
            return  isAvailable;
        } else if (col >= stands[0].length) {
            return  hasAvailableStands(file + 1, 0, isAvailable);
        } else {
            if (stands[file][col] == null) {
                isAvailable = true;
            }
            return  hasAvailableStands(file, col + 1, isAvailable);
        }
    }
}
