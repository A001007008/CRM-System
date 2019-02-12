package crm.service.CustomerService;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import crm.mapper.Customer.CustomerMapper;
import crm.pojo.Customer.Customer;
import crm.pojo.PageBean.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public Customer findByID(Integer id) {
        Customer customer = customerMapper.findByID(id);
        return customer;
    }

    @Override
    public void deleteByID(Integer id) {
        customerMapper.deleteByID(id);
    }

    public  void  insertCustomer(Customer customer){
        customerMapper.CustomerAdd(customer);
    }

    public PageBean findByPage(Customer customer,int pageCode,int pageSize){
        PageHelper.startPage(pageCode,pageSize);
        Page<Customer> page = customerMapper.findByPage(customer);
        return new PageBean(pageCode,(int)Math.ceil(((double) page.getTotal()/(double)pageSize)),(int)page.getTotal(),pageSize, page.getResult());
    }

}
