package elements

import elements.parent.Suit
import helper.StringContainer

class Scissors(name: String) : Suit(name) {

    override fun loseTo(): String {
        return StringContainer.rock
    }

    override fun winFrom(): String {
        return StringContainer.paper
    }

    override fun drawFrom(): String {
        return this.name
    }

}