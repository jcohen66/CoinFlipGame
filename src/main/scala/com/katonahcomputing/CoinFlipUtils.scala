package com.katonahcomputing

import com.katonahcomputing.CoinFlipGame.s
import com.katonahcomputing.domain.GameState

import scala.util.Random

object CoinFlipUtils {
  def showPrompt: Unit = { print("\n(h)eads, (t)ails, (n)ew, or (q)uit: ") }

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
    val i = r.nextInt(2)
    i match {
      case 0 => "H"
      case 1 => "T"
    }
  }
}
