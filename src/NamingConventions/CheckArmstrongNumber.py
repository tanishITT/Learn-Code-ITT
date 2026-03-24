def calculateArmstrongSum(numberValue):
    digitCount = 0
    tempNumber = numberValue

    # Count digits
    while tempNumber > 0:
        digitCount += 1
        tempNumber //= 10

    # Calculate Armstrong sum
    tempNumber = numberValue
    armstrongSum = 0

    while tempNumber > 0:
        digit = tempNumber % 10
        armstrongSum += digit ** digitCount
        tempNumber //= 10

    return armstrongSum


# User Input
userNumber = int(input("\nPlease enter a number to check for Armstrong: "))

if userNumber == calculateArmstrongSum(userNumber):
    print(f"\n{userNumber} is an Armstrong Number.\n")
else:
    print(f"\n{userNumber} is NOT an Armstrong Number.\n")
