import java.io.File
import kotlin.math.abs

fun main() {
    val input = File("day01.txt").readLines().map { it.split(" ").filter { x -> x.isNotEmpty() } }
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()
    input.forEach { list1.add(it[0].toInt()); list2.add(it[1].toInt()) }
    var counter1 = 0
    list1.sort()
    list2.sort()
    list1.zip(list2).forEach { counter1 += abs(it.first - it.second) }
    var counter2 = 0
    list1.forEach { x -> counter2 += list2.count { it == x } * x }
    //prve cislo je odpoved na prvy subtask, druhe na druhy
    println("$counter1 $counter2")
}
