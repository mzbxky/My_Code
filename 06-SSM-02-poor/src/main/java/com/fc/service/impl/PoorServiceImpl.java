package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;
    @Override
    public Map<String, Object> findAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Poor> list = poorMapper.selectByExample(null);
        PageInfo<Poor> pageInfo = new PageInfo<>(list);
        Map<String,Object> map = new HashMap<>();
        if (pageInfo.getList() == null){
            map.put("message","贫困户获取失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","贫困户获取成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:",pageInfo);
        return map;
    }

    @Override
    public Map<String, Object> add(PoorWithBLOBs poor) {
        Map<String,Object> map = new HashMap<>();
        if (poorMapper.insert(poor)!=1){
            map.put("message","贫困户添加失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","贫困户添加成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:",1);
        return map;
    }

    @Override
    public Map<String, Object> update(PoorWithBLOBs poor) {
        Map<String,Object> map = new HashMap<>();
        if (poorMapper.updateByPrimaryKey(poor)!=1){
            map.put("message","贫困户修改失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","贫困户修改成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:",1);
        return map;
    }

    @Override
    public Map<String, Object> delete(Long id) {
        Map<String,Object> map = new HashMap<>();
        if (poorMapper.deleteByPrimaryKey(id)!=1){
            map.put("message","贫困户删除失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","贫困户删除成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:",1);
        return map;

    }

    @Override
    public Map<String, Object> click(Long id, Date lastClickTime) {
        Map<String,Object> map = new HashMap<>();
        if (poorMapper.click(id,lastClickTime)!=1){
            map.put("message","设置失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","设置成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:",1);
        return map;

    }

}
