package com.hanxun.blog.controller;

import com.hanxun.blog.config.AdminConfig;
import com.hanxun.blog.controller.req.AddArticleReq;
import com.hanxun.blog.controller.req.SetMottoReq;
import com.hanxun.blog.dto.MottoQuery;
import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.exception.CustomException;
import com.hanxun.blog.page.PageResult;
import com.hanxun.blog.service.ManagerService;
import com.hanxun.blog.utils.BackMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author han xun
 * Date 2021/7/25 23:12
 * Description: 管理员控制界面
 */
@RestController
@RequestMapping("admin")
public class ManagerController extends BaseController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private AdminConfig adminConfig;

    /**
     * 设置邀请码接口
     * @return
     */
    @GetMapping("/getInviteCode")
    public BackMessage getInviteCode() {
        super.isAdmin();
        String inviteCode = managerService.generateInviteCode();
        return new BackMessage<String>(BackEnum.REQUEST_SUCCESS, inviteCode);
    }

    /**
     * 新增motto接口
     * @return
     */
    @PostMapping("/setMotto")
    public BackMessage setMotto(@RequestBody SetMottoReq mottoReq) {
        super.isAdmin();
        if (StringUtils.isEmpty(mottoReq.getContent())) {
            throw new CustomException(BackEnum.PARAM_ERROR);
        }
        managerService.addMotto(mottoReq.getContent());
        return BackMessage.success();
    }

    /**
     * 新增文章
     * @param addArticleReq
     * @return
     */
    @PostMapping("/addArticle")
    public BackMessage addArticle(@RequestBody AddArticleReq addArticleReq) {
        super.isAdmin();
        managerService.addArticle(addArticleReq);
        return BackMessage.success();
    }

    /**
     * 查看motto列表接口
     * @return
     */
    @PostMapping("/getMottoList")
    public BackMessage getMottoList(@RequestBody MottoQuery mottoQuery) {
        PageResult pageResult = managerService.selectMotto(mottoQuery);
        return new BackMessage(BackEnum.REQUEST_SUCCESS, pageResult);
    }

    /**
     * 删除motto接口
     * @return
     */
    @GetMapping("/deleteMotto")
    public BackMessage deleteMotto(@RequestParam("id") Long id) {
        if (managerService.deleteMotto(id)) {
            return BackMessage.success();
        }
        return BackMessage.error();
    }
}
