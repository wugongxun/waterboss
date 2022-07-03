package com.wgx.test;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wgx.waterboss.bean.Owners;
import com.wgx.waterboss.dao.OwnersDao;
import com.wgx.waterboss.mapper.OwnersMapper;
import com.wgx.waterboss.serivce.OwnersService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;


/**
 * author:wgx
 * version:1.0
 */
public class Test extends ServiceImpl {
    @Resource
    private OwnersService ownersService;

    @org.junit.Test
    public void testAdd() {
        OwnersDao ownersDao = new OwnersDao();
        Owners owners = new Owners(null, "吴功勋", 6L, "219-204", "30423", new Date(), 4L);
        System.out.println(ownersDao.addByUseProcedure(owners));
    }

    @org.junit.Test
    public void testMybatisPlus() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession实例，能直接执行已经映射的sql语句
        //sql的唯一标识
        //执行sql需要的参数
        SqlSession openSession = sqlSessionFactory.openSession();
        OwnersMapper mapper = openSession.getMapper(OwnersMapper.class);
//        Owners owners = mapper.selectById(11L);
//        System.out.println(owners);
        Owners owners = new Owners(null, "吴功勋", 6L, "219-204", "30423", new Date(), 4L);
        mapper.insert(owners);
        openSession.commit();
        openSession.close();
    }

    @org.junit.Test
    public void testServiceImpl() {
        Owners owners = new Owners(null, "吴功勋", 6L, "219-204", "30423", new Date(), 4L);
        ownersService.save(owners);
    }
}
