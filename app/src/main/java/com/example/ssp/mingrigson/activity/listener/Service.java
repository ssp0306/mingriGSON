package com.example.ssp.mingrigson.activity.listener;

/**
 * Created by ${宋少鹏} on 2019/12/27.
 * 功能:
 * 邮箱:4646224@qq.com
 */
public interface Service {

    //用于展示列表数据
    String first_url = "http://www.mingrisoft.com/Index/API/getAllCourse/rows/7";
    //获取页面详请
    String second_url = "http://www.mingrisoft.com/Index/API/getSystemCourseInfo/course_id/"+"%s"+"/user_id/"+"%s";
}