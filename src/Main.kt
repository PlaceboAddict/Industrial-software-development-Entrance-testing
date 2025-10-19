import java.io.File

fun main() {
    val file = File("src/input.txt")
    val input: MutableList<MutableList<Int>> = mutableListOf()

    file.forEachLine { line ->
        input.add(line.trim().split(",").map { it.toInt() }.toMutableList())
    }

    println(solve(input))
}


// O(n) time
// O(1) space (because input array is reused)
fun solve(triangle: MutableList<MutableList<Int>>): Int {
    if (triangle.isEmpty()) return 0
    if (triangle.size == 1) return triangle[0][0]

    for (level in triangle.lastIndex - 1 downTo 0) {
        for (i in 0..triangle[level].lastIndex) {
            triangle[level][i] = minOf(triangle[level + 1][i], triangle[level + 1][i + 1]) + triangle[level][i]
        }
    }
    //drawTriangle(triangle)
    return triangle[0][0]
}

@Suppress("unused")
fun drawTriangle(triangle: MutableList<MutableList<Int>>) {
    for (level in triangle) {
        println(level.joinToString(","))
    }
}
