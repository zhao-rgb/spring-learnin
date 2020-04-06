package com.soft1851.spring.jdbc.mybatis.mapper;

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
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    public void insert() {
        Student student = Student.builder()
                .clazzId(1)
                .studentName("测试学生")
                .hometown("江苏无锡")
                .birthday(LocalDate.of(2000,4,20))
                .build();
        studentMapper.insert(student);
        System.out.println(student.getStudentId());
    }

    @Test
    public void delete() {
        studentMapper.delete(4009);
    }

    @Test
    public void update() {
        Student student = studentMapper.getStudentById(4008);
        System.out.println(student);
        student.setStudentName("新名字");
        student.setHometown("上海");
        student.setBirthday(LocalDate.of(1999,11,11));
        studentMapper.update(student);
        System.out.println(studentMapper.getStudentById(2011));
    }

    @Test
    public void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Student student = Student.builder()
                    .studentId(5000 + i)
                    .studentName("测试" + i)
                    .clazzId(1)
                    .hometown("测试城市")
                    .birthday(LocalDate.of(1999,10,10))
                    .build();
            students.add(student);
        }
        System.out.println(studentMapper.batchInsert(students));
    }

    @Test
    public void batchUpdate() {
        List<Student> list = new ArrayList<>();
        for (int i = 1; i < 6; i++){
            Student student = Student.builder()
                    .studentId(4000 + i)
                    .studentName("测试555" + i)
                    .clazzId(3)
                    .build();
            list.add(student);
        }
        int n = studentMapper.batchUpdate(list);
        System.out.println(n);
    }

    @Test
    public void selectLimit() {
        List<Student> students = studentMapper.selectLimit();
        students.forEach(System.out::println);
    }

    @Test
    public void selectAll() {
        List<Student> students = studentMapper.selectAll();
        students.forEach(student -> {
            System.out.println(student.getStudentId()
                    + "," + student.getStudentName()
                    + "," + student.getHometown()
                    + "," + student.getBirthday()
                    + "," + student.getClazz().getClazzName());
        });
    }
}