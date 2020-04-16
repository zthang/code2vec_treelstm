public int[] min(int i, int j) {
    int k = log2[j - i + 1];
    int va = val[i][k], vb = val[j - (1 << k) + 1][k];
    if (va <= vb)
        return new int[] { va, idx[i][k] };
    else
        return new int[] { vb, idx[j - (1 << k) + 1][k] };
}