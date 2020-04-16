public long getFact(int n) {
    if (factorial == null)
        setFactorial();
    return factorial[n];
}