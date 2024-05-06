package Repository;

import Controller.HibernateUtil;
import Model.SignUp;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class SignUpDao {
    public SignUp recordUser(SignUp signupObject) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.save(signupObject);
            session.beginTransaction().commit();
            session.close();
            return signupObject;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public SignUp editUser(SignUp signupObject) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.update(signupObject);
            session.beginTransaction().commit();
            session.close();
            return signupObject;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public SignUp deleteUser(SignUp signupObject) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.delete(signupObject);
            session.beginTransaction().commit();
            session.close();
            return signupObject;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public SignUp searchUser(SignUp signupObject) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            SignUp sign = session.get(SignUp.class, signupObject.getStud_id());
            session.close();
            return sign;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public List<SignUp> display(){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<SignUp> theSign = session.createQuery("select signUp from SignUp signUp").list();
            session.close();
            return theSign;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public SignUp loginUser(String password, String email, String role ){
     try {
         Session ss = HibernateUtil.getSessionFactory().openSession();
         String hql = "FROM SignUp WHERE email = :email  AND password = :password AND  type_of_user = :role";
         Query query = ss.createQuery(hql);
         query.setParameter("email", email );
         query.setParameter("password", password);
         query.setParameter("role", role);
         SignUp user = (SignUp) ((org.hibernate.query.Query<?>) query).uniqueResult();
         ss.close();
         return user;
     }catch (Exception ex){
         ex.printStackTrace();
     }
        return null;
    }
}
