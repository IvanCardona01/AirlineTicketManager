package ManagerModule.models;

public class AirplaneStand {
    private String standUserName;
    private StandCategory category;
    private int standNumber;
    private Boolean ocuped;

    public AirplaneStand(String standUserName, StandCategory category, int standNumber, Boolean ocuped) {
        this.standUserName = standUserName;
        this.category = category;
        this.standNumber = standNumber;
        this.ocuped = ocuped;
    }

    public StandCategory getCategory() {
        return category;
    }

    public void setCategory(StandCategory category) {
        this.category = category;
    }

    public int getStandNumber() {
        return standNumber;
    }

    public void setStandNumber(int standNumber) {
        this.standNumber = standNumber;
    }

    public String getStandUserName() {
        return standUserName;
    }

    public void setStandUserName(String standUserName) {
        this.standUserName = standUserName;
    }

    public Boolean isOcuped() {
        return ocuped;
    }

    public void setOcuped(Boolean ocuped) {
        ocuped = ocuped;
    }
}
