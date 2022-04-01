package com.fc.service;

import com.fc.entity.TbMusic;

import java.util.List;

public interface TbMusicService {
    List<TbMusic> findAll();

    TbMusic findById(Integer musicId);

    TbMusic nextSong(Integer musicId);

    TbMusic prevSong(Integer musicId);

    List<TbMusic> findByKeyword(String keyword);
}
