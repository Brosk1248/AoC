import java.io.File

const val SUBTASK05 = 2 //tu nastavim, ktory subtask chcem

//moc efektivne to nie je, ale pri tak malej velkosti vstupu to je jedno

fun main() {
    val input = File("day05.txt").readLines()
    val split = input.indexOf("")
    val conditions = input.subList(0, split).map { Pair(it.split("|")[0].toInt(), it.split("|")[1].toInt()) }
    val updates = input.subList(split+1, input.size).map { it2 -> it2.split(",").map { it.toInt() } }
    fun isCorrect(update: List<Int>): Boolean{
        for(x in conditions){
            if(x.first in update && x.second in update && update.indexOf(x.second)<update.indexOf(x.first)) return false
        }
        return true
    }
    var sum = if(SUBTASK05==1) updates.filter { isCorrect(it) }.sumOf { it[it.size/2] } else if(SUBTASK05==2) updates.filter { !isCorrect(it) }.map { it.sortedWith { i: Int, i1: Int -> if (Pair(i,i1) in conditions) 1 else -1 } }.sumOf { it[it.size/2] } else 0
    println(sum)
}
