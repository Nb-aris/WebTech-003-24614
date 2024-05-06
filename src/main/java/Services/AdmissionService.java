package Services;

import Model.Admission;

import java.util.List;

public interface AdmissionService {
    Admission addStudent(Admission admission);
    Admission updateStudent(Admission admission);
    Admission deleteStudent(Admission admission);
    Admission findStudent(Admission admission);
    Admission updateapprover(int admissionId, String newStatus);
    List<Admission> allStudent();
}
