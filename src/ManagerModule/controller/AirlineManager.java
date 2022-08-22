package ManagerModule.controller;
import ManagerModule.Exceptions.CustomExceptions;
import ManagerModule.models.Airplane;
import ManagerModule.models.AirplaneStand;
import ManagerModule.models.StandCategory;
import ManagerModule.models.TicketForm;
import utilities.UtilitiesModule;

import javax.swing.*;
import java.util.ArrayList;

public class AirlineManager {
    private final UtilitiesModule utilitiesModule = new UtilitiesModule();
    private final String airlineName = "";
    private Airplane airplane;
    private ArrayList<TicketForm> airlineTickets = new ArrayList<TicketForm>();
    private TicketManager ticketManger;

    public AirlineManager() {
        airplane = new Airplane("3904");
        this.ticketManger = new TicketManager(this);
    }

    public void initManager() {
        Boolean exit = false;
        do {
            String principalMenu = "\n  1. Gestionar Tickets    \n\n"
                                  +"  2. Salir                \n\n";
            String selectedOption = JOptionPane.showInputDialog(null,principalMenu,airlineName,1);
            switch (selectedOption) {
                case "1":
                    try {
                        ticketManger.openTicketManager();
                    } catch (CustomExceptions error) {
                        utilitiesModule.printInformativeText(error.getMessage());
                    }
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

    public Airplane getAirplane() {
        return airplane;
    }

    public ArrayList<TicketForm> getAirlineTickets() {
        return airlineTickets;
    }

    public void addTicket(TicketForm form) {





        airlineTickets.add(form);
        int stand = form.getAirplaneStand().getStandNumber();
        airplane.ocupeStand(0, 0, 0, form.getAirplaneStand(), stand);
    }

    public boolean validateStand ( int stand){
        return  airplane.validateStand(stand,0,0,false,0);
    }

    public void cancelTicket(int index) {
        int stand = airlineTickets.get(index).getAirplaneStand().getStandNumber();
        TicketForm selectedTicket = airlineTickets.get(index);
        airlineTickets.remove(selectedTicket);
        airplane.enableStand(0, 0, 0, stand);
    }

    public boolean airplaneHasAvailableStands() {
        return airplane.hasAvailableStands(0, 0, false);
    }
}
