package com.fc.controller;

import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//
@RestController
@RequestMapping("poor")
@CrossOrigin
@Api(value = "PoorController" ,description = "贫困户相关的操作")
public class poorController {
    @Autowired
private PoorService poorService;
    @GetMapping("getlist")
    @ApiOperation("查询全部贫困户")
    public ResultVo getList(@ApiParam(name = "pageNum",value = "每页的数据条数") @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @ApiParam(name = "pageSize",value = "页码")@RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize,
                            @ApiParam(name = "id",value = "贫困户的序号") Long id){
        return poorService.getList(pageNum,pageSize,id);
    }
    @PostMapping("add")
    @ApiOperation("添加贫困户")
    public ResultVo add(@ApiParam(name = "poor",value = "贫困户信息")@RequestBody PoorWithBLOBs poor){
        return poorService.add(poor);
    }
    @PostMapping("update")
    @ApiOperation("修改贫困户数据")

    public ResultVo update(@ApiParam(name = "poor",value = "要修改的贫困户信息")@RequestBody PoorWithBLOBs poor){
        return poorService.update(poor);
    }
    @GetMapping("delete")
    @ApiOperation("删除贫困户信息")
    public ResultVo delete(@ApiParam(name = "id",value = "要删除的贫困户编号") Long id){
        return poorService.delete(id);
    }
    @PostMapping("click")
    @ApiOperation("用户被查看时访问量自增1")
    public ResultVo click(@ApiParam(name = "poor",value = "被查看的用户")@RequestBody Poor poor){
        return poorService.click(poor.getId(),poor.getLastClickTime());
    }
}
