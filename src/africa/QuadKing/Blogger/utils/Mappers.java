package africa.QuadKing.Blogger.utils;

import africa.QuadKing.Blogger.data.models.User;
import africa.QuadKing.Blogger.dtos.requests.RegisterRequest;

public class Mappers {
    public static User map(RegisterRequest registerRequest, User user){
        //you can use this above (User user) or remove and simply use the one beneath
        //        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setPassword(registerRequest.getPassword());
        user.setLastName(registerRequest.getLastName());
        user.setFirstName(registerRequest.setFirstName());
        return user;
    }

//    public static User map(RegisterRequest registerRequest, User user){
//        user.setUserName(registerRequest.getUserName());
//        user.setPassword(registerRequest.getPassword());
//        user.setLastName(registerRequest.getLastName());
//        user.setFirstName(registerRequest.setFirstName());
//    }
}
