import random

def isValidGuess(userInput):
    return userInput.isdigit() and 1 <= int(userInput) <= 100


def main():
    secretNumber = random.randint(1, 100)
    hasGuessedCorrectly = False
    guessCount = 0

    userGuess = input("Guess a number between 1 and 100: ")

    while not hasGuessedCorrectly:

        if not isValidGuess(userGuess):
            userGuess = input("Invalid! Enter a number between 1 and 100: ")
            continue
        else:
            guessCount += 1
            userGuess = int(userGuess)

        if userGuess < secretNumber:
            userGuess = input("Too low. Guess again: ")
        elif userGuess > secretNumber:
            userGuess = input("Too high. Guess again: ")
        else:
            print("You guessed it in", guessCount, "guesses!")
            hasGuessedCorrectly = True


main()
