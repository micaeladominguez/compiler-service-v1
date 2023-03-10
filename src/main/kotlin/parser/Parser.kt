package parser

import lexer.Token

interface Parser {
    fun getABL(tokens: ArrayList<Token> ) : Node
}