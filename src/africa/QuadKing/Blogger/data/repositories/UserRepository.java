package africa.QuadKing.Blogger.data.repositories;

import africa.QuadKing.Blogger.data.models.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    User findById(int id);
    long count();
    List<User> findAll();
    void delete(User user);
    void delete(int id);
    void deleteAll();

    User findByUserName(String userName);
}
