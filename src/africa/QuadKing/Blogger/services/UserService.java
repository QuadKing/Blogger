package africa.QuadKing.Blogger.services;

import africa.QuadKing.Blogger.data.models.User;
import africa.QuadKing.Blogger.dtos.requests.RegisterRequest;

public interface UserService {
    User register(RegisterRequest registerRequest);


    User findUser(int id);

    User register(String firstName, String lastName, String userName, String password);
}
