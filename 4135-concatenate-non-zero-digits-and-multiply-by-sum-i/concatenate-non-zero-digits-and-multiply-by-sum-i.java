class Solution {
    public long sumAndMultiply(int n) {

        if (n == 0) return 0;

        long newNumber = 0;
        long place = 1;
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;

            if (digit != 0) {
                newNumber += digit * place;
                place *= 10;
                sum += digit;
            }

            n /= 10;
        }

        return newNumber * sum;
    }
}