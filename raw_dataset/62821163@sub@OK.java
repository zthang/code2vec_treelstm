int sub(int a, int b) {
    if (a - b < 0)
        return a - b + mod;
    return a - b;
}