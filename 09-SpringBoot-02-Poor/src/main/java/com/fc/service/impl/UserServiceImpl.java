package com.fc.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.entity.UserExample;
import com.fc.service.UserService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
private UserMapper userMapper;
    @Override
    public ResultVo getList(Integer pageNo, Integer pageSize,String info ,String search,Long id) {
        List<User> users = null;
        ResultVo resultVo = new ResultVo();
        try {
            if (id == null) {
                PageHelper.startPage(pageNo, pageSize);

                UserExample userExample = new UserExample();

                UserExample.Criteria criteria = userExample.createCriteria();

                if (info.equals("name")) {
                    criteria.andNameLike("%" + search + "%");
                }

                if (info.equals("username")) {
                    criteria.andUsernameLike("%" + search + "%");
                }

//                if (param.getGender() != null) {
//                    criteria.andGenderEqualTo(param.getGender());
//                }


                users = userMapper.selectByExample(userExample);
            } else {
                User user = userMapper.selectByPrimaryKey(id);
                users = new ArrayList<>();
                users.add(user);
            }

            PageInfo<User> pageInfo = new PageInfo<>(users);

            DataVo<User> dataVO = new DataVo<>(pageInfo.getTotal(), users, pageNo, pageSize);

            resultVo = new ResultVo(200, "OK", true, dataVO);
        } catch (Exception e) {
            resultVo = new ResultVo(-1000, "fail", false, null);
        }

        return resultVo;
    }

    @Override
    public ResultVo login(String username, String password) {
        ResultVo resultVo = new ResultVo();
        //用户名不存在
        resultVo.setCode(-1);
        resultVo.setMessage("用户名不存在");
        resultVo.setData(null);
        resultVo.setSuccess(false);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        if (users.size()>0&&users!=null){
            //说明用户存在
            User user = users.get(0);
            if (user.getPassword().equals(password)){
                //登录成功
                resultVo.setCode(200);
                resultVo.setSuccess(true);
                resultVo.setMessage("登录成功！");

                Map<String,Object> header = new HashMap<>();
                header.put("alg","HS256");
                header.put("typ","JWT");
                //盐值,不能写死
                String salt = String.valueOf((int) ((Math.random() * 9 + 1) * 1000000));
                //获取token
                String token = JWT.create()
                        .withHeader(header)
                        //过期时间尽可能短
                        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 20))
                        .withIssuer("admin")
                        //发布时间
                        .withIssuedAt(new Date())
                        //主题
                        .withSubject("权限认证")
                        .withClaim("id", user.getId())
                        .withClaim("username", username)
                        .withClaim("salt", salt)
                        // 签发
                        .sign(Algorithm.HMAC256(salt));
                Map<String,Object> data = new HashMap<>();
                user.setPassword(null);
                data.put("user",user);
                data.put("data",token);
                resultVo.setData(data);
            }else {
                // 密码错误，登录失败
                resultVo.setMessage("登录失败，密码错误！！！");
            }

        }
        return null;
    }

    @Override
    public ResultVo delete(Long id) {
       int affectedRows = userMapper.deleteByPrimaryKey(id);
       ResultVo resultVo;
       if(affectedRows>0){
           resultVo = new ResultVo(200,"删除成功",true,null);
       }else {
           resultVo = new ResultVo(-1,"删除失败",false,null);
       }
        return resultVo;
    }

    @Override
    public ResultVo updateUser(User user) {
        int affectedRows = userMapper.updateByPrimaryKeySelective(user);
        ResultVo resultVo;
        if(affectedRows >0){
            User result = userMapper.selectByPrimaryKey(user.getId());
            resultVo = new ResultVo(200,"修改成功",true,result);
        }else {
            resultVo = new ResultVo(-1,"修改失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo addUser(User user) {
        ResultVo resultVo;
        if(user.getCreateTime() == null){
            user.setCreateTime(new Date());
        }
        int affectedRows = userMapper.insertSelective(user);

        if(affectedRows>0){
            resultVo = new ResultVo(200,"添加成功",true,user);
        }else {
            resultVo = new ResultVo(-1,"添加失败",false,null);
        }
            return resultVo;
    }


}
