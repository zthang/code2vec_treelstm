public int digit(long i) {
    int ans = 1;
    while (i >= 10) {
        i /= 10;
        ans++;
    }
    return ans;
}