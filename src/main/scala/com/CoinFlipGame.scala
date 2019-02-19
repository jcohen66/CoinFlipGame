package com

import com.katonahcomputing.domain.GameState

import scala.util.Random

object CoinFlipGame extends App {

  def showPrompt: Unit = { print("\n(h)eads, (t)ails, or (q)uit: ") }

  def getUserInput = readLine.trim.toUpperCase()

  def printableFlipResult(flip: String) = flip match {
    case "H" => "Heads"
    case "T" => "Tails"
  }

  def printGameState(printableResult: String, gameState: GameState): Unit = {
    print(s"Flip was $printableResult. ")
    printGameState(gameState)
  }

  def printGameState(gameState: GameState): Unit = {
    println(s"Flips: ${gameState.numFlips}, #Correct: ${gameState.numCorrectGuesses}")
  }

  def printGameOver: Unit = println("\n=== GAME OVER ===")

  /**
    * Returns "H" for heads, "T" for tails.
    * @param r
    */
  def tossCoin(r: Random) = {
    val i = r.nextInt()
    i match {
      case 0 => "H"
      case 1 => "T"
    }
  }

  var input = ""

  while (input != "q") {

    // prompt the player to select heads, tails or quit
    // get the player's input
    if(input == "q") {
      // print the game summary
      // quit
    }

    // flip the coin

    // see if the player guessed correctly

    // print the #flips and #correct
  }

}

