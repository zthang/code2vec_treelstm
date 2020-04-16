public int delta(int a, int b) {
    find(a);
    find(b);
    return delta[a] ^ delta[b];
}