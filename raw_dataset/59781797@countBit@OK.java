static int countBit(int mask) {
    int ans = 0;
    while (mask != 0) {
        if (mask % 2 == 1) {
            ans++;
        }
        mask /= 2;
    }
    return ans;
}