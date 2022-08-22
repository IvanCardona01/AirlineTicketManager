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

    public void ocupeStand(int index, int file, int col, AirplaneStand airplaneStand, int stand) {
        if ( file >= stands.length || index > stand) {

        } else if (col >= stands[0].length ){
            ocupeStand(index, file + 1, 0, airplaneStand, stand);
        } else if (index == stand) {
            stands[file][col] = airplaneStand;
        } else {
            ocupeStand(index + 1, file, col + 1, airplaneStand, stand);
        }
    }

    public void enableStand(int index, int file, int col, int stand) {
        if ( file >= stands.length ) {
            
        } else if (col >= stands[0].length ){
            enableStand(index, file + 1, 0, stand);
        } else if (index == stand) {
            stands[file][col] = null;
        } else {
            enableStand(index + 1, file, col + 1, stand);
        }
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
            return validateStand(stand,file+1, 0,isAvailable,cont);
        }else{
            if(stand == cont && stands[file][col] == null ){
                isAvailable = true;
            }
            return  validateStand(stand,file, col + 1, isAvailable,cont+1);
        }
    }

    public String getAvailablesStands(int file, int col, String availablesStands, int stand) {
        if (file >= stands.length) {
            return availablesStands;
        } else if (col >= stands[0].length) {
            return getAvailablesStands(file + 1, 0, availablesStands, stand);
        } else {
            if (stands[file][col] == null) {
                availablesStands += stand + "-  Disponible\n";
            } else {
                availablesStands += stand + "-  Ocupado\n";
            }
            return  getAvailablesStands(file, col + 1, availablesStands, stand + 1);
        }
    }
}
