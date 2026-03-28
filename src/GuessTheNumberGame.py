import random

def is_valid_guess(value):
    return value.isdigit() and 1 <= int(value) <= 100

def get_guess():
    return input("Guess a number between 1 and 100: ")

def play_game():
    target = random.randint(1, 100)
    guesses = 0

    while True:
        guess = get_guess()

        if not is_valid_guess(guess):
            print("Invalid input. Please enter a number between 1 and 100.")
            continue

        guess = int(guess)
        guesses += 1

        if guess < target:
            print("Too low.")
        elif guess > target:
            print("Too high.")
        else:
            print(f"You guessed it in {guesses} guesses!")
            break

play_game()
