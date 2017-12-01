package com.tdz.greendaodemo.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * 成绩表
 * Created by HaoXi on 2017/12/1.
 */
@Entity
public class ScoreTb {
    @Id(autoincrement = true)
    long id;  //id
    float  score;  //分数
    long   courseId;  //课程id
    long   studentId;  //学生id
    String createTime;  //创建时间
    String modifyTime;  //修改时间
    @ToOne(joinProperty = "courseId")
    CourseTb  courseTb;  //课程
    @ToOne(joinProperty = "studentId")
    StudentTb studentTb;  //学生
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1559524546)
    private transient ScoreTbDao myDao;
    @Generated(hash = 1081966690)
    private transient Long courseTb__resolvedKey;
    @Generated(hash = 1732124727)
    private transient Long studentTb__resolvedKey;

    @Generated(hash = 1185693298)
    public ScoreTb(long id, float score, long courseId, long studentId,
                   String createTime, String modifyTime) {
        this.id = id;
        this.score = score;
        this.courseId = courseId;
        this.studentId = studentId;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    @Generated(hash = 926060849)
    public ScoreTb() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourseId() {
        return this.courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public float getScore() {
        return this.score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1415389041)
    public CourseTb getCourseTb() {
        long __key = this.courseId;
        if (courseTb__resolvedKey == null || !courseTb__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CourseTbDao targetDao = daoSession.getCourseTbDao();
            CourseTb courseTbNew = targetDao.load(__key);
            synchronized (this) {
                courseTb = courseTbNew;
                courseTb__resolvedKey = __key;
            }
        }
        return courseTb;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2022628222)
    public void setCourseTb(@NotNull CourseTb courseTb) {
        if (courseTb == null) {
            throw new DaoException(
                    "To-one property 'courseId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.courseTb = courseTb;
            courseId = courseTb.getId();
            courseTb__resolvedKey = courseId;
        }
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 509650226)
    public StudentTb getStudentTb() {
        long __key = this.studentId;
        if (studentTb__resolvedKey == null
                || !studentTb__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StudentTbDao targetDao = daoSession.getStudentTbDao();
            StudentTb studentTbNew = targetDao.load(__key);
            synchronized (this) {
                studentTb = studentTbNew;
                studentTb__resolvedKey = __key;
            }
        }
        return studentTb;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1883224265)
    public void setStudentTb(@NotNull StudentTb studentTb) {
        if (studentTb == null) {
            throw new DaoException(
                    "To-one property 'studentId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.studentTb = studentTb;
            studentId = studentTb.getId();
            studentTb__resolvedKey = studentId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 829877717)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getScoreTbDao() : null;
    }
}
