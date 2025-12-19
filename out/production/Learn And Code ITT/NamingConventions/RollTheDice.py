import random

def rollDice(numberOfSides):
    return random.randint(1, numberOfSides)


def main():
    numberOfSides = 6
    keepRolling = True

    while keepRolling:
        userInput = input("Ready to roll? Enter Q to Quit: ")

        if userInput.lower() != "q":
            diceResult = rollDice(numberOfSides)
            print("You rolled a", diceResult)
        else:
            keepRolling = False


if __name__ == "__main__":
    main()
