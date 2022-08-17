package ManagerModule.models;

public class AirplaneStand {
    private String standUserName;
    private StandCategory category;
    private int standNumber;

    public AirplaneStand() { }

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
}
