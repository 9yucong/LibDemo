package com.example.gyc.libdemo.manager

import android.app.Application
import android.content.Context
import com.example.gyc.greendao.DaoMaster
import com.example.gyc.greendao.DaoSession

/**
 * Description:
 * @author: gaoyucong
 * Date: 2019-02-22 上午 10:55
 */
class DBManager private constructor(context: Context) {
    private val DB_NAME = "test.db"
    private var devOpenHelper: DaoMaster.DevOpenHelper
    private var daoMaster: DaoMaster
    private var daoSession: DaoSession

    init {
        devOpenHelper = DaoMaster.DevOpenHelper(context, DB_NAME)
        daoMaster = DaoMaster(devOpenHelper.writableDatabase)
        daoSession = daoMaster.newSession()
    }

    companion object {
        @Volatile
        private var instance: DBManager? = null

        fun init(application: Application) =
            instance ?: synchronized(this) {
                instance ?: DBManager(application).also { instance = it }
            }

        fun getDaoMaster(): DaoMaster {
            return instance!!.daoMaster
        }

        fun getDaoSession(): DaoSession {
            return instance!!.daoSession
        }
    }
}