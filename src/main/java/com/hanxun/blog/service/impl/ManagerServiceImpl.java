package com.hanxun.blog.service.impl;

import com.hanxun.blog.entity.InviteCodeDO;
import com.hanxun.blog.mapper.InviteCodeMapper;
import com.hanxun.blog.mapper.MottoMapper;
import com.hanxun.blog.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author han xun
 * Date 2021/8/3 22:16
 * Description:
 */
@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private MottoMapper mottoMapper;
    @Autowired
    private InviteCodeMapper inviteCodeMapper;

    @Override
    public String generateInviteCode() {
        String code = UUID.randomUUID().toString();
        InviteCodeDO inviteCodeDO = new InviteCodeDO();
        inviteCodeDO.setCode(code);
        inviteCodeDO.setGmtCreate(new Date());
        log.info("generate invite code:{}", code);
        inviteCodeMapper.insert(inviteCodeDO);
        return code;
    }

    @Override
    public Boolean addMotto() {
        // todo 完善逻辑
        return null;
    }
}
