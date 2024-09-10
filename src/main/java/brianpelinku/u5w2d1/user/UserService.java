package brianpelinku.u5w2d1.user;

import brianpelinku.u5w2d1.exceptions.NotFoundException;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Service
public class UserService {
    private List<User> usersList = new ArrayList<>();

    // 1. Get: /users --> findAll
    public List<User> getAllUsers() {
        return this.usersList;
    }

    // 2. Get: /users/{userId} --> findById
    public User getUser(int userId) {
        User found = null;
        for (User user : this.usersList) {
            if (user.getId() == userId) found = user;
        }
        if (found == null) throw new NotFoundException(userId);
        return found;
    }

    // 3. Post: /users
    public User saveUser(User bodyUser) {
        Random random = new Random();
        bodyUser.setId(random.nextInt(1, 100));
        this.usersList.add(bodyUser);
        return bodyUser;
    }

    // 4. Put: /users/{userId}
    public User getUserByIdAndUpdate(int userId, User updateUser) {
        User found = null;
        for (User user : this.usersList) {
            if (user.getId() == userId) {
                found = user;
                found.setNome(updateUser.getNome());
                found.setCognome(updateUser.getCognome());
                found.setEmail(updateUser.getEmail());
            }
        }
        if (found == null) throw new NotFoundException(userId);
        return found;
    }

    // 5. Delete: /users/{userId}
    public void getByIdAndDelete(int userId) {
        User found = null;
        for (User user : this.usersList) {
            if (user.getId() == userId) found = user;
        }
        if (found == null) throw new NotFoundException(userId);
        this.usersList.remove(found);
    }

}
