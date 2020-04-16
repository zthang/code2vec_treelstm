int nextInt() {
    byte c = 0;
    while (c <= 32) c = getc();
    int a = 0;
    while (c > 32) {
        a = a * 10 + c - '0';
        c = getc();
    }
    return a;
}