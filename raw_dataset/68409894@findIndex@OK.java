int findIndex(int cumFreq) {
    int msk = n;
    while ((msk & (msk - 1)) != 0) // msk will contain the MSB of n
    msk ^= msk & -msk;
    int idx = 0;
    while (msk != 0) {
        int tIdx = idx + msk;
        if (tIdx <= n && cumFreq >= ft[tIdx]) {
            idx = tIdx;
            cumFreq -= ft[tIdx];
        }
        msk >>= 1;
    }
    if (cumFreq != 0)
        return -1;
    return idx;
}