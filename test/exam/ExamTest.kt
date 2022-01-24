package exam

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.File
import java.io.IOException

internal class ExamTest {

    @Test
    fun testExample() {
        assertEquals(42, example("input/example.txt"))
    }

    private fun assertFileContent(name: String, expectedContent: String) {
        val file = File(name)
        val content = file.readLines().joinToString("\n")
        assertEquals(expectedContent, content)
    }

    @Test
    fun testcorrectFile() {
        val outFilesName = "output/correctFile.txt"

        assertThrows(IOException::class.java) { correctFile("missing file", outFilesName)}

        correctFile("input/correctFile.txt", outFilesName)
        assertFileContent(outFilesName, "А роза упала на лапу Азора.\nБуратино не любит ходить в школу.")
    }

}