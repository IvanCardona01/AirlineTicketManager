package ManagerModule.controller;
import ManagerModule.model.Airplane;
import utilities.UtilitiesModule;

import javax.swing.*;

public class AirlineManager {
    private final UtilitiesModule utilitiesModule = new UtilitiesModule();
    private final String airlineName = "";
    private Airplane[] airplanes;
    private TicketManager ticketManger;

    public AirlineManager(){
        airplanes = new Airplane[3];
        airplanes[0] = new Airplane("3904");
        airplanes[1] = new Airplane("4176");
        airplanes[2] = new Airplane("1090");
        this.ticketManger = new TicketManager(this);
    }

    public void initManager() {
        Boolean exit = false;
        do {
            String principalMenu = "***************************\n"
                                  +"*  1. Gestionar Tickets    \n"
                                  +"*  2. Salir                \n"
                                  +"***************************\n";
            String selectedOption = JOptionPane.showInputDialog(null,principalMenu,airlineName,1);
            switch (selectedOption) {
                case "1":
                    ticketManger.openTicketManager();
                    break;
                case "2":
                    String question = "¿Deseas salir de la aplicación?";
                    String title = airlineName;
                    exit = utilitiesModule.showConfirmationMessage(question, title);
                    break;
                default:
                    String informativeMessage = "Por favor ingrese una opción valida";
                    utilitiesModule.printInformativeText(informativeMessage);
                    break;
            }
        } while (!exit);
    }

    public Airplane[] getAirplanes() {
        return airplanes;
    }
}
