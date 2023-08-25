package services;

import africa.QuadKing.Blogger.data.models.User;
import africa.QuadKing.Blogger.dtos.requests.RegisterRequest;
import africa.QuadKing.Blogger.services.UserService;
import africa.QuadKing.Blogger.services.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class UserServiceImplTest {
    private UserService userService;
    private RegisterRequest request;

    @BeforeEach
    public void setUp(){

        userService = new UserServiceImpl();
        request.setPassword("1234");
        request.lastName("Elisha");
        request.firstName("Allwell");
        request.userName("QuadKing");

    }

    @Test
    public void testSaveNewUser_IdIsNotZero(){
        User savedUser = userService.register("Allwell", "Elisha", "QuadKing", "1234");
        assertTrue(savedUser.getId() != 0);
    }

    @Test
    public void test_duplicateUserNameThrowsException(){
        userService.register("Allwell", "Elisha", "QuadKing", "1234");
        assertThrows(IllegalArgumentException.class, ()  -> userService.register("Allwell","Elisha", "QuadKing", "1234"));
    }

    @Test
    public void test_findUserById(){
        userService.register("Allwell", "Elisha", "QuadKing", "1234");
        assertEquals("Allwell",userService.findUser(1).getFirstName());
    }
}
