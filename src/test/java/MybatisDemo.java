import ltd.newbee.mall.dao.NewBeeMallGoodsMapper;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: chenshutian
 * @create: 2020-11-30 16:18
 **/
public class MybatisDemo extends BaseTest {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     *
       Mybatis 一级缓存命中场景
     *
     *  运行时 参数相关
    *   mybatis一级缓存 命中条件
        1：sql和参数必须相同
        2：必须是相同的statementId
        3.sqlSession必须一样（会话级的缓存）
        4.相同的RowBounds 相同  相同的分页条件

       操作与配置相关
     1. 未手动清空缓存（提交，回滚）
     2.未配置fushCache = true
     3.未执行update
     4缓存作用域不是statement

    * */


    @Test
    public void test2() {
        NewBeeMallGoodsMapper mapper = sqlSessionTemplate.getMapper(NewBeeMallGoodsMapper.class);
        List<Long> list = Arrays.asList(10897L);
        List<NewBeeMallGoods> newBeeMallGoods = mapper.selectByPrimaryKeys(list);

        RowBounds rowBounds = new RowBounds(0, 10);//分页
        RowBounds aDefault = RowBounds.DEFAULT;
        sqlSessionTemplate.selectList("select * from goods", rowBounds);
    }
}