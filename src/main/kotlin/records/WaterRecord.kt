package records

class WaterRecord(amount: Double) : Record(amount) {
    override fun toString(): String {
        return "$id - $recordDate - Has bebido $amount litros de agua"
    }
}