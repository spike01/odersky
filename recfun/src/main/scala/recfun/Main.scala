package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      require(c >= 0 || r >= 0, "Input must be zero or greater")
      if (c == 0 || r == c)
        1
      else
        pascal(c - 1, r - 1) + pascal(c, r - 1)
    }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      balanceAcc(chars, 0)
    }

    def balanceAcc(chars: List[Char], openParens: Int): Boolean = {
      if (chars.isEmpty)
        openParens == 0
      else if (chars.head == '(' && openParens >= 0)
        balanceAcc(chars.tail, openParens + 1)
      else if (chars.head == ')')
        balanceAcc(chars.tail, openParens - 1)
      else
        balanceAcc(chars.tail, openParens)
    }


  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (coins.isEmpty)
        0
      else
        countChangeAcc(money, coins.reverse)
    }

    def countChangeAcc(money: Int, coins: List[Int]): Int = {
      if (money == 0)
        1
      else if (coins.isEmpty || money < 0)
        0
      else
        countChangeAcc(money - coins.head, coins) + countChangeAcc(money, coins.tail)
    }
  }
