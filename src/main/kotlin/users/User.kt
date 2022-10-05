package users

import records.ExerciseRecord
import records.WaterRecord

class User (
    private val name: String,
    val email: String,
    private val password: String,
    private val phone: String,
) {
    private val measures: PhysicalMeasure = PhysicalMeasure(0.00, 0.00, 0.00)
    internal val exerciseRecords: MutableList<ExerciseRecord> = mutableListOf<ExerciseRecord>()
    internal val waterRecords: MutableList<WaterRecord> = mutableListOf<WaterRecord>()

    internal fun checkPassword(password: String): Boolean{
        return this.password == password
    }

    internal fun setUserMeasures(weight: Double, height: Double, fat_percentage: Double) {
        measures.weight = weight
        measures.height = height
        measures.fat_percentage = fat_percentage
    }

    internal fun getUserInfo(): String {
        return "$name - $email - $phone\nCaracterísticas físicas: $measures"
    }

    fun addExerciseRecord(record: ExerciseRecord): Boolean = exerciseRecords.add(record)

    fun removeExerciseRecord(recordId: Long): ExerciseRecord? {
        for ((index, record) in exerciseRecords.withIndex()) {
            if (record.id == recordId) {
                println("Removing record with id: ${record.id}")
                return exerciseRecords.removeAt(index)
            }
        }
        return null
    }

    fun removeWaterRecord(recordId: Long): WaterRecord? {
        for ((index, record) in waterRecords.withIndex()) {
            if (record.id == recordId) {
                println("Removing record with id: ${record.id}")
                return waterRecords.removeAt(index)
            }
        }
        return null
    }

    fun addWaterRecord(record: WaterRecord): Boolean = waterRecords.add(record)
}