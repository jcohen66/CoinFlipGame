package com.katonahcomputing

import com.katonahcomputing.domain.GameState
import com.katonahcomputing.CoinFlipUtils._

import scala.annotation.tailrec
import scala.util.Random

object CoinFlipGame extends App {


  val s = GameState(0,0)
  val r = new Random()
  mainLoop(s, r)


  @tailrec
  def mainLoop(gameState: GameState, random: Random) {

    // a) prompt the user for input
    showPrompt

    // b) get the user's input
    val userInput = getUserInput

    // Handle the result
    userInput match {
      case "H" | "T" => {

        // c) flip the coin
        val coinTossResult = tossCoin(random)
        val newNumFlips = gameState.numFlips + 1

        // d) compare the flip result to the user's input
        if(userInput == coinTossResult) {
          // they guessed right
          // e) write the output
          // f) if the user didnt type 'h', loop again
          val newNumCorrectGuesses = gameState.numCorrectGuesses + 1
          val newGameState = gameState.copy(newNumFlips, newNumCorrectGuesses)
          printGameState(printableFlipResult(coinTossResult),newGameState)
          mainLoop(newGameState, random)
        } else {
          // they guessed wrong
          // e) write the output
          // f) if the user didnt type 'h', loop again
          val newNumCorrectGuesses = gameState.numCorrectGuesses
          val newGameState = gameState.copy(newNumFlips, newNumCorrectGuesses)
          printGameState(printableFlipResult(coinTossResult),newGameState)
          mainLoop(newGameState, random)
        }
      }
      case _ => {
        printGameOver
        printGameState(gameState)
        // return out of recursion here.
      }

    }


  }





}
