int digit(long s) {
    int ans = 0;
    while (s > 0) {
        s /= 10;
        ans++;
    }
    return ans;
}