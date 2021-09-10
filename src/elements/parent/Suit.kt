package elements.parent

import ResultSuit

open class Suit(var name: String = "") {
    open fun loseTo(): String {
        return ""
    }

    open fun winFrom(): String {
        return ""
    }

    open fun drawFrom(): String {
        return ""
    }

    open fun actionAgainst(suit: Suit): ResultSuit {
        return when (suit.name) {
            winFrom() -> ResultSuit(ResultSuit.WIN)
            loseTo() -> ResultSuit(ResultSuit.LOSE)
            drawFrom() -> ResultSuit(ResultSuit.DRAW)
            else -> ResultSuit(ResultSuit.EMPTY)
        }
    }

}
