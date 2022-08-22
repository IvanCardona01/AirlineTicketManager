package ManagerModule.controller;

import ManagerModule.models.AirplaneStand;
import ManagerModule.models.StandCategory;
import ManagerModule.Exceptions.CustomExceptions;
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

    public void openTicketManager() throws CustomExceptions {
        Boolean back = false;
        do {
            String menu = "\n  1. Generar nuevo ticket    \n\n"
                                  +"  2. Ver ticket asignados   \n\n"
                                  +"  3. Eliminar ticket         \n\n"
                                  +"  4. Atrás                   \n\n";
            String selectedOption = JOptionPane.showInputDialog(null,menu,"",1);
            switch (selectedOption) {
                case "1":
                    if (airlineManager.airplaneHasAvailableStands()) {
                        TicketForm form = openFormTicketGenerator();
                        airlineManager.addTicket(form);
                    } else {
                        throw new CustomExceptions("Lo sentimos no hay puesto disponibles");
                    }
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
        form.setCustomerName(JOptionPane.showInputDialog("Customer Name"));
        form.setIdentificationNumber(JOptionPane.showInputDialog("Indentification Number"));
        form.setDestineCity(JOptionPane.showInputDialog("Destino"));
        form.setAirplaneStand(AirplaneStandDataGenerator(form.getCustomerName()));

        return form;
    }

    public AirplaneStand AirplaneStandDataGenerator(String username){
        AirplaneStand airplaneStand = new AirplaneStand();
        String [] opcionStandCategory = {StandCategory.VIP.name(),StandCategory.Gerencial.name(), StandCategory.Ejecutiva.name()};
        airplaneStand.setStandUserName(username);
        String optionCategory = (String) JOptionPane.showInputDialog(null,"Seleccione Categoria","Categoria",JOptionPane.DEFAULT_OPTION,null,opcionStandCategory,opcionStandCategory[0]);
        String availablesStands = airlineManager.getAirplane().getAvailablesStands(0, 0, "", 1);
        int stand = Integer.parseInt(JOptionPane.showInputDialog(availablesStands + "\nIngrese puesto: ")) - 1;
        airplaneStand.setStandNumber(stand);
        System.out.println(airlineManager.validateStand(stand));
        switch (optionCategory) {
            case "VIP":
                airplaneStand.setCategory(StandCategory.VIP);
                break;

            case "Gerencial":
                airplaneStand.setCategory(StandCategory.Gerencial);
                break;

            case "Ejecutiva":
                airplaneStand.setCategory(StandCategory.Ejecutiva);
                break;
        }

        return  airplaneStand;

    }

    private void showTicketList(ArrayList<TicketForm> airlineTickets) {
        Boolean back = false;
        do {
            Boolean isEditable = false;
            String ticketsList = "\n*****************************************\n"
                                + "Puesto: \n"
                                + getTicketListToString(0,airlineManager.getAirlineTickets(), isEditable, "")
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
                                        + getTicketListToString(0,airlineManager.getAirlineTickets(), isEditable, "")
                                        + "\nIngrese el indice del ticket\n"
                                        + "que desea eliminar o ingrese\n"
                                        + "0 para ir atrás\n\n";
            String selectedOption = JOptionPane.showInputDialog(null,editableTicketsList,"",1);
            switch (selectedOption) {
                case "0":
                    back = true;
                    break;
                default:
                    try {
                        int index = Integer.parseInt(selectedOption);
                        Boolean isValidIndex = index > 0 && index <= airlineManager.getAirlineTickets().size();
                        if (isValidIndex) {
                            airlineManager.cancelTicket(index - 1);
                        } else {
                            utilitiesModule.printInformativeText("Por favor ingrese un indice disponible");
                        }
                    } catch (NumberFormatException exception) {
                        utilitiesModule.printInformativeText("Por favor ingrese un indice correcto");
                    }
                    break;
            }
        } while (!back);
    }

    private String getTicketListToString(int index, ArrayList<TicketForm> airlineTickets, Boolean isEditable, String ticketList) {
        if (index >= airlineTickets.size()){
            return ticketList;
        } else {
            String ticketDescription = airlineTickets.get(index).toString();
            ticketList += isEditable ? index + 1 + "-  " + ticketDescription : ticketDescription;
            return getTicketListToString(index + 1, airlineTickets, isEditable, ticketList);
        }
    }
}
