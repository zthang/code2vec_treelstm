public static long pow(long a, long pow) {
    return pow == 0 ? 1 : pow % 2 == 0 ? pow(a * a, pow >> 1) : a * pow(a * a, pow >> 1);
}