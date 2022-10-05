package interfaces

import users.User
import records.Record

interface Action {
    fun addRecord(user: User, record: Record)
    fun removeRecord(user: User, record: Record)
}