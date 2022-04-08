package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
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
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;
    @Override
    public ResultVo getList(Integer pageNo, Integer pageSize,Long id) {
       ResultVo resultVo;
       List<Poor> poors;
       try {
           if(id == null){
               PageHelper.startPage(pageNo,pageSize);
               poors = poorMapper.selectByExample(null);

           }else {
               Poor poor = poorMapper.selectByPrimaryKey(id);
               poors=new ArrayList<>();
               poors.add(poor);

               click(poor.getId(),null);
           }
           PageInfo<Poor> pageInfo = new PageInfo<>(poors);

           DataVo<Poor> dataVo = new DataVo<>(pageInfo.getTotal(),poors,pageNo,pageSize);

           resultVo = new ResultVo(200,"查询成功",true,dataVo);

       }catch (Exception e){
           resultVo = new ResultVo(-1,"查询失败",false,null);
       }
       return resultVo;
    }

    @Override
    public ResultVo add(PoorWithBLOBs poor) {
        ResultVo resultVo;
        if(poor.getCreateTime() == null){
            poor.setCreateTime(new Date());
        }
        int affectedRows = poorMapper.insertSelective(poor);
        if(affectedRows>0){
            if (poor.getClickNum()==null){
                poor.setClickNum(0);
            }
            resultVo = new ResultVo(200,"添加成功",true,poor);
        }else {
            resultVo = new ResultVo(-1,"添加失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo update(PoorWithBLOBs poor) {
        ResultVo resultVo;
        int affectedRows = poorMapper.updateByPrimaryKeySelective(poor);
        if(affectedRows>0){
            Poor result = poorMapper.selectByPrimaryKey(poor.getId());
            resultVo = new ResultVo(200,"修改成功",true,result);
        }else {
            resultVo = new ResultVo(-1,"修改失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
       ResultVo resultVo;
       int affectedRows = poorMapper.deleteByPrimaryKey(id);
        if(affectedRows>0){
            resultVo = new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo = new ResultVo(-1,"删除失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo click(Long id, Date lastClickTime) {
        ResultVo resultVo;
        if (lastClickTime == null){
            lastClickTime = new Date();
        }
        int affectedRows = poorMapper.click(id,lastClickTime);
        if(affectedRows>0){
            resultVo = new ResultVo(200,"点击成功",true,null);
        }else {
            resultVo = new ResultVo(-1,"点击失败",false,null);
        }
        return resultVo;

    }


}
