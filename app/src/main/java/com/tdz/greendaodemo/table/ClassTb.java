package com.tdz.greendaodemo.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 班级表
 * Created by HaoXi on 2017/12/1.
 */
@Entity
public class ClassTb {
    @Id(autoincrement = true)
    long id;  //id
    String name;  //名称
    String createTime;  //创建时间
    String modifyTime;  //修改时间
    @Generated(hash = 1078132522)
    public ClassTb(long id, String name, String createTime, String modifyTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }
    @Generated(hash = 2146792227)
    public ClassTb() {
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
}
