package com.soft1851.spring.demo.mapper;

import com.soft1851.spring.demo.domain.entity.Collectio;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhao
 * @className CollectionMapper
 * @Description TODO
 * @Date 2020/4/3
 * @Version 1.0
 **/
public interface CollectionMapper {

    /**
     * 判断是否存在数据并且添加收藏
     * @param collection
     * @return
     */
    @Insert("INSERT INTO sys_collection (music_id,user_id) " +
            "SELECT #{musicId}, #{userId} FROM DUAL " +
            "WHERE NOT EXISTS " +
            "(SELECT * FROM sys_collection WHERE music_id = #{musicId} AND user_id = #{userId}) ")
    int insert(Collectio collection);

    /**
     * 动态查询collection
     * @param collection
     * @return
     */
    @Select({"<script> " +
            "SELECT" +
            "<if test = 'musicId != null'> user_id " +
            "</if> " +
            "<if test = 'userId != null'> music_id " +
            "</if> " +
            "FROM sys_collection " +
            "WHERE 1 = 1" +
            "<if test = 'musicId != null'> AND music_id = #{musicId} " +
            "</if> " +
            "<if test = 'userId != null'> AND user_id = #{userId} " +
            "</if> " +
            "</script> " })
    List<String> selectById(Collectio collection);
}

