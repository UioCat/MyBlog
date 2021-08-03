package com.hanxun.blog.service.impl;

import com.hanxun.blog.entity.MottoDO;
import com.hanxun.blog.mapper.MottoMapper;
import com.hanxun.blog.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author han xun
 * Date 2021/8/3 22:16
 * Description:
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private MottoMapper mottoMapper;

    @Override
    public String generateInviteCode() {

        return null;
    }

    @Override
    public Boolean addMotto() {
        return null;
    }
}
