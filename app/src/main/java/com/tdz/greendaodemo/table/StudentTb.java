package com.tdz.greendaodemo.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.List;

/**
 * 学生表
 * Created by HaoXi on 2017/12/1.
 */
@Entity
public class StudentTb {
    @Id(autoincrement = true)
    long id;  //id
    String name;  //姓名
    long   classId;  //班级id
    String createTime;  //创建时间
    String modifyTime;  //修改时间

    //表示StudentTb的classId和ClassTb的id关联
    @ToOne(joinProperty = "classId")
    ClassTb classTb;  //班级 一个学生属于一个班级
    @ToMany(joinProperties = {@JoinProperty(name="id", referencedName = "studentId")})
    List<ScoreTb> scoreList;  //成绩列表，一个人可能有多个科目的成绩
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1837620199)
    private transient StudentTbDao myDao;

    @Generated(hash = 812820680)
    public StudentTb(long id, String name, long classId, String createTime,
            String modifyTime) {
        this.id = id;
        this.name = name;
        this.classId = classId;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    @Generated(hash = 1400751407)
    public StudentTb() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getClassId() {
        return this.classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
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

    @Generated(hash = 566738656)
    private transient Long classTb__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 2077471413)
    public ClassTb getClassTb() {
        long __key = this.classId;
        if (classTb__resolvedKey == null || !classTb__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ClassTbDao targetDao = daoSession.getClassTbDao();
            ClassTb classTbNew = targetDao.load(__key);
            synchronized (this) {
                classTb = classTbNew;
                classTb__resolvedKey = __key;
            }
        }
        return classTb;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 174359738)
    public void setClassTb(@NotNull ClassTb classTb) {
        if (classTb == null) {
            throw new DaoException(
                    "To-one property 'classId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.classTb = classTb;
            classId = classTb.getId();
            classTb__resolvedKey = classId;
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

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1685687916)
    public List<ScoreTb> getScoreList() {
        if (scoreList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ScoreTbDao targetDao = daoSession.getScoreTbDao();
            List<ScoreTb> scoreListNew = targetDao._queryStudentTb_ScoreList(id);
            synchronized (this) {
                if (scoreList == null) {
                    scoreList = scoreListNew;
                }
            }
        }
        return scoreList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 2074989865)
    public synchronized void resetScoreList() {
        scoreList = null;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1084564441)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentTbDao() : null;
    }

}
