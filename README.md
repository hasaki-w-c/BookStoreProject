# hasaki书城

## 项目说明

本项目是本人经过学习Java Web，根据学习资料最终完善出来的项目，在此提供出来，供大家参考。

（项目运行截图在web/static/img里）

项目遵循java EE三层架构实现，代码严格遵循MVC分层思想，可部署到服务器上。

## 配置环境

- JDK版本：JDK1.8
- MySQL：8.0.21
- 开发环境：IDEA2020.2
- 服务器：tomcat 8.0.50

## 项目涉及到的技术及jar包

### 技术说明

前端页面方面都是由 JSP 来完成，公共页面使用静态包含实现。注册，登陆使用jQuery的选择器结合正则表达式来进行过滤筛选，确定用户名和密码是否可用。使用 AJAX 验证用户名是否可用。使用反射获取地址action参数，来确定其对应的业务方法，再通过反射进行调用。使用工具类对数据进行封装抽取注入到JavaBean。使用EL表达式回显表单。使用数据库连接池druid进行数据库连接，再通过dbutils来对其进行管理，编写Java EE三层架构，实现分页与分页条。使用Session实现购物车功能。使用 Filter 过滤器拦截/pages/manager/所有内容，实现权限检查使用 Filter 和 ThreadLocal 组合管理事务。使用 Filter 过滤器统一给所有的 Service 方法都加上 try-catch。来进行事务的管理。将所有异常都统一交给Tomcat，让 Tomcat 展示错误信息页面。

### 所用到的jar包

- commons-beanutils-1.8.0.jar
- commons-dbutils-1.3.jar
- commons-logging-1.1.1.jar
- druid-1.1.22.jar
- gson-2.2.4.jar
- hamcrest-core-1.3.jar
- javax.annotation.jar
- javax.ejb.jar
- javax.jms.jar
- javax.persistence.jar
- javax.resource.jar
- javax.servlet.jar
- javax.servlet.jsp.jar
- javax.servlet.jsp.jstl.jar
- javax.transaction.jar
- junit-4.12.jar
- kaptcha-2.3.2.jar
- mysql-connector-java-8.0.21.jar
- taglibs-standard-impl-1.2.1.jar
- taglibs-standard-spec-1.2.1.jar

## 功能说明

有些功能是管理员才可以使用的。

### 用户功能模块

- 用户注册
- 用户登陆
- 用户注销登陆
- 注册用户名可用性校验
- 注册密码可用性校验

### 商品功能模块

- 分页查询
- 价格区间查询
- 商品新增（管理员）
- 商品修改（管理员）
- 商品删除（管理员）

### 购物车功能模块

- 清空购物车
- 删除单条商品项
- 修改单个商品数量
- 结账生成订单

### 订单模块

- 查看订单详情（管理员，用户）
- 修改订单状态（管理员（发货），用户（签收））

## 包结构说明

- com.hasaki_w_c.dao : dao 接口包
- com.hasaki_w_c.dao.impl ：dao 接口实现类
- com.hasaki_w_c.filter ：web 过滤器
- com.hasaki_w_c.pojo ：JavaBean 类
- com.hasaki_w_c.service ：Service 接口包
- com.hasaki_w_c.service.impl ：Service 接口实现类
- com.hasaki_w_c.test ：测试包
- com.hasaki_w_c.utils ：工具类包JS
- com.hasaki_w_c.web ：web  层

## 项目学习

通过本次项目学习，熟悉掌握了 JavaEE 的三层架构，MVC 分层思想。前端方面：html, CSS ,JS 的基本语法，以及 jQuery框架的简单使用，熟悉了 JavaWeb 的三大组件中的 servlet 程序 和 filter 过滤器以及 Listener 监听器，了解了 JSP 页面的常用内置对象和四大域对象，以及静态包含,熟悉了 EL 表达式中隐含对象的使用。熟悉了 JSTL 标签库中核心库的基本使用。后端方面：熟悉了数据库连接池的使用，以及 JDBC 工具类的编写，了解了分页的实现过程。了解了数据的封装和JavaBean 的注入。了解了 ThreadLocal 的使用以及作用。了解了 json 在 Java 中的使用以及 Ajax 请求。
