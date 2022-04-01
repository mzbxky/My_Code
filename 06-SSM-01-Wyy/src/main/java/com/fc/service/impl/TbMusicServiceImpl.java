package com.fc.service.impl;

import com.fc.dao.TbMusicMapper;
import com.fc.entity.TbMusic;
import com.fc.service.TbMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbMusicServiceImpl implements TbMusicService{
    // 声明dao层接口
    @Autowired
    private TbMusicMapper musicMapper;

    @Override
    public List<TbMusic> findAll() {
        // 不带条件查询全部
        return musicMapper.selectByExample(null);
    }

    @Override
    public TbMusic findById(Integer musicId) {
        return musicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic nextSong(Integer musicId) {
       Integer maxId =  musicMapper.findMaxId();
       if (musicId != maxId){
           musicId++;
       }else if(musicId == maxId){
           musicId = 1;
       }
        return musicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic prevSong(Integer musicId) {
        Integer maxId =  musicMapper.findMaxId();
       if(musicId == 1){
           musicId = maxId;
       }else{
           musicId--;
       }
        return musicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public List<TbMusic> search(String keyword) {

        return musicMapper.findArtistAndMusicName("%"+keyword+"%");
    }


//    public List<TbMusic> ArtistName(String keyword) {
//        TbMusicExample tbMusicExample = new TbMusicExample();
//        TbMusicExample.Criteria criteria = tbMusicExample.createCriteria();
//        //criteria.andMusicNameLike("%"+keyword + "%");
//        criteria.andMusicArtistNameLike("%"+keyword+"%");
//        System.out.println(tbMusicExample);
//        return musicMapper.selectByExample(tbMusicExample);
//    }
//
//
//
//    public List<TbMusic> MusicName(String keyword) {
//        TbMusicExample tbMusicExample = new TbMusicExample();
//        TbMusicExample.Criteria criteria = tbMusicExample.createCriteria();
//        criteria.andMusicNameLike("%"+keyword + "%");
//
//        return musicMapper.selectByExample(tbMusicExample);
//    }
//@Override
//public List<TbMusic> search(String keyword) {
//
//        List<TbMusic> list = new ArrayList<>();
//        List<TbMusic> artistName = this.ArtistName(keyword);
//        List<TbMusic> musicName = this.MusicName(keyword);
//        for(int i = 0;i<artistName.size();i++){
//            list.add(artistName.get(i));
//        }
//        for(int i = 0;i<musicName.size();i++){
//        list.add(musicName.get(i));
//    }
//    return list;
//}
}
