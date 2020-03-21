## 1.项目结构

> 注意建包的时候的层级
> ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120648.png)

## 2.数据库属性文件配置

> 注意几个属性的作用
> ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120719.png)

## 3.Spring主配置文件

- 开启注解扫描
- 读入外部数据库属性文件
- 配置数据源
- 配置JdbcTemplate
  ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120732.png)

## 4.sql脚本

> 尝试用脚本来建表
> ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120747.png)

## 5.实体类

> 尤其要注意，加了@Builder注解后，默认的无参构造器会失效，务必加上全参和无参构造器注解
> @AllArgsConstructor和@NoArgsContrutor
> ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120858.png)

## 6.ForumDao接口

> 声明基本的增删改查方法
> ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317122911.png)

## 7.ForumDao接口实现类

> 注意批量操作和查询的写法
> ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317123024.png)

## 8.单元测试

> 自己注意数据的一致性和断言的使用,建议测试顺序如下

- 单个新增
- 批量新增
- 查询所有
- 查询单个
- 修改单个（先查到再修改）
- 删除单个
  ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317124250.png)



# 小结



## 1   注解

@Repository 将Dao类声明为bean类   @autowrite 才可以调用 

## 2 xml文件执行步骤

xml扫描类 配置 

```
  //开启注解  才能扫描
  <context:annotation-config/>
    <context:component-scan base-package="com.wl.SpringStudy.ioc"/>
    //通过 读取resouce 下db.properties
    <contest:property-placeholder location="db.properties"/>
    配置数据元
     <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
          init-method="init">
        <property name="driverClassName" value="${jdbc.driverClassName}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
        <property name="initialSize" value="8"/>
    </bean>
    
    
    配置jdbc模板 
    
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>
```

## 3  jdbc模板

jdbcTemplate

增删改都用 update

查询用    queery 

## 4   断言

assert判断函数 

assertEquals(expected,actual)  和 assertNotEquals(expected,actual);
比较实际值与预期值是否一致。如果一致，程序继续运行，否则抛出异常，会打印报错信息。常用断言方法，便于调试。

2.assertTrue(message,condition) 和 assertFalse(message,condition)
如果条件的真假与预期相同，程序继续运行，否则抛出异常，不会打印报错信息。

3.assertNull(message,object) 和 assertNotNull(message,object)
判断一个对象是否为空，如果结果与预期相同，程序继续运行，否则抛出异常。

4**assertSame(**expected,actual**) 和 assertNotSame(**expected,actual**)**

判断预期的值和实际的值是否为同一个参数(即判断是否为相同的引用)，如果结果与预期相同，程序继续运行，否则抛出异常。

## 5

模糊查询列子

```
 public List<TPost> selectByKey(String key) {
        String sql = "select * from t_post where " +
                "title like CONCAT('%', ?, '%') " +
                "or content like CONCAT('%', ?, '%') " +
                "or thumbnail like CONCAT('%', ?, '%') ";
        Object[] args = {key, key, key};

        return jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(TPost.class));
    }
```

批量查询 

```
 public int[] bathInsert(List<TPost> posts) {
        final List<TPost> postList = posts;
        String sql = "INSERT INTO t_post VALUES (NULL,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setLong(1, postList.get(i).getForumId());
                preparedStatement.setString(2, postList.get(i).getTitle());
                preparedStatement.setString(3, postList.get(i).getContent());
                preparedStatement.setString(4, postList.get(i).getThumbnail());
                preparedStatement.setTimestamp(5, postList.get(i).getCreateTime());
            }

            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }
```

3.19:
# 无xml化总结

1  首先 @configration配置类  装配 datasource 和  jdbc template   

通过 set方法 注入 对应值  这样 配置类写好 

```
@Configuration //标明配置类
@ComponentScan("com.wl.SpringStudy.ioc")
public class JDBCConfig {


    @Bean  //@Bean是一个方法级别上的注解，主要用在@Configuration注解的类里，也可以用在@Component注解的类里。添加的bean的id为方法名
    public DruidDataSource druidDataSource(){
    //创建对象
DruidDataSource druidDataSource =new DruidDataSource();
//
SET传值
druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
druidDataSource.setUrl("jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
druidDataSource.setUsername("root");
druidDataSource.setPassword("root");
druidDataSource.setInitialSize(8);

        return  druidDataSource;
    }

```
3.19
1  首先 @configration配置类  装配 datasource 和  jdbc template   

通过 set方法 注入 对应值  这样 配置类写好 

@Configuration //标明配置类
@ComponentScan("com.wl.SpringStudy.ioc")
public class JDBCConfig {


    @Bean  //@Bean是一个方法级别上的注解，主要用在@Configuration注解的类里，也可以用在@Component注解的类里。添加的bean的id为方法名
    public DruidDataSource druidDataSource(){
    //创建对象
DruidDataSource druidDataSource =new DruidDataSource();
//
SET传值
druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
druidDataSource.setUrl("jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
druidDataSource.setUsername("root");
druidDataSource.setPassword("root");
druidDataSource.setInitialSize(8);

        return  druidDataSource;
    }
2  扫包  @componetScan 扫包注解 确保 注解都能扫到  

dao层、service层、controller层
可以用不同的注解
@Repository
@Service

@Controller

@Component可以统一代替

3： 测试类引用时 @ContextConfigration(class={xxxx.class }) 

