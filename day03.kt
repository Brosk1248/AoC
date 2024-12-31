import java.io.File

const val SUBTASK03 = 1 //tu nastavim, ktory subtask chcem

fun main() {
    val input = File("day03.txt").readText()
    val regex = Regex("""mul\(([0-9]{1,3}),([0-9]{1,3})\)|do\(\)|don't\(\)""")
    val instructs = regex.findAll(input).toList().map { if(it.value=="do()") true else if(it.value=="don't()") false else it.groupValues[1].toInt() * it.groupValues[2].toInt()}
    var flag = true
    var result = 0
    for(x in instructs){
        if(SUBTASK03==2 && x is Boolean) flag=x
        if (flag && x is Int) result+=x
    }
    println(result)

}