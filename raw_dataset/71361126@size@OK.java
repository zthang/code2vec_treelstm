public int size() {
    int ans = epos - bpos;
    if (ans < 0) {
        ans += data.length;
    }
    return ans;
}