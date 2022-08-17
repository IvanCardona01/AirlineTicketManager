package ManagerModule.controller;

import ManagerModule.models.TicketForm;
import utilities.UtilitiesModule;

import javax.swing.*;
import java.util.ArrayList;

public class TicketManager {
    private final UtilitiesModule utilitiesModule = new UtilitiesModule();
    private AirlineManager airlineManager;

    public TicketManager(AirlineManager airlineManager) {
        this.airlineManager = airlineManager;
    }

    public void openTicketManager() {
        Boolean back = false;
        do {
            String menu = "\n  1. Generar nuevo ticket    \n\n"
                                  +"  2. Ver ticket asignados   \n\n"
                                  +"  3. Eliminar ticket         \n\n"
                                  +"  4. Atrás                   \n\n";
            String selectedOption = JOptionPane.showInputDialog(null,menu,"",1);
            switch (selectedOption) {
                case "1":
                    TicketForm form = openFormTicketGenerator();
                    airlineManager.addTicket(form);
                    break;
                case "2":
                    showTicketList(airlineManager.getAirlineTickets());
                    break;
                case "3":
                    showEditableTicketList(airlineManager.getAirlineTickets());
                    break;
                case "4":
                    back = true;
                    break;
                default:
                    String informativeMessage = "Por favor ingrese una opción valida";
                    utilitiesModule.printInformativeText(informativeMessage);
                    break;
            }
        } while (!back);

    }

    public TicketForm openFormTicketGenerator() {
        TicketForm form = new TicketForm();
        Boolean back = false;
        do {

        } while (!back);
        return form;
    }

    private void showTicketList(ArrayList<TicketForm> airlineTickets) {
        Boolean back = false;
        do {
            Boolean isEditable = false;
            String ticketsList = "\n*****************************************\n\n"
                               + getTicketListToString(airlineManager.getAirlineTickets(), isEditable)
                               + "\n0. Atrás                   \n\n";
            String selectedOption = JOptionPane.showInputDialog(null,ticketsList,"",1);
            switch (selectedOption) {
                case "0":
                    back = true;
                    break;
                default:
                    break;
            }
        } while (!back);
    }

    private void showEditableTicketList(ArrayList<TicketForm> airlineTickets) {
        Boolean back = false;
        do {
            Boolean isEditable = true;
            String editableTicketsList = "\n*****************************************\n\n"
                                        + getTicketListToString(airlineManager.getAirlineTickets(), isEditable)
                                        + "\nIngrese el indice del ticket\n"
                                        + "que desea eliminar o ingrese\n"
                                        + "0 para ir atrás\n\n";
            String selectedOption = JOptionPane.showInputDialog(null,editableTicketsList,"",1);
            switch (selectedOption) {
                case "0":
                    back = true;
                    break;
                default:
                    //Validate eleccion about stand removable
                    break;
            }
        } while (!back);
    }

    private String getTicketListToString(ArrayList<TicketForm> airlineTickets, Boolean isEditable) {
        String ticketList = "";

        return  ticketList;
    }
}
