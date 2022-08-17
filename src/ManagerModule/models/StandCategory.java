package ManagerModule.models;

public enum StandCategory {
    VIP(75000),
    Gerencial(50000),
    Ejecutiva(25000);

    private final int standPrice;

    StandCategory(int price) {
        standPrice = price;
    }
}
