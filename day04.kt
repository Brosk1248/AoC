import java.io.File

const val SUBTASK04 = 2 //tu nastavim, ktory subtask chcem

//asi sa to dalo krajsie nez regexami, ale robila som naraz day3 a day4, v day3 to ocividne chcelo regexy, tak som to cez ne skusila aj tu. enjoy the regex madness

fun main() {
    val input = File("day04.txt").readLines()
    val cols = input[0].length
    val inputText=input.joinToString(separator = "*")
    var occurences = 0
    if(SUBTASK04==1){
        occurences+=Regex("(?=(XMAS))").findAll(inputText).count()
        occurences+=Regex("(?=(SAMX))").findAll(inputText).count()
        occurences+=Regex("""(?=(X.{$cols}M.{$cols}A.{$cols}S))""").findAll(inputText).count()
        occurences+=Regex("""(?=(S.{$cols}A.{$cols}M.{$cols}X))""").findAll(inputText).count()
        occurences+=Regex("""(?=(X.{${cols+1}}M.{${cols+1}}A.{${cols+1}}S))""").findAll(inputText).count()
        occurences+=Regex("""(?=(S.{${cols+1}}A.{${cols+1}}M.{${cols+1}}X))""").findAll(inputText).count()
        occurences+=Regex("""(?=(X.{${cols-1}}M.{${cols-1}}A.{${cols-1}}S))""").findAll(inputText).count()
        occurences+=Regex("""(?=(S.{${cols-1}}A.{${cols-1}}M.{${cols-1}}X))""").findAll(inputText).count()
    }
    if(SUBTASK04==2){
        occurences+=Regex("(?<=M.M.{${cols-1}})A(?=.{${cols-1}}S.S)").findAll(inputText).count()
        occurences+=Regex("(?<=M.S.{${cols-1}})A(?=.{${cols-1}}M.S)").findAll(inputText).count()
        occurences+=Regex("(?<=S.M.{${cols-1}})A(?=.{${cols-1}}S.M)").findAll(inputText).count()
        occurences+=Regex("(?<=S.S.{${cols-1}})A(?=.{${cols-1}}M.M)").findAll(inputText).count()
    }
    println(occurences)
}