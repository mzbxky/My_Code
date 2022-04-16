package com.fc.service.impl;

import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNoteType;
import com.fc.service.TypeService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;
    @Override
    public ResultVo list(Integer pageNum, Integer pageSize, Integer id) {
        ResultVo resultVo;
        List<TbNoteType> tbNoteTypes;
        try {
            if(id == null){
                PageHelper.startPage(pageNum,pageSize);
                tbNoteTypes = tbNoteTypeMapper.selectByExample(null);
            }else {
                TbNoteType tbNoteType = tbNoteTypeMapper.selectByPrimaryKey(id);
                tbNoteTypes = new ArrayList<>();
                tbNoteTypes.add(tbNoteType);
            }
            PageInfo<TbNoteType> pageInfo = new PageInfo<>(tbNoteTypes);

            DataVo<TbNoteType> dataVo = new DataVo<>(pageInfo.getTotal(),tbNoteTypes,pageNum,pageSize);

            resultVo = new ResultVo(200,"查询成功",true,dataVo);
        }catch (Exception e){
            resultVo = new ResultVo(-400,"查询失败",false,null);
        }

        return resultVo;
    }

    @Override
    public ResultVo addOrUpdate(TbNoteType tbNoteType) {
        ResultVo resultVo;
        //如果id为空，就是添加
        if(tbNoteType.getId() == null){
            int affectedRows = tbNoteTypeMapper.insertSelective(tbNoteType);
            if(affectedRows>0){
                resultVo = new ResultVo(200,"添加成功",true,tbNoteType);
            }else {
                resultVo = new ResultVo(-1,"添加失败",false,null);
            }
        }else {
            int affectedRows = tbNoteTypeMapper.updateByPrimaryKeySelective(tbNoteType);
            TbNoteType result = tbNoteTypeMapper.selectByPrimaryKey(tbNoteType.getId());
            if(affectedRows>0){
                resultVo = new ResultVo(200,"修改成功",true,result);
            }else {
                resultVo = new ResultVo(-1,"修改失败",false,null);
            }
        }

        return resultVo;
    }

    @Override
    public ResultVo delete(Integer id) {
        ResultVo resultVo;
        TbNoteType tbNoteType = tbNoteTypeMapper.selectByPrimaryKey(id);
        if(tbNoteType == null){
            resultVo = new ResultVo(-1,"删除失败",false,null);
            return resultVo;
        }
        int affectedRows = tbNoteTypeMapper.deleteByPrimaryKey(id);
        if(affectedRows>0){
            resultVo = new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo = new ResultVo(-1,"删除失败",false,null);
        }
        return resultVo;
    }

}
