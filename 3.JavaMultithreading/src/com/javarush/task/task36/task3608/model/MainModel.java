package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData ();
    private UserService userService = new UserServiceImpl ();


    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
//        List users = new ArrayList ( getAllUsers () );
//        modelData.setUsers ( users );
//        modelData.setDisplayDeletedUserList ( false );
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }

    @Override
    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers ( users );
        modelData.setDisplayDeletedUserList ( true );
    }

    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser ( id );
        loadUsers ();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
//        User user = userService.getUsersById(id);
//        user.setName ( name );
//        user.setLevel ( level );
        userService.createOrUpdateUser ( name, id, level );
        loadUsers ();
    }

    private List<User> getAllUsers() {
//        userService.getUsersBetweenLevels ( 1, 100 );
//        List<User> result = userService.filterOnlyActiveUsers ( modelData.getUsers () );
//        return result;
        List<User> userList100 = userService.getUsersBetweenLevels(1, 100);
        return userService.filterOnlyActiveUsers(userList100);
    }


}
