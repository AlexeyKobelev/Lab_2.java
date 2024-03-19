import Entity.*;
import repository.*;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        InterfaceRepo<Clients> clientsRepo = new ClientRepo();
        InterfaceRepo<Stylist> stylistsRepo = new StylistRepo();

        List<Clients> clients = clientsRepo.getAll();
        List<Stylist> stylists = stylistsRepo.getAll();

        DB.printClients(clients);
        DB.printStylists(stylists);
        DB.printClientsStylists(clients);
    }
}