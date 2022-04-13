package com.fc.service.impl;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;
    @Override
    public ResultVo getList(Integer pageNo, Integer pageSize,Long id) {
        List<MessageBoardWithBLOBs> messageBoards;
        ResultVo resultVo = new ResultVo();
        try {
            if (id == null){
                PageHelper.startPage(pageNo,pageSize);
                messageBoards = messageBoardMapper.selectByExampleWithBLOBs(null);
            }else {
                MessageBoardWithBLOBs messageBoard = messageBoardMapper.selectByPrimaryKey(id);
                messageBoards = new ArrayList<>();
                messageBoards.add(messageBoard);
            }
            PageInfo<MessageBoardWithBLOBs> pageInfo = new PageInfo<>(messageBoards);

            DataVo<MessageBoardWithBLOBs> dataVo = new DataVo<>(pageInfo.getTotal(),messageBoards,pageNo,pageSize);

            resultVo = new ResultVo(200,"查询成功",true,dataVo);
        }catch (Exception e){
            resultVo = new ResultVo(-1,"查询失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo add(MessageBoardWithBLOBs messageBoard) {
        ResultVo resultVo;
        if(messageBoard.getCreateTime() == null){
            messageBoard.setCreateTime(new Date());
        }
        int affectedRows = messageBoardMapper.insertSelective(messageBoard);
        if(affectedRows>0){
            resultVo = new ResultVo(200,"添加成功",true,messageBoard);
        }else {
            resultVo = new ResultVo(-1,"添加失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        int affectedRows = messageBoardMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if(affectedRows>0){
            resultVo = new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo = new ResultVo(-1,"删除失败",false,null);
        }
        return resultVo;

    }

    @Override
    public ResultVo reply(MessageBoardWithBLOBs messageBoard) {
        int affectedRows = messageBoardMapper.updateByPrimaryKeySelective(messageBoard);
        ResultVo resultVo;
        if(affectedRows>0){
            resultVo = new ResultVo(200,"回复留言成功",true,null);
        }else {
            resultVo = new ResultVo(-1,"回复留言失败",false,null);
        }
        return resultVo;
    }
}
