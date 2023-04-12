package com.demo1.test;

import com.demo1.mapper.CourseMapper;
import com.demo1.pojo.Course;
import com.demo1.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class demo1Test {
    public static void main(String[] args) {
        SqlSession session = MyBatisUtils.getSession();
        CourseMapper mapper = session.getMapper(CourseMapper.class);

        //1. 查询 id=2 的课程信息；
        System.out.println(mapper.selectById(2));
        //2. 查询出所以计算机学院开设的课程信息；
        System.out.println(mapper.selectBySchoolname("计算机学院"));
        //3. 将 id=4 这门课程的课时数修改为 32+8=40；
        mapper.updateById(4);
        //4. 插⼊⼀条新的课程记录： names=”⼤数据存储“，hours=32，schools =1；
        Course course = new Course();
        course.setName("大数据存储");
        course.setHours(32);
        course.setSid(1);
        mapper.insert(course);
        session.commit();
        //5. 输出所有的学院开设的课程信息；
        System.out.println(mapper.selectAll());

        session.close();
    }
}
