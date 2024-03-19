package repository;
import Entity.Stylist;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

public class StylistRepo implements InterfaceRepo<Stylist>{
    @PersistenceContext
    public EntityManager em = Persistence.createEntityManagerFactory("TST").createEntityManager();
    @Override
    @Transactional
    public void insert(Stylist stylist) throws SQLException {
        EntityTransaction transaction = em.getTransaction();
        try {
            em.persist(stylist);
            System.out.println("Мастер добавлен: " + stylist);
        } catch (Exception e) {
            System.err.println("Ошибка при добавлении мастера: " + stylist);
        }

    }

    @Override
    @Transactional
    public void delete(long id) throws SQLException {
        Stylist delStylist = em.find(Stylist.class, id);
        if (delStylist != null) {
            delStylist.setDeleted(false);
            em.merge(delStylist);
            System.out.println("Клиент с id " + id + " был удален.");}
        else{
            System.out.println("Клиент с id " + id + "не найден");
        }

    }

    @Override
    @Transactional
    public void update(Stylist stylist) throws SQLException {
        EntityTransaction transaction = em.getTransaction();
        try {
            Stylist updatedMaster = em.merge(stylist);
            System.out.println("Мастер обновлен: " + updatedMaster);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Ошибка при обновлении мастера: " + stylist);
        }
    }

    @Override
    public Stylist find(long id) throws SQLException {
        return em.find(Stylist.class, id);
    }

    @Override
    public List<Stylist> getAll() throws SQLException {
        return em.createQuery("SELECT m FROM Stylist m", Stylist.class).getResultList();
    }
}
