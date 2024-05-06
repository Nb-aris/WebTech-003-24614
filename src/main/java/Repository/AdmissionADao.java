package Repository;

import Controller.HibernateUtil;
import Model.Admission;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdmissionADao {
    public Admission recordUser(Admission admissioObject) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.save(admissioObject);
            session.beginTransaction().commit();
            session.close();
            return admissioObject;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Admission editUser(Admission admissioObject) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.update(admissioObject);
            session.beginTransaction().commit();
            session.close();
            return admissioObject;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Admission deleteUser(Admission admissioObject) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.delete(admissioObject);
            session.beginTransaction().commit();
            session.close();
            return admissioObject;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Admission searchUser(Admission admissioObject) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Admission sign = session.get(Admission.class, admissioObject.getStud_id());
            session.close();
            return sign;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Admission> display() {
        String st="Pending";
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            List<Admission> Admission_data=session.createQuery("select ad from Admission ad where status= :Status")
                    .setParameter("Status",st)
                    .list();
            session.beginTransaction().commit();
            session.close();
            return Admission_data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public Void updateapprove_deny(int admissionId, String newStatus) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction= session.beginTransaction();
            Admission admission = session.get(Admission.class, admissionId);
            if (admission != null) {
                admission.setStatus(newStatus);
                session.update(admission);
            }
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
}


}
