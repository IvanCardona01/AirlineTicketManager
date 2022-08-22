package ManagerModule.models;

public class TicketForm {
    private String customerName;
    private String identificationNumber;
    private AirplaneStand airplaneStand;
    private String destineCity;

    public TicketForm() { }

    @Override
    public String toString(){
        String standNumber = airplaneStand.getStandNumber() + "";
        return standNumber + "  " + customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public AirplaneStand getAirplaneStand() {
        return airplaneStand;
    }

    public void setAirplaneStand(AirplaneStand airplaneStand) {
        this.airplaneStand = airplaneStand;
    }

    public String getDestineCity() {
        return destineCity;
    }

    public void setDestineCity(String destineCity) {
        this.destineCity = destineCity;
    }
}
