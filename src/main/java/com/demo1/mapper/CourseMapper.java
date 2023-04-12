package com.demo1.mapper;

import com.demo1.pojo.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseMapper {
    @Select("select * from c_course where id=#{id}")
    Course selectById(int id);

    List<Course> selectBySchoolname(String schoolname);

    @Update("update c_course set hours=hours+8 where id=#{id}")
    void updateById(int id);

    @Insert("insert into c_course(id,name,hours,sid) values (null,#{name},#{hours}," +
            "#{sid})")
    void insert(Course course);

    @Select("select * from c_course")
    List<Course> selectAll();
}
