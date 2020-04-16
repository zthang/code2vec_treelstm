int sub(int a, int b) {
    a -= b;
    if (a < 0)
        a += MOD;
    return a;
}