package ltd.newbee.mall.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import ltd.newbee.mall.dao.ArticleMapper;
import ltd.newbee.mall.dao.MallUserMapper;
import ltd.newbee.mall.dao.ThumbLogMapper;
import ltd.newbee.mall.entity.Article;
import ltd.newbee.mall.entity.MallUser;
import ltd.newbee.mall.entity.ThumbLog;
import ltd.newbee.mall.service.ThumbLogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @program: newbee-mall
 * @description:
 * @author: chenshutian
 * @create: 2021-03-16 11:10
 **/
public class ThumbLogServiceImpl implements ThumbLogService {
    private final ThumbLogMapper thumbLogMapper;
    private final ArticleMapper articleMapper;
    private final MallUserMapper mallUserMapper;

    @Autowired
    public ThumbLogServiceImpl(ThumbLogMapper thumbLogMapper, ArticleMapper articleMapper, MallUserMapper mallUserMapper) {
        this.thumbLogMapper = thumbLogMapper;
        this.articleMapper = articleMapper;
        this.mallUserMapper = mallUserMapper;
    }

    /**
     * 点赞
     *
     * @param aid 文章id
     * @param uid 用户id
     * @return
     */
    @Override
    public boolean add(Integer aid, Integer uid) {
        List<ThumbLog> list = thumbLogMapper.selectList(Wrappers.<ThumbLog>lambdaQuery().eq(ThumbLog::getAid, aid).eq(ThumbLog::getUid, uid));
        if (list.size() > 0 && Objects.nonNull(list)) return false;
        return thumbLogMapper.insert(ThumbLog.builder().aid(aid).uid(uid).build()) > 0;
    }

    /**
     * 谁赞过我的
     *
     * @param aid 文章id
     * @return
     */
    @Override
    public List<MallUser> getUserList(Integer aid) {
        List<ThumbLog> list = thumbLogMapper.selectList(Wrappers.<ThumbLog>lambdaQuery().eq(ThumbLog::getAid, aid));
        List<Integer> uidList = list.stream().map(ThumbLog::getUid).collect(Collectors.toList());
        return mallUserMapper.selectList(Wrappers.lambdaQuery(MallUser.class).in(MallUser::getUserId, uidList));
    }

    /**
     * 取消点赞
     *
     * @param aid
     * @param uid
     * @return
     */
    @Override
    public boolean del(Integer aid, Integer uid) {
        return thumbLogMapper.delete(Wrappers.lambdaQuery(ThumbLog.class)
                .eq(ThumbLog::getAid, aid)
                .eq(ThumbLog::getUid, uid)) > 0;
    }

    /**
     * 查看用户点过赞的文章
     *
     * @param uid
     * @return
     */
    @Override
    public List<Article> getArticleList(Integer uid) {
        List<ThumbLog> list = thumbLogMapper.selectList(Wrappers.<ThumbLog>lambdaQuery().eq(ThumbLog::getUid, uid));
        List<Integer> aidList = list.stream().map(ThumbLog::getAid).collect(Collectors.toList());
        return articleMapper.selectList(Wrappers.<Article>lambdaQuery().in(Article::getArticleId, aidList));
    }
}
