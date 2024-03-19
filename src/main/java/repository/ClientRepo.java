package repository;

import Entity.Clients;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

public class ClientRepo implements InterfaceRepo<Clients>{
    @PersistenceContext
    public EntityManager em = Persistence.createEntityManagerFactory("TST").createEntityManager();
    @Override
    public void insert(Clients client) throws SQLException {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(client);
            transaction.commit();
            System.out.println("Клиент добавлен: " + client);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Ошибка при добавлении клиента: " + client);
        }
    }

    @Override
    @Transactional
    public void delete(long id) throws SQLException {
        Clients delClients = em.find(Clients.class, id);
        if (delClients != null) {
            delClients.setDeleted(false);
            em.merge(delClients);
            System.out.println("Клиент с id " + id + " был удален.");}
        else{
            System.out.println("Клиент с id " + id + "не найден");
        }
    }

    @Override
    @Transactional
    public void update(Clients client) throws SQLException {
        EntityTransaction transaction = em.getTransaction();
        try {
            Clients updatedClient = em.merge(client);
            System.out.println("Клиент обновлен: " + updatedClient);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Ошибка при обновлении клиента: " + client);
        }
    }
    @Override
    public Clients find(long id) {
        return em.find(Clients.class, id);
    }

    @Override
    public List<Clients> getAll() throws SQLException {
        return em.createQuery("SELECT c FROM Clients c", Clients.class).getResultList();
    }
}