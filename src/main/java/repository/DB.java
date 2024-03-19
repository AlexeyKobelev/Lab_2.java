package repository;
import Entity.*;

import java.util.List;

public class DB {
    public static void printStylist(Stylist stylist) {
        System.out.println(stylist.getId() + " " + stylist.getName() + " " + stylist.getSurname() +" " + stylist.isDeleted());
    }
    public static void printClient(Clients client) {
        System.out.println(client.getId() + " " + client.getName() + " " + client.getSurname() + " " + client.getIdStylists().getName() + " " + client.isDeleted());
    }
    public static void printClientStylist(Clients client) {
        System.out.print(client.getId() + " " + client.getName() + " " + client.getSurname() + " " + client.isDeleted() + " ");
        printStylist(client.getIdStylists());
    }
    public static void printStylists(List<Stylist> stylists) {
        for (Stylist stylist : stylists) {
            printStylist(stylist);
        }
    }
    public static void printClients(List<Clients> clients) {
        for (Clients client : clients) {
            printClient(client);
        }
    }
    public static void printClientsStylists(List<Clients> clients) {
        for (Clients client : clients) {
            printClientStylist(client);
        }
    }
}
