public static long factorial(long a) {
    return a == 0 || a == 1 ? 1 : a * factorial(a - 1);
}