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

    public void setStands(AirplaneStand[][] stands) {
        this.stands = stands;
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

    public boolean validateStand(int stand,int file, int col, boolean isAvailable,int cont){

        if (file >= stands.length) {
            return isAvailable;
        }else if (col >= stands[0].length){
            return validateStand(stand,file+1, col,isAvailable,cont);
        }else{
            if(stand == cont && stands[file][col] == null ){
                isAvailable = true;
            }
            return  validateStand(stand,file, col + 1, isAvailable,cont+1);
        }


    }
}
