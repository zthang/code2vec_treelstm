public int bitremove(int S, int i) {
    return S & (~(1 << i));
}