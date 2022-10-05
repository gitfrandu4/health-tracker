package records

import java.time.Instant
import java.time.Instant.now

var lastId = 0L

abstract class Record(val amount: Double) {
    val recordDate: Instant = now()
    val id: Long = lastId
    init {
        lastId++
    }
}