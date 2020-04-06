package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhao
 * @className StudentMapper
 * @Description TODO
 * @Date 2020/4/1
 * @Version 1.0
 **/
public interface StudentMapper {

    /**
     * 新增Student,返回自增主键
     *
     * @param student
     */
    @Insert("INSERT INTO t_student VALUES (NULL,#{clazzId},#{studentName},#{hometown},#{birthday})")
    @Options(useGeneratedKeys = true, keyProperty = "studentId")
    void insert(Student student);

    /**
     * 根据id删除Student
     *
     * @param studentId
     */
    @Delete("DELETE FROM t_student WHERE student_id = #{studentId}")
    void delete(int studentId);

    /**
     * 更新Student
     *
     * @param student
     */

    @Update("UPDATE t_student SET student_name = #{studentName},hometown = #{hometown} WHERE student_id = #{studentId}")
    void update(Student student);

    /**
     * 根据id查询Student
     *
     * @param studentId
     * @return
     */
    @Select("SELECT * FROM t_student WHERE student_id = #{studentId}")
    Student getStudentById(int studentId);

    /**
     * 查询所有Student
     *
     * @return
     */
    @Select("SELECT * FROM t_student ")
    List<Student> selectAll();

    /**
     * 批量新增Student
     *
     * @param students
     */
    @Insert("<script>" +
            "INSERT INTO t_student (clazz_id,student_name,hometown,birthday) VALUES " +
            "<foreach collection=\"studentList\" item=\"student\" index=\"index\"  separator=\",\">" +
            "(#{student.clazzId},#{student.studentName},#{student.hometown},#{student.birthday}) " +
            "</foreach>" +
            "</script>")
    void batchInsert(@Param("studentList") List<Student> students);

}
