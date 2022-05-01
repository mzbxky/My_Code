package com.fc.service.impl;

import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbNoteTypeExample;
import com.fc.service.TypeService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;
    @Override
    public List<TbNoteType> list(Integer userId) {
        PageHelper.startPage(1, 5);
        TbNoteTypeExample example = new TbNoteTypeExample();

        TbNoteTypeExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<TbNoteType> types = tbNoteTypeMapper.selectByExample(example);
        PageInfo<TbNoteType> pageInfo = new PageInfo<>(types);
        return types;
    }

    @Override
    public ResultVo update(TbNoteType tbNoteType) {
        ResultVo result;
        int affectedRows = tbNoteTypeMapper.updateByPrimaryKeySelective(tbNoteType);
        TbNoteType type = tbNoteTypeMapper.selectByPrimaryKey(tbNoteType.getId());
        if (affectedRows>0){
            result = new ResultVo(1,"修改成功",true,type);

        }else {
            result = new ResultVo(0,"修改失败",true,null);

        }
        return result;
    }

    @Override
    public ResultVo add(TbNoteType tbNoteType) {
        ResultVo result;
        int affectedRows = tbNoteTypeMapper.insertSelective(tbNoteType);
        if (affectedRows>0){
            result = new ResultVo(1,"添加成功",true,tbNoteType);

        }else {
            result = new ResultVo(0,"添加失败",true,null);

        }
        return result;
    }

    @Override
    public ResultVo delete(Integer id) {
        ResultVo result;
        TbNoteType type = tbNoteTypeMapper.selectByPrimaryKey(id);
        if (type==null){
            result = new ResultVo(0,"删除失败",false,null);

        }else {
            int affectedRows = tbNoteTypeMapper.deleteByPrimaryKey(id);
            if (affectedRows>0){
                result = new ResultVo(1,"删除成功",true,null);
            }else {
                result = new ResultVo(0,"删除失败",false,null);

            }

        }
        return result;
    }


}
