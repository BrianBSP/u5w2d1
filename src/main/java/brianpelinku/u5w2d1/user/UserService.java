package brianpelinku.u5w2d1.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> usersList = new ArrayList<>();

    // 1. Get: /users --> findAll
    public List<User> getUsersList(){
        return usersList.stream().map(user -> user).toList();
    }




}
