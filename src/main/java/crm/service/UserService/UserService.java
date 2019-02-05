package crm.service.UserService;

import crm.pojo.User.User;

public interface UserService {
    public User findByUsername(String Username);
}
