package africa.QuadKing.Blogger.services;

import africa.QuadKing.Blogger.data.models.User;
import africa.QuadKing.Blogger.data.repositories.UserRepository;
import africa.QuadKing.Blogger.data.repositories.UserRepositoryImpl;
import africa.QuadKing.Blogger.dtos.requests.RegisterRequest;
import africa.QuadKing.Blogger.dtos.responses.FindUserResponse;
import africa.QuadKing.Blogger.utils.Mappers;

import java.time.format.DateTimeFormatter;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepositoryImpl();


    @Override
    public User register(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getUserName()))
            throw new IllegalArgumentException(registerRequest.getUserName() + "already exists");
        User user = new User();
        Mappers.map(registerRequest, user);
        return userRepository.save(user) ;
    }

//    @Override
//    public User register(RegisterRequest registerRequest) {
//        if (userExist(registerRequest.getUserName()))
//            throw new IllegalArgumentException(registerRequest.getUserName() + "already exists");
//        return userRepository.save(Mapper.map(registerRequest));
//    }


    private boolean userExist(String userName){
        User foundUser  = userRepository.findByUserName(userName);
        if (foundUser != null) return true;
        return false;
    }

//    @Override
//    public User findUser(int id) {
//        return userRepository.findById(id);
//    }

    @Override
    public User findUser(int id) {
        User foundUser = userRepository.findById(id);
        FindUserResponse response = new FindUserResponse();
        response.setFullName(foundUser.getFirstName() + " "+ foundUser.getLastName());
        response.setUserId(foundUser.getId(id));
        response.setUserName(foundUser.getUserName());
        DateTimeFormatter formatter;
        return userRepository.findById(id);
    }

}