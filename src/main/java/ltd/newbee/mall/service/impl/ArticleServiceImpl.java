package ltd.newbee.mall.service.impl;

import ltd.newbee.mall.dao.ArticleMapper;
import ltd.newbee.mall.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: newbee-mall
 * @description:
 * @author: chenshutian
 * @create: 2021-03-16 11:09
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleMapper articleMapper;

    /**
     * 构造器方式注入
     * @param articleMapper
     */
    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }



}
