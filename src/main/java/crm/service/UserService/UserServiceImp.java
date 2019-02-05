package crm.service.UserService;

import com.github.pagehelper.PageHelper;
import crm.mapper.UserMapper.UserMapper;
import crm.pojo.Customer.Customer;
import crm.pojo.PageBean.PageBean;
import crm.pojo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByUsername(String Username){
        User User = userMapper.login(Username);
        return User;
    }
}
