package crm.controller.CustomerController;

import crm.pojo.Customer.Customer;
import crm.pojo.PageBean.PageBean;
import crm.service.CustomerService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private   CustomerService customerServiceImpl;

    /*
    *
    * 保存页面
    * */
    @RequestMapping("/toSavePage")
    public String Customer(){
        return "page/save";
    }

    /*
     *
     * 查询全部数据，返回到主页
     * */
    @RequestMapping("/toListPage")
    public String toListPage(Model model){
        return "redirect:/customer/findByPage";
    }

    /*
     *
     * 插入客户数据
     * */
    @RequestMapping("/save")
    public  String CustomerAdd(Customer customer, Model model){
        customerServiceImpl.insertCustomer(customer);
        model.addAttribute("message","添加成功");
        return "page/info";
    }

    /*
     *
     * 分页查询
     * */
    @RequestMapping("/findByPage")
    public  String findByPage(Customer customer,
                              @RequestParam(value = "pageCode", required = false, defaultValue = "1") int pageCode,
                              @RequestParam(value="pageSize" , required=false , defaultValue="5") int pageSize,
                               Model model){
        model.addAttribute("Customer",customer);
        model.addAttribute("page",customerServiceImpl.findByPage(customer,pageCode,pageSize));
        return "page/list";
    }

    /*
     *
     * 删除用户数据
     * */
    @RequestMapping("/delete")
    public String deleteByID(int id,Model model){
         if (id<0){
             model.addAttribute("message","信息有误");
         }
         else {
             customerServiceImpl.deleteByID(id);
             model.addAttribute("message","删除成功");
         }
        return "page/info";
    }
    /*
     *
     * 修改用户数据
     * */
    @ResponseBody
    @RequestMapping("/findById")
    public Customer updateByID(@RequestBody Customer customer){
        Customer cm = customerServiceImpl.findByID(customer.getId());
        return cm;
    }

    @RequestMapping("/update")
    public String update(Customer customer,Model model){
        customerServiceImpl.updateCustomer(customer);
        model.addAttribute("message","修改成功");
        return "page/info";
    }
}
