package crm.service.CustomerService;

import crm.pojo.Customer.Customer;
import crm.pojo.PageBean.PageBean;
import java.util.List;

public interface CustomerService {

    public  void updateCustomer(Customer customer);
    public  Customer findByID(Integer id);
    public void deleteByID(Integer id);
    public  void  insertCustomer(Customer customer);
    public PageBean findByPage(Customer customer, int pageCode, int pageSize);
}
