package org.patsimas.school.model.dao;

import org.patsimas.school.model.entity.User;
import org.patsimas.school.model.entity.UserRole;

public interface UserRoleDAO {

    public void saveRoleUser(UserRole roleUser);
    
    public UserRole getRoleUserById(Long uid, User user) throws Exception;
    
    public void changeRole(UserRole roleUser);
}
