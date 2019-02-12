import crm.pojo.Customer.Customer;
import crm.pojo.PageBean.PageBean;
import crm.service.CustomerService.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/spring/bean.xml")
public class test {

    @Autowired
    private CustomerService customerService;

    private Customer customer;
    @Autowired
    public void setCustomer() {
        Customer customer=new Customer();
        customer.setId(9);
        customer.setName("小曾");
        customer.setTelephone("123456789");
        customer.setAddress("asdd");
        customer.setRemark("asdd");
        this.customer=customer;
    }

    /*
    * 测试分页
    * */
    @Test
    public void testpage(){

        PageBean page = customerService.findByPage(customer, 1, 5);
        List<Customer> list = page.getBeanList();
        System.out.println(page.getTotalPage());
        System.out.println(page.getTotalCount());
        System.out.println(page.getPageCode());
        System.out.println(page.getPageSize());
        for (Customer o : list) {
            System.out.println(o);
        }
    }

    /*
    * 测试删除
    * */

    @Test
    public void  deleteByID(){
        customerService.deleteByID(23);
    }

    /*
    * 测试寻找全部的方法
    * */
    @Test
    public  void findByID(){
        Customer uc = customerService.findByID(23);
        System.out.println(uc);
    }

    /*
    * 测试更新
    * */
    @Test
    public void updateCustomer(){
        customerService.updateCustomer(customer);
    }
}
