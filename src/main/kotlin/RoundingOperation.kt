import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class RoundingOperation {

    companion object {
        private const val ROUND_OFF_VALUE = 0.05

        fun roundedValue(value: Double): Double {
            val result = (value / ROUND_OFF_VALUE + 0.5).toInt() * 0.05
            val formattedValue = String.format("%.2f", result)
            return formattedValue.toDouble()
        }
    }
}