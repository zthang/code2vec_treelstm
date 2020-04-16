private static long[] solveGcdEquation(long a, long b) {
    if (b == 0) {
        return new long[] { 1, 0, a };
    }
    long[] res = solveGcdEquation(b, a % b);
    return new long[] { res[1], res[0] - (a / b) * res[1], res[2] };
}