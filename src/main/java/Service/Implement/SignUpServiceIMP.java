package Service.Implement;

import Model.SignUp;
import Repository.SignUpDao;
import Services.SignUpService;
import org.hibernate.SessionFactory;

import java.util.List;

public class SignUpServiceIMP implements SignUpService {
    public SignUpServiceIMP(SessionFactory sessionFactory) {
    }

    SignUpDao dao = new SignUpDao();
    @Override
    public SignUp addUser(SignUp users) {

        return dao.recordUser(users);
    }

    @Override
    public SignUp updateUser(SignUp users) {
        return dao.editUser(users);
    }

    @Override
    public SignUp removeUser(SignUp users) {
        return dao.deleteUser(users);
    }

    @Override
    public SignUp findUser(SignUp users) {
        return dao.searchUser(users);
    }


    @Override
    public List<SignUp> allUser() {
        return dao.display();
    }

    @Override
    public SignUp login(String email, String password, String role) {
        return dao.loginUser(password,email,role);
    }


}
