import java.awt.EventQueue

fun main() {
    EventQueue.invokeLater {
        val frame = TrafficLightsFrame()
        frame.isVisible = true
    }
}