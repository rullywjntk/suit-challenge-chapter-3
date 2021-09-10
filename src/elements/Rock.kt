package elements

import helper.StringContainer
import elements.parent.Suit

class Rock(name: String) : Suit(name) {

    override fun loseTo(): String {
        return StringContainer.paper
    }

    override fun winFrom(): String {
        return StringContainer.scissors
    }

    override fun drawFrom(): String {
        return this.name
    }
}