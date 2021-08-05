package com.hanxun.blog.controller;

import com.hanxun.blog.config.AdminConfig;
import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.exception.CustomException;
import com.hanxun.blog.service.ManagerService;
import com.hanxun.blog.utils.BackMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
     * 管理员登陆接口
     * @return
     */
    public BackMessage login() {
        return null;
    }

    /**
     * 设置邀请码接口
     * @return
     */
    @GetMapping("/getInviteCode")
    public BackMessage getInviteCode() {
        Long userId = super.getUserId();
        if (!userId.equals(adminConfig.getId())){
            throw new CustomException(BackEnum.INSUFFICIENT_PERMISSIONS);
        }
        // todo 鉴权
        String inviteCode = managerService.generateInviteCode();
        return new BackMessage<String>(BackEnum.REQUEST_SUCCESS, inviteCode);
    }

    /**
     * 新增motto接口
     * @return
     */
    @PostMapping("/setMotto")
    public BackMessage setMotto(@RequestBody String content) {
        Long userId = super.getUserId();
        if (!userId.equals(adminConfig.getId())){
            throw new CustomException(BackEnum.INSUFFICIENT_PERMISSIONS);
        }
        // todo 鉴权
        if (StringUtils.isEmpty(content)) {
            throw new CustomException(BackEnum.PARAM_ERROR);
        }
        managerService.addMotto(content);
        return BackMessage.success();
    }

    /**
     * 查看motto列表接口
     * @return
     */
    public BackMessage getMottoList() {
        return null;
    }

    /**
     * 删除motto接口
     * @return
     */
    public BackMessage deleteMotto() {
        return null;
    }
}
