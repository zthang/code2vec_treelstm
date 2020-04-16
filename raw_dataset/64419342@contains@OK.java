public boolean contains(int S, int i) {
    return (S >> i & 1) == 1;
}