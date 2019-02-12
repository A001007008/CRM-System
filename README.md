# SSM项目实战：Crm信息管理系统

## 1. 系统的功能和简介

* 一个数据管理系统，基于SSM框架进行开发,利用Maven构建和打包。

  + 有登录模块。
  + 对数据的管理功能(CRUD)。
  + 分页的显示。

* > 本项目源于TyCoding开源项目 [SSM](https://github.com/TyCoding/ssm)。
  >
  > 项目中的所有实现我都通过自己学习后进行编写。

* #### 改进地方：

  + 改进了分页的bug。
  + 添加了拦截器进行权限认证。
  + 添加了数据响应页面倒计时回主页。
  + 添加了显示用户名。

* #### 适用人群：

  + 用于熟悉SSM框架的开发人员。
  + 学习数据的分页。

## 2. 系统的环境搭建

* 本系统通过Maven来进行环境的搭建，Maven的依赖，我已经打包好了，在根目录的tree.txt目录下，也可以通过pom文件来进行查看。

* 文件的目录如下：

   <img src="/img/src.png"  >  

* main项目下是项目的主要实现代码，resources用于存放配置的xml。

* test目录是用于存放测试的Java代码，本例中主要用于测试mapper和service编写是否正确。

* mysql文件已经放在目录下。

* 本系统的搭建环境：

  * Java：1.8.0.191
  * mysql:8.0.13
  * Maven：3.6.0
  * Spring:4.2.4
  * Mybatis:3.2.8

## 3.注意事项

* 注意mysql连接驱动和mysql的版本，当初我在搭建的时候因为我的Mysql和原作者的Mysql版本不一致，一直无法连接到数据库，抛了异常解决了很久。

* 注意mysql8.0之后jdbc的驱动修改了,在url中需要配置时区：

  * ```mysql
    jdbc.driver=com.mysql.cj.jdbc.Driverjdbc.
    url=jdbc:mysql://localhost:3306/mycrm?
    characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false
    jdbc.user=root
    jdbc.password=root
    ```

* 要注意通过Maven搭建项目的时候要注意包冲突。



## 4.项目展示

* 首页：username为admin，密码为admin。
  * <img src="/img/首页.png" />
* 主页:
  * <img src="/img/主页.png" />
* 添加：
  * <img src="/img/添加.png" />

## 5.jsp页面说明

* 前端页面：
  *  <img src="/img/前端页面.png" />
  * index为主页，info用于跳转信息页面，list为页面信息显示，save为添加用户的页面，page为导航栏。
  * 

## 6.分页功能

* 在以前的时候，我们通常是怎么分页的呢？

  * 首先通过mysql的limit来进行分页

    ```mysql
    select * from A limit 1,10;
    ```

  * limit表示从第几条到第几条。

  * 同时我们需要在前端传入，第几页，一页显示多少条。

  * 然后我们通过计算:

  * ```Java
    通过前端传入的条数，我们需要先对数据库所有符合条件的数据进行查找，除以条数，得出总页数。
    然后我们通过传入的（页数-1）*条数得出数据是从第几条开始到第几条结束。
    再通过一个对象封装起来，传入前端。
    ```

* 使用了PageHelper之后，我们就不需要再如此繁琐的进行分页了。

  * ```Java
    使用PageHelper.startPage(第几页,每页显示多少条);就可以在这段代码之后的下一个查询的数据就会自动分页。
    ```

  * 同样PageHeler里面有一个PageInfo的类可以对数据进行封装，封装的内容和程序中用于封装的page对象内容大体相同。

  * 使用PageHelpe我们只需要以下几步：

    * 使用PageHelper.startPage(第几页,每页显示多少条);

    * 将查询的数据放入PageInfo里面。

    *  ```
      PageInfo info =new PageInfo(查询的数据)
      ```

    * 返回PageInfo或对需要的数据再封装。(程序里面没有用到PageInfo，使用的是自己封装的Page对象，有兴趣的可以试一试)

