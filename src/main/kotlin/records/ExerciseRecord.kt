package records

import enums.ExerciseType

class ExerciseRecord(private val exercise: ExerciseType, amount: Double) : Record(amount) {
    override fun toString(): String {
        return "$id - $recordDate - $exercise: Has entrenado durante $amount minutos/repeticiones"
    }
}