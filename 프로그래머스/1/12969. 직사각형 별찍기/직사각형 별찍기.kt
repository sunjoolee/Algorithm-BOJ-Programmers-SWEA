fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    
    var row = ""
    for(i in 0 until a){row += '*'}
    for (i in 0 until b){print(row + "\n")}
}