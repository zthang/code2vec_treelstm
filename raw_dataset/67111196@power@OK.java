static long power(long number, long power) {
    if (number == 1 || number == 0 || power == 0)
        return 1;
    if (power == 1)
        return number;
    if (power % 2 == 0)
        return power(number * number, power / 2);
    else
        return power(number * number, power / 2) * number;
}