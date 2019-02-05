package crm.mapper.Customer;

import com.github.pagehelper.Page;
import crm.pojo.Customer.Customer;

import java.util.List;

public interface CustomerMapper {

    public  void updateCustomer(Customer customer);
    public  Customer findByID(Integer id);
    public void deleteByID(Integer id);
    public void CustomerAdd(Customer customer);
    public Page<Customer> findByPage(Customer customer);
}
