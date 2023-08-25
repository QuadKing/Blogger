package africa.QuadKing.Blogger.controllers;

import africa.QuadKing.Blogger.dtos.requests.RegisterRequest;
import africa.QuadKing.Blogger.services.UserService;
import africa.QuadKing.Blogger.services.UserServiceImpl;

@RestController
public class UserController {

    private UserService userService = new UserServiceImpl();

    @PostMapping("/register")
    public Object register(RegisterRequest request) {
        try {
            return userService.register(request);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }

    @GetMapping("/{id}")
    public Object findUserById(@PathVariable int id) {
        return userService.findUser(id);
    }
}
