int query(int i, int j) {
    int exp = Integer.highestOneBit(j - i + 1);
    int k = Integer.numberOfTrailingZeros(exp);
    return max(table[k][i], table[k][j - exp + 1]);
}