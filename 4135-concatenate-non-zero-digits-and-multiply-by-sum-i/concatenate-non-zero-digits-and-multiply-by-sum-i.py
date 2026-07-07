class Solution:
    def sumAndMultiply(self, n):

        s = str(n)

        newNumber = 0
        digitSum = 0

        for ch in s:

            if ch != '0':

                digit = int(ch)

                newNumber = newNumber * 10 + digit
                digitSum += digit

        return newNumber * digitSum