package Services;
import Model.SignUp;
import java.util.List;

public interface SignUpService {
    SignUp addUser(SignUp users);
    SignUp updateUser(SignUp users);
    SignUp removeUser(SignUp users);
    SignUp findUser(SignUp users);


    List<SignUp> allUser ();
    SignUp login(String email, String password, String role);
}
