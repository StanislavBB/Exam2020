package exam

import java.io.File
import java.io.IOException

fun example(inputName: String): Int {
    if ("ultimate question" in File(inputName).readText().toLowerCase()) {
        return 42
    }
    throw IllegalStateException()
}

// Пожалуйста добавьте необходимые параметры,
// тип результата, и измените имя функции (Shift+F6)
fun correctFile(inputName: String, outputName: String) {
    var file = File(inputName)
    if (!file.exists()) {
        throw IOException("file" + inputName +"not found")
    }
    var lines = file.readLines()
    var writer = File(outputName).bufferedWriter()
    var i = 0
    while (i < lines.size) {
        var line = lines[i]
        if (line.contains("#")) {
            var words = line.split(" ")
            var newWords = mutableListOf<String>()
            for (w in words) {
                if (!w.startsWith("#")) {
                    newWords.add(w)
                }
            }
            line = newWords.joinToString(" ")
        }
        if (line.contains("$$")) {
            val parts = line.split("$$")
            line = parts.joinToString("\n")
        }
        writer.write(line)
        if (i != lines.size - 1) {
            writer.newLine()
        }
        i++
    }
    writer.close()
}