import java.io.File

const val SUBTASK02 = 1 //tu nastavim, ktory subtask chcem

fun main() {
    val input = File("day02.txt").readLines().map { l -> l.split(" ").map { it.toInt() } }
    println(input.count { safe(it) })
}

fun safe(l : List<Int>) : Boolean {
    if(l.size<2) return true
    for (x in subsets(l)){
        if(x.zip(x.drop(1)).all{it.first-it.second in 1..3} || x.zip(x.drop(1)).all{it.second-it.first in 1..3}) return true
    }
    return false
}

fun subsets(l : List<Int>) : List<List<Int>>{
    val result = mutableListOf<List<Int>>()
    result.add(l)
    if(SUBTASK02==2){
        for (i in l.indices){
            result.add(l.dropLast(l.size-i)+l.drop(i+1))
        }
    }
    return result
}