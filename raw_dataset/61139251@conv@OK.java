public int conv(int a, int b) {
    if (b < a) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    return (a - 1) * 6 + (b - 1);
}