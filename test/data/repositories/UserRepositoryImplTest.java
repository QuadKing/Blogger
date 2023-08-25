package data.repositories;

import africa.QuadKing.Blogger.data.models.User;
import africa.QuadKing.Blogger.data.repositories.UserRepository;
import africa.QuadKing.Blogger.data.repositories.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;
    private User user;
    @BeforeEach
    public void setUp(){
        userRepository  = new UserRepositoryImpl();
        user = new User();
        user.setFirstName("Allwell");
        user.setUserName("Elisha");
        user.setUserName("QuadKing");
        user.setPassword("password");
    }


    @Test public void saveOneUser_countIsOneTest(){
        User user = new User();
        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }

    @Test public void saveOneUser_idOfUserIsOneTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getId());
    }
    @DisplayName("Update User Test")
    @Test public void saveTwoUsersWithSameId_countIsOneTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1, userRepository.count());
        savedUser.setLastName("Elisha");
        userRepository.save(savedUser);
        assertEquals(1, userRepository.count());
    }
    @Test public void saveOneUser_findUserByIdTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getId());
        User foundUser = userRepository.findById(1);
        assertEquals(foundUser, savedUser);
    }

    @Test public void saveOneUser_deleteOneUser_countIsZeroYTest(){
        userRepository.save(user);
        assertEquals(1, userRepository.count());
        userRepository.delete(1);
        assertEquals(0, userRepository.count());
    }
}