import kotlin.math.*
data class Match(val scoreTeam1: Int,val scoreTeam2: Int ) //создали класс с матчем

fun inputScore():Match{ // функция возвращающая обьект с заполнеными полями случайными числами от 0 до 5
    val score1 = (0..5).random()
    val score2 = (0..5).random()
    return Match(score1,score2)
}
fun main() {//Создаем массив типа Match  размерностью 10
    val arrayMatch = Array(10) { Match(0, 0) }
    for (n in 0 until arrayMatch.size ) { // с помощью цикла  и  функции добавления значения обьекта
        arrayMatch[n] = inputScore()// присваиваем значение элементам массива
        println("Array element $n  ${arrayMatch[n]} ")// выводим значения в консоль
    }
    val newArr: Array<Match?> = arrayOfNulls(10) //создаем новый массив где отсутствуют ничьи
    var c = 0 //счетчик для к-ва матчей подходящих под условия
    println(" Array after deleting teams with the same score")
    for (n in arrayMatch) {//цикл по первому массиву
        if (n.scoreTeam1 != n.scoreTeam2) {// если счет не равен то
            newArr[c] = n                  // новому массиву присваивается значение из старого элемента
            println("Element  $n ")
            c++// увеличиваем счетчик
        }
    }
    val s = mutableSetOf<Int>() //создаем множество Set

    for (n in newArr) { // перебираем элементы массива
      if(n == null) continue// если элемент равен null то пропускаем одну итерацию
      else  s.add(abs(n.scoreTeam1 - n.scoreTeam2)) //иначе  находим модуль разности команд в матче и
    }                                             // записываем значения в множество
    println("Value set $s") // выводим множество на консоль
// я не особо понял условие  где создать множество с максимальным разрывом в очках
    var k = s.maxOrNull()// поэтому оставляю только макс значение из функции
    s.clear() //удаляю все элементы множества
    if (k != null) s.add(k)// проверяю есть ли значение в переменной если да то добавляю в множество
    println("Max $s")
}
