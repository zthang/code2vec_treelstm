static long modPower(long number, long power, long mod) {
    if (number == 1 || number == 0 || power == 0)
        return 1;
    number = mod(number, mod);
    if (power == 1)
        return number;
    long square = mod(number * number, mod);
    if (power % 2 == 0)
        return modPower(square, power / 2, mod);
    else
        return mod(modPower(square, power / 2, mod) * number, mod);
}