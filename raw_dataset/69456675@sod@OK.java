int sod(long a) {
    int ans = 0;
    while (a != 0) {
        ans += (a % 10);
        a = a / 10;
    }
    return ans;
}