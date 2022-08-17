package ManagerModule.controller;

import javax.swing.*;

public class TicketManager {
    private AirlineManager airlineManager;

    public TicketManager(AirlineManager airlineManager) {
        this.airlineManager = airlineManager;
    }

    public void openTicketManager() {
        String principalMenu = "******************************\n"
                              +"*  1. Generar nuevo ticket    \n"
                              +"*  2. Ver ticket asignados   \n"
                              +"*  3. Eliminar ticket         \n"
                              +"*  4. Atrás                   \n"
                              +"******************************\n";
        String selectedOption = JOptionPane.showInputDialog(null,principalMenu,"",1);
    }
}
