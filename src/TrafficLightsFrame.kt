import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Graphics2D
import java.lang.Integer.min
import javax.swing.JFrame
import javax.swing.JPanel

class TrafficLightsFrame : JFrame() {
    private val mainPanel = createMainPanel()

    init {
        add(mainPanel)
        minimumSize = Dimension(400, 600)
        title = "Traffic Lights"
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
    }

    private fun createMainPanel() = object : JPanel() {
        private fun doDrawing(g: Graphics2D) {
            val colors = listOf(Color.RED, Color.YELLOW, Color.GREEN)
            val radiusWithBorder = min(width - 2 * BORDER_SIZE, (height - 2 * BORDER_SIZE) / colors.size) / 2
            val radius = radiusWithBorder - CIRCLE_BORDER_SIZE
            val rectWidth = 2 * radiusWithBorder
            val rectHeight = 2 * radiusWithBorder * colors.size
            g.color = Color.BLACK
            g.fillRect((size.width - rectWidth) / 2, (size.height - rectHeight) / 2, rectWidth, rectHeight)
            for ((i, color) in colors.withIndex()) {
                val x = size.width / 2 - radius
                val y = size.height / 2 +
                        (2 * (i - colors.size / 2) - colors.size % 2) * radiusWithBorder + CIRCLE_BORDER_SIZE
                g.color = color
                g.fillOval(x, y, 2 * radius, 2 * radius)
            }
        }

        override fun paintComponent(g: Graphics) {
            super.paintComponent(g)
            doDrawing(g as Graphics2D)
        }
    }

    companion object {
        const val BORDER_SIZE = 50
        const val CIRCLE_BORDER_SIZE = 10
    }
}
