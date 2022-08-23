import ManagerModule.controller.AirlineManager;

/**
 * Sistema de Gestion De Tickets
 * @author Ivan Alexander Cardona Rodriguez
 * @author Santiago Gamez Guerra
 * @version  23/08/20222 1.0
 */

public class Main {
    /**
     * Inicio del sistema
     * @param args
     */
    public static void main(String[] args) {
        AirlineManager airlineTicketManager = new AirlineManager();
        airlineTicketManager.initManager();

    }
}
