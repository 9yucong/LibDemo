package com.example.gyc.libdemo.manager

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Description:
 *
 * @author: gaoyucong
 * Date: 2019-02-22 下午 3:15
 */
@RunWith(AndroidJUnit4::class)
class DBManagerTest {
    @Test
    fun testDBManagerUnique() {
        val master1 = DBManager.getDaoMaster()
        val master2 = DBManager.getDaoMaster()
        val session1 = DBManager.getDaoSession()
        val session2 = DBManager.getDaoSession()
        assertSame(master1, master2)
        assertSame(session1, session2)
    }
}