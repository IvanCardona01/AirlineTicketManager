package ManagerModule.controller;
import ManagerModule.models.Airplane;
import ManagerModule.models.TicketForm;
import utilities.UtilitiesModule;

import javax.swing.*;
import java.util.ArrayList;

public class AirlineManager {
    private final UtilitiesModule utilitiesModule = new UtilitiesModule();
    private final String airlineName = "";
    private Airplane airplane;
    private ArrayList<TicketForm> airlineTickets;
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

    public Airplane getAirplane() {
        return airplane;
    }

    public ArrayList<TicketForm> getAirlineTickets() {
        return airlineTickets;
    }

    public void addTicket(TicketForm form) {
        airlineTickets.add(form);
        airplane.ocupeStand(form.getAirplaneStand());
    }

    public void cancelTicket(TicketForm form) {
        airlineTickets.remove(form);
        airplane.enableStand(form.getAirplaneStand());
    }
}
