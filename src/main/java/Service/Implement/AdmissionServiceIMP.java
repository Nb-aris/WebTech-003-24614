package Service.Implement;

import Model.Admission;
import Repository.AdmissionADao;
import Services.AdmissionService;
import org.hibernate.SessionFactory;

import java.util.List;

public class AdmissionServiceIMP implements AdmissionService {
    public AdmissionServiceIMP(SessionFactory sessionFactory) {

    }

    AdmissionADao dao = new AdmissionADao();
    @Override
    public Admission addStudent(Admission admission) {
        return dao.recordUser(admission);
    }

    @Override
    public Admission updateStudent(Admission admission) {
        return dao.editUser(admission);
    }

    @Override
    public Admission deleteStudent(Admission admission) {
        return dao.deleteUser(admission);
    }

    @Override
    public Admission findStudent(Admission admission) {
        return dao.searchUser(admission);
    }

    @Override
    public Admission updateapprover(int admissionId, String newStatus) {
        dao.updateapprove_deny(admissionId,newStatus);
        return null;
    }

    @Override
    public List<Admission> allStudent() {
        return dao.display();
    }
}
