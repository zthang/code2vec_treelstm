int count() {
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        if (i == find(i))
            cnt++;
    }
    return cnt;
}