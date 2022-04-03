package com.fc.service.impl;

import com.fc.dao.AlleviationMapper;
import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class AlleviationServiceImpl implements AlleviationService {
    @Autowired
    private AlleviationMapper alleviationMapper;
    @Override
    public Map<String, Object> findAll(Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Alleviation> list = alleviationMapper.selectByExample(null);
        PageInfo<Alleviation> pageInfo = new PageInfo<>(list);
        Map<String,Object> map = new HashMap<>();
        if (pageInfo.getList() == null){
            map.put("message","用户获取失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","用户获取成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:",pageInfo);
        return map;
    }

    @Override
    public Map<String, Object> add(Alleviation alleviation) {
        Map<String,Object> map = new HashMap<>();
        if (alleviationMapper.insert(alleviation) != 1){
            map.put("message","用户添加失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","用户添加成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:","{}");
        return map;
    }

    @Override
    public Map<String, Object> update(Alleviation alleviation) {
        Map<String,Object> map = new HashMap<>();
        if (alleviationMapper.updateByPrimaryKey(alleviation) != 1){
            map.put("message","用户修改失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","用户修改成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:","{}");
        return map;
    }

    @Override
    public Map<String, Object> delete(Long id) {
        Map<String,Object> map = new HashMap<>();
        if (alleviationMapper.deleteByPrimaryKey(id) != 1){
            map.put("message","用户删除失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","用户删除成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:","{}");
        return map;
    }

    @Override
    public Map<String,Object> click(Date lastClickTime, Long id) {
        Map<String,Object> map = new HashMap<>();
        if (alleviationMapper.click(lastClickTime,id) != 1){
            map.put("message","设置失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","设置成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:","{}");
        return map;

    }
}
