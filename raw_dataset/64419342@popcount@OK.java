public int popcount(int i) {
    int ans = 0;
    while (i > 0) {
        ans += i % 2;
        i /= 2;
    }
    return ans;
}