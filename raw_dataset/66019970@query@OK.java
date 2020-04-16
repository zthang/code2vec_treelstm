public T query(int left, int right) {
    int queryLen = right - left + 1;
    int bit = log2.floorLog(queryLen);
    // So x should be right + 1 - 2^bit - left=queryLen - 2^bit
    return merge((T) st[bit][left], (T) st[bit][right + 1 - (1 << bit)]);
}