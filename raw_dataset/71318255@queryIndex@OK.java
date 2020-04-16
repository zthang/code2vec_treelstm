int queryIndex(int i, int j) {
    int exp = Integer.highestOneBit(j - i + 1);
    int k = Integer.numberOfTrailingZeros(exp);
    if (table[k][i] > table[k][j - exp + 1])
        return index[k][i];
    return index[k][j - exp + 1];
}