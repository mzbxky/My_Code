package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.entity.TbUserExample;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    TbUserMapper tbUserMapper;
    @Override
    public ResultVo login(String username, String password) {
        ResultVo resultVO;

        TbUserExample example = new TbUserExample();

        TbUserExample.Criteria criteria = example.createCriteria();

        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<TbUser> users = tbUserMapper.selectByExample(example);

        if (users.size() > 0) {
            // 成功
            resultVO = new ResultVo(200, "登录成功", true, users.get(0));
        } else {
            // 失败
            resultVO = new ResultVo(0, "登录失败，用户名或密码错误", false, null);
        }

        return resultVO;
    }

    @Override
    public int update(TbUser user) {
        int affectedRows = tbUserMapper.updateByPrimaryKeySelective(user);
        return affectedRows;
    }

    @Override
    public int checkNick(String nick) {
        TbUserExample example = new TbUserExample();

        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(nick);
        List<TbUser> user = tbUserMapper.selectByExample(example);
        if (user.size() > 0) {
            return 0;
        }
        return 1;
    }


}
