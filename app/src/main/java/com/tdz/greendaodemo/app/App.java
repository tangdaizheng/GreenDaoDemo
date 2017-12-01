package com.tdz.greendaodemo.app;

import android.support.multidex.MultiDexApplication;

import com.facebook.stetho.Stetho;
import com.tdz.greendaodemo.table.DaoMaster;
import com.tdz.greendaodemo.table.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * 应用类
 * Created by HaoXi on 2017/12/1.
 */

public class App extends MultiDexApplication {

    private static App        instance;  //实例
    private static DaoSession daoSession;  //greenDao 会话

    /**
     * 获取实例
     *
     * @return App
     */
    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        init();
    }

    /**
     * 初始化
     */
    private void init() {
        initDaoSession();
        initStetho();
    }

    /**
     * 初始化greenDao session
     */
    private void initDaoSession() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getInstance(), "greenDaoDemo");
        Database                db            = devOpenHelper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    /**
     * 初始化stetho
     */
    private void initStetho() {
        Stetho.initializeWithDefaults(getInstance());
    }

    /**
     * 获取greenDao session
     *
     * @return
     */
    public DaoSession getDaoSession() {
        if (daoSession == null) {
            initDaoSession();
        }
        return daoSession;
    }

}
