public int nextInt() throws IOException {
    int c = br.read();
    while (c <= 32) {
        c = br.read();
    }
    boolean negative = false;
    if (c == '-') {
        negative = true;
        c = br.read();
    }
    int x = 0;
    while (c > 32) {
        x = x * 10 + c - '0';
        c = br.read();
    }
    return negative ? -x : x;
}