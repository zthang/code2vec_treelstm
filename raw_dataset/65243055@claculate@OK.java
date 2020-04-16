static int claculate(int n) {
    // calculate 2^(n+1)
    int sum = (1 << (n + 1));
    return sum - 1;
}