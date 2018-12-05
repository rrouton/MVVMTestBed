package com.rrouton.android.mvvmtestbed.Data

class Database private constructor() {

    var taskDao = TaskDao()
        private set

    companion object {
        @Volatile private var INSTANCE: Database? = null

        //Double-checked lock
        fun getInstance() =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: Database().also { INSTANCE = it }
                }

    }
}