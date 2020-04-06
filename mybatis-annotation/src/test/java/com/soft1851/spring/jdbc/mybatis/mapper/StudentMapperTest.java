package com.soft1851.spring.jdbc.mybatis.mapper;

import com.soft1851.spring.mybatis.config.MapperConfig;
import com.soft1851.spring.mybatis.entity.Student;
import com.soft1851.spring.mybatis.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MapperConfig.class})
public class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    public void insert() {
        Student student = Student.builder()
                .clazzId(1)
                .studentName("测试学")
                .hometown("江苏南京")
                .birthday(LocalDate.of(2000, 10, 10))
                .build();
        studentMapper.insert(student);
        System.out.println(student.getStudentId());
    }

    @Test
    public void delete() {
        studentMapper.delete(5013);
    }

    @Test
    public void update() {
        Student student = studentMapper.getStudentById(4008);
        student.setStudentName("new name");
        student.setHometown("beijing");
        studentMapper.update(student);
    }

    @Test
    public void getStudentById() {
        System.out.println(studentMapper.getStudentById(1001));
    }

    @Test
    public void selectAll() {
        System.out.println(studentMapper.selectAll());
    }

    @Test
    public void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Student student = Student.builder()
                    .studentName("学生" + i)
                    .clazzId(1)
                    .hometown("测试城市")
                    .birthday(LocalDate.of(2000, 12, 12))
                    .build();
            students.add(student);
        }
        studentMapper.batchInsert(students);
    }
}