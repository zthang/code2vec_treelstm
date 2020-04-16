public boolean contains(int i) {
    if (i < 0 || i >= maxN)
        throw new IllegalArgumentException();
    return qp[i] != -1;
}