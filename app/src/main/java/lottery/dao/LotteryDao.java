package lottery.dao;

import lottery.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LotteryDao {
    private static LotteryDao dao = null;
    private EntityManagerFactory emf;

    private LotteryDao() {
        this.emf = Persistence.createEntityManagerFactory("lottery");;
    }

    public static LotteryDao getInstans(){
        if(dao == null){
            dao = new LotteryDao();
        }
        return dao;
    }

    private EntityManager currentManager() {
        return emf.createEntityManager();
    }
    public void addParticipant(Participant p) {
        EntityManager em = currentManager();
        em.getTransaction().begin();
        em.persist(p);
        em.flush();
        em.getTransaction().commit();
    }

    public List<Participant> getAllParticipant() {
        EntityManager em = currentManager();
        em.getTransaction().begin();
        List<Participant> p = em.createNamedQuery("getAllParticipant").getResultList();
        em.flush();
        em.getTransaction().commit();
        return p;
    }

    public Participant getWinner(int n) {
        EntityManager em = currentManager();
        em.getTransaction().begin();
        Participant p = (Participant) em.createNamedQuery("getAllParticipant")
                .setFirstResult(n)
                .setMaxResults(1)
                .getSingleResult();
        em.createNamedQuery("deleteAllParticipant").executeUpdate();
        em.flush();
        em.getTransaction().commit();
        return p;
    }

    public long ParticipantCount() {
        EntityManager em = currentManager();
        em.getTransaction().begin();
        long count = (long) em.createNamedQuery("ParticipantCount").getSingleResult();
        em.flush();
        em.getTransaction().commit();
        return count;
    }

    public void addWinners(Winners p) {
        EntityManager em = currentManager();
        em.getTransaction().begin();
        em.persist(p);
        em.flush();
        em.getTransaction().commit();
    }

    public List<Winners> getAllWinners() {
        EntityManager em = currentManager();
        em.getTransaction().begin();
        List<Winners> p = em.createNamedQuery("getAllWinners").getResultList();
        em.flush();
        em.getTransaction().commit();
        return p;
    }

}
