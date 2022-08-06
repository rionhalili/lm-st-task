import java.math.RoundingMode
import java.text.DecimalFormat

class RoundingOperation {

    companion object {
        private const val ROUND_OFF_VALUE = 0.05

        fun roundedValue(value: Double): Double {
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.UP
            val result = (value / ROUND_OFF_VALUE + 0.5).toInt() * 0.05
            return df.format(result).toDouble()
        }
    }
}