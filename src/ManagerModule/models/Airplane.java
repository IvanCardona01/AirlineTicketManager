package ManagerModule.models;

public class Airplane {
    private String identifier;
    private AirplaneStand[] airplaneStands;

    public Airplane(String identifier) {
        this.identifier = identifier;
        generateStands();
    }

    private void generateStands() {

    }

    public String getIdentifier() {
        return identifier;
    }

    public void ocupeStand(AirplaneStand stand) {

    }

    public void enableStand(AirplaneStand stand) {

    }
}
