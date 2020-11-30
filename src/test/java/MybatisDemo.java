import ltd.newbee.mall.dao.NewBeeMallGoodsMapper;
import ltd.newbee.mall.entity.NewBeeMallGoods;
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
    *  mybatis一级缓存 命中条件
        1：sql和参数必须相同
        2：必须是相同的statementId
        3.sqlSession必须一样（会话级的缓存）
    * */


    @Test
    public void test1() {
        NewBeeMallGoodsMapper mapper = sqlSessionTemplate.getMapper(NewBeeMallGoodsMapper.class);
        List<Long> list = Arrays.asList(10897L);
        List<NewBeeMallGoods> newBeeMallGoods = mapper.selectByPrimaryKeys(list);
    }
}