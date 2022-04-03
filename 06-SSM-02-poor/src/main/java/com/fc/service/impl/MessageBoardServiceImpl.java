package com.fc.service.impl;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;
    @Override
    public Map<String, Object> findAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<MessageBoard> list = messageBoardMapper.selectByExample(null);
        PageInfo<MessageBoard> pageInfo = new PageInfo<>(list);
        Map<String,Object> map = new HashMap<>();
        if (pageInfo.getList() == null){
            map.put("message","留言获取失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","留言获取成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:",pageInfo);
        return map;
    }

    @Override
    public Map<String, Object> add(MessageBoardWithBLOBs messageBoard) {
        Map<String,Object> map = new HashMap<>();
        if (messageBoardMapper.insert(messageBoard) != 1){
            map.put("message","留言添加失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","留言添加成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:",1);
        return map;
    }

    @Override
    public Map<String, Object> delete(Long id) {
        Map<String,Object> map = new HashMap<>();
        if (messageBoardMapper.deleteByPrimaryKey(id) != 1){
            map.put("message","留言删除失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","留言删除成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:",1);
        return map;

    }
}
