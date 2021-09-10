import elements.Paper
import elements.Rock
import elements.Scissors
import elements.parent.Suit
import helper.StringContainer

fun main(args: Array<String>) {
    startSuitWithCom()
    println("main lagi? (ketik yes jika pengen)")
    val yes = readLine()
    if (yes == "yes") {
        startSuitWithCom()
    } else {
        println("exit...")
    }
}

private fun startSuitWithCom(): Boolean {
    val paper = Paper("paper")
    val rock = Rock("rock")
    val scissors = Scissors("scissors")

    val resultList: List<Suit> = listOf(paper, rock, scissors)
    val compSuit = resultList.random()

    println("computer milih -> ${compSuit.name}")
    println("input suit (kertas, gunting, batu)")
    var input = readLine().toString()
    var checkInput: Boolean


    // TODO: 07/09/21 "Tugas buat hari kemis, 9/9/21" -> solved this line (use do-while)
    /**
     * Temen2 ngerjakan loop ketika user input selain gunting, batu, kertas
     * User input selain gunting, batu, kertas -> fungsi redline s/d success -> di loop (diulangin)
     * User disuruh input lagi
     * */
    do {
        if (input != "gunting" && input != "kertas" && input != "batu") {
            checkInput = false
            println()
            println("Input salah")
            println("Silahkan input gunting, batu atau kertas")
            println()
            startSuitWithCom()
        } else {
            val mySuit = when (input) {
                "gunting" -> Scissors(StringContainer.scissors)
                "batu" -> Rock(StringContainer.rock)
                "kertas" -> Paper(StringContainer.paper)
                else -> Suit()
            }
            val result = mySuit.actionAgainst(compSuit)
            println("you is ${result.status} | you: ${mySuit.name} vs comp: ${compSuit.name}")
            checkInput = true
        }
    } while (input == "gunting" && input == "batu" && input == "kertas")
    return checkInput
}

private fun checkInput(suit: Suit): Boolean {
    var input1 = Scissors(StringContainer.scissors)
    var input2 = Rock(StringContainer.rock)
    var input3 = Paper(StringContainer.paper)
    var result = true

    if (suit != input1 && suit != input2 && suit != input3) {
        result = false
        println("inputan salah")
    } else {
        result = true
    }
    return result
}


private fun startSuit() {
    println("player 1: silahkan input")
    val input1 = readLine()
    val suit1 = when (input1) {
        "gunting" -> Scissors(StringContainer.scissors)
        "batu" -> Rock(StringContainer.rock)
        "kertas" -> Paper(StringContainer.paper)
        else -> Suit("nothing else")
    }

    if (suit1.name != "nothing else") {
        println("player 2: silahkan input")
        val input2 = readLine()
        val suit2 = when (input2) {
            "gunting" -> Scissors(StringContainer.scissors)
            "batu" -> Rock(StringContainer.rock)
            "kertas" -> Paper(StringContainer.paper)
            else -> Suit("nothing else")
        }

        if (suit2.name != "nothing else") {
            val resultSuit1 = suit1.actionAgainst(suit2)
            val resultSuit2 = suit2.actionAgainst(suit1)

            println("player1 = ${resultSuit1.status}")
            println("player2 = ${resultSuit2.status}")
        } else {
            println("silahkan input kembali")
            startSuit()
        }

    } else {
        println("silahkan input kembali")
        startSuit()
    }
}