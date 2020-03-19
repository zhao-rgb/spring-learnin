package com.soft1851.spring.orm.dao;

import com.soft1851.spring.orm.entity.Post;

import java.util.List;

/**
 * @author zhao
 * @className PostDao
 * @Description TODO
 * @Date 2020/3/19
 * @Version 1.0
 **/
public interface PostDao {
    /**
     * 新增Post
     * @param post
     * @return
     */
    int insert(Post post);

    /**
     * 批量新增Post
     * @param posts
     * @return
     */
    int[] batchInsert(List<Post> posts);

    /**
     * 批量删除
     * @param posts
     * @return
     */
    int[] batchDelete(List<Post> posts);

    /**
     * 根据id删除Post
     * @param postId
     * @return
     */
    int delete(int postId);

    /**
     * 根据id查询Post
     * @param postId
     * @return
     */
    Post get(int postId);

    /**
     * 根据关键词查询Post
     * @param key
     * @return
     */
    List<Post> selectByKey(String key);

    /**
     * 统计某个论坛的帖子总数
     * @return
     */
    int count();

}
