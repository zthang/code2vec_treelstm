public static IntegerMultiWayStack factorizeRangePrime(int n) {
    int maxFactorCnt = (int) MinimumNumberWithMaximumFactors.maximumPrimeFactor(n)[1];
    IntegerMultiWayStack stack = new IntegerMultiWayStack(n + 1, n * maxFactorCnt);
    boolean[] isComp = new boolean[n + 1];
    for (int i = 2; i <= n; i++) {
        if (isComp[i]) {
            continue;
        }
        for (int j = i; j <= n; j += i) {
            isComp[j] = true;
            stack.addLast(j, i);
        }
    }
    return stack;
}