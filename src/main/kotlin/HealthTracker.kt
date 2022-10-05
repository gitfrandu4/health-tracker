import interfaces.Action
import records.ExerciseRecord
import users.User
import records.Record
import records.WaterRecord

class HealthTracker: Action {

    private val users: MutableList<User> = mutableListOf()

    fun registerUser(name: String, email: String, password: String, phone: String): Boolean {
        return if(!userEmailExists(email)) {
            users.add(User(name, email, password, phone))
            return true
        } else {
            false
        }
    }

    fun getUser(email: String, password: String): User? = users.find{ it.email == email && it.checkPassword(password) }

    private fun userEmailExists(email: String): Boolean = users.find{ it.email == email } != null

    override fun addRecord(user: User, record: Record) {
        when(record){
            is ExerciseRecord -> user.addExerciseRecord(record)
            is WaterRecord -> user.addWaterRecord(record)
        }
    }

    override fun removeRecord(user: User, record: Record) {
        when(record){
            is ExerciseRecord -> user.removeExerciseRecord(record.id)
            is WaterRecord -> user.removeWaterRecord(record.id)
        }
    }

    fun showUserRecords(user: User) {
        if(user.exerciseRecords.isNotEmpty()) user.exerciseRecords.forEach{it -> println(it.toString()) }
        if(user.waterRecords.isNotEmpty()) user.waterRecords.forEach{it -> println(it.toString()) }
    }

}