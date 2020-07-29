mysql属性
  driverClassName=com.mysql.jdbc.Driver
  url=jdbc:mysql://localhost:3306/demo
  username=root
  password=root
create database demo;
use demo
create table demo(id int primary key auto_increment,name varchar(50),intro varchar(1024)) DEFAULT CHARSET=utf8;


环境：java7，mysql
工具: sts(spring的eclipse,集成了maven等)
本实例主要讲了springboot使用连接池用Mybatis操作mysql：
1：addOne 单条增加
2: addList 多条增加
3: remove 删除操作
4: removeIn 删除的in操作
5: modify 修改操作
6: queryOne 查找单条，不存在返回null
7: queryList 多条查询，不存在返回[]空数组
8: queryPage 分页查询
9：transaction 事务测试