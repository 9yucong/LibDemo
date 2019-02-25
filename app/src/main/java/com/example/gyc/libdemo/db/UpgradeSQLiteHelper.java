package com.example.gyc.libdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.gyc.greendao.DaoMaster;
import com.example.gyc.greendao.StudentDao;
import org.greenrobot.greendao.database.Database;

/**
 * Description:
 *
 * @author: gaoyucong
 * Date: 2019-02-25 上午 9:59
 */
public class UpgradeSQLiteHelper extends DaoMaster.DevOpenHelper {

    public UpgradeSQLiteHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        MigrationHelper.getInstance().migrate(db
                ,StudentDao.class);
    }
}
