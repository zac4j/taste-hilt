package cn.zacash.android.hilt.data

/**
 * Data source interface design for CRUD logger data
 */
interface LoggerDataSource {

    fun addLog(msg: String)

    fun getAllLogs(callback: (List<Log>) -> Unit)

    fun removeLogs()

}