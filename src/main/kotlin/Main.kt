import enums.ExerciseType
import records.ExerciseRecord
import records.WaterRecord

fun main() {

    val app = HealthTracker()

    app.registerUser("Jensen Huang", "jensen@huang.com", "password1", "687458622")
    app.registerUser("Lisa Su", "lisa@su.com", "password2", "688741558")
    app.registerUser("Michael Dell", "michael@dell.com", "password3", "699741588")
    app.registerUser("Susan Wojcicki", "susan@wojcicki.com", "password4", "688744590")

    val user = app.getUser("jensen@huang.com", "password1")
    user?.setUserMeasures(80.0, 1.70, 10.01)
    println(user?.getUserInfo())

    if (user != null) {
        app.addRecord(user, ExerciseRecord(ExerciseType.Sentadillas, 30.00))
        app.addRecord(user, ExerciseRecord(ExerciseType.Running, 120.00))
        app.addRecord(user, ExerciseRecord(ExerciseType.Boxeo, 15.00))
        app.addRecord(user, WaterRecord(0.50))
        app.addRecord(user, WaterRecord(1.50))

        app.showUserRecords(user)

        while (user.exerciseRecords.isNotEmpty()){
            app.removeRecord(user, user.exerciseRecords.first())
        }

        app.showUserRecords(user)

    }


}