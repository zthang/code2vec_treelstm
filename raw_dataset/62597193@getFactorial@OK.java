public long getFactorial(int n) {
    if (factorial == null)
        setFactorial();
    return factorial[n];
}