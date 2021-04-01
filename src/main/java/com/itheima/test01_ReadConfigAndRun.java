package com.itheima;

import com.itheima.dao.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Author: twc
 * @Date 2021/3/30 20:30
 **/
public class test01_ReadConfigAndRun {
    /**
     * @Description
     * @Date 2021/3/30 20:31
     **/
    @Test
    public void testParseXml()  throws Exception{

        // 1. 读取核心配置文件  --- 有没有加载数据源？
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 2. 创建sqlsession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 3. 创建sqlsession
        SqlSession session = sqlSessionFactory.openSession();

        // 4.完成查询   --- 有没有完成sql的查找  参数映射？ 结果封装？
        // 方式1：
        User user = session.selectOne("com.itheima.dao.UserMapper.findUserById", 101);

        System.out.println("user1:" + user);

        // 方式2：
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();

        User user2 = mapper.findUserById(101);
        System.out.println("user2:" + user2);

        // 5.释放资源
        session.close();
        inputStream.close();
    }

}
