package com.tdz.greendaodemo.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tdz.greendaodemo.R;
import com.tdz.greendaodemo.app.App;
import com.tdz.greendaodemo.helper.CommonHelper;
import com.tdz.greendaodemo.table.ClassTb;
import com.tdz.greendaodemo.table.CourseTb;
import com.tdz.greendaodemo.table.ScoreTb;
import com.tdz.greendaodemo.table.StudentTb;
import com.tdz.greendaodemo.table.StudentTbDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * 添加数据
     */
    @OnClick(R.id.btn_add_data)
    public void addData() {
        clearData();  //先清空
        //班级
        for (int i = 1; i <= 3; i++) {
            ClassTb classTb = new ClassTb();
            classTb.setName("CS班级" + i);
            classTb.setId(i);
            classTb.setCreateTime(CommonHelper.getDatetime());
            classTb.setModifyTime(CommonHelper.getDatetime());
            App.getInstance().getDaoSession().getClassTbDao().insert(classTb);
        }

        //课程
        for (int i = 1; i <= 10; i++) {
            CourseTb courseTb = new CourseTb();
            courseTb.setId(i);
            courseTb.setName("专业" + i);
            courseTb.setCreateTime(CommonHelper.getDatetime());
            courseTb.setModifyTime(CommonHelper.getDatetime());
            App.getInstance().getDaoSession().getCourseTbDao().insert(courseTb);
        }

        //学生
        for (int i = 1; i <= 20; i++) {
            StudentTb studentTb = new StudentTb();
            studentTb.setId(i);
            studentTb.setClassId(i % 3 + 1);
            studentTb.setName("学生" + i);
            studentTb.setCreateTime(CommonHelper.getDatetime());
            studentTb.setModifyTime(CommonHelper.getDatetime());
            App.getInstance().getDaoSession().getStudentTbDao().insert(studentTb);
        }

        //成绩
        for (int i = 1; i <= 1000; i++) {
            ScoreTb scoreTb = new ScoreTb();
            scoreTb.setId(i);
            scoreTb.setStudentId(i % 20 + 1);  //studentId
            scoreTb.setCourseId(i % 10 + 1);  //成绩id
            scoreTb.setScore(CommonHelper.toFloat(new DecimalFormat("#.00").format(Math.random() * 100)));  //保留2位小数
            scoreTb.setCreateTime(CommonHelper.getDatetime());
            scoreTb.setModifyTime(CommonHelper.getDatetime());
            App.getInstance().getDaoSession().getScoreTbDao().insert(scoreTb);
        }
    }

    /**
     * 清除数据
     */
    @OnClick(R.id.btn_clear_data)
    public void clearData() {
        App.getInstance().getDaoSession().getClassTbDao().deleteAll();
        App.getInstance().getDaoSession().getCourseTbDao().deleteAll();
        App.getInstance().getDaoSession().getStudentTbDao().deleteAll();
        App.getInstance().getDaoSession().getScoreTbDao().deleteAll();
    }

    /**
     * 查询学生信息
     */
    @OnClick(R.id.btn_query_stu_info)
    public void queryStuInfo() {
        QueryBuilder<StudentTb> queryBuilder = App.getInstance().getDaoSession().getStudentTbDao().queryBuilder();
//        queryBuilder.join(StudentTbDao.Properties.ClassId, ClassTb.class);
        List<StudentTb> list = queryBuilder.list();

    }

    @OnClick(R.id.btn_query_stu_score)
    public void queryStuScore() {
        QueryBuilder<StudentTb> queryBuilder = App.getInstance().getDaoSession().getStudentTbDao().queryBuilder();
        List<StudentTb> list = queryBuilder.list();

    }

    @OnClick(R.id.btn_query_class_avg_score)
    public void queryClassAvgScore() {
        QueryBuilder<StudentTb> queryBuilder = App.getInstance().getDaoSession().getStudentTbDao().queryBuilder();
    }
}
