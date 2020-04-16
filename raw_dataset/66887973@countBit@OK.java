static int countBit(long mask) {
    int ans = 0;
    while (mask != 0) {
        mask &= (mask - 1);
        ans++;
    }
    return ans;
}