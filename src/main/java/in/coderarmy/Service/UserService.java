package in.coderarmy.Service;

import in.coderarmy.model.User;


import java.util.*;

public class UserService {
    //instade of the DB now we are using the in memory Hashmap:
    Map<Integer, User>userDB;
    public UserService()
    {
        userDB = new HashMap<>();
    }

    public User createUser(User userRequest)
    {
        userDB.put(userRequest.getId() , userRequest);
        return userRequest;
    }

    public List<User> getAllUsers()
    {
        return (List<User>)userDB.values();//it will return Collection so we casted it
    }

    public User getUserById(Integer id)
    {
        return userDB.getOrDefault(id,null);
    }

    public User updateUser(User user) {

        if (!userDB.containsKey(user.getId())) {
            return null;
        }

        userDB.put(user.getId(), user);

        return user;
    }

    public boolean deleteUserById(Integer id) {

        if (!userDB.containsKey(id)) {
            return false;
        }

        userDB.remove(id);

        return true;
    }




}
