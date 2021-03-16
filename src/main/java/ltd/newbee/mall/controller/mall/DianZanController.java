package ltd.newbee.mall.controller.mall;

import ltd.newbee.mall.service.ThumbLogService;
import ltd.newbee.mall.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: newbee-mall
 * @description:
 * @author: chenshutian
 * @create: 2021-03-16 11:08
 **/
@RestController
public class DianZanController {
    private ThumbLogService thumbLogService;

    @Autowired
    public DianZanController(ThumbLogService thumbLogService) {
        this.thumbLogService = thumbLogService;
    }

    /**
     * 用户给文章点赞
     *
     * @param aid
     * @param uid
     * @return
     */
    @PostMapping("/dianzan")
    public Result dianzan(Integer aid, Integer uid) {
        boolean flag = thumbLogService.add(aid, uid);
        return flag? new Result(200,"点赞成功"):new Result(500,"你已经点赞过了");
    }
}
