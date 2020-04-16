int fix() {
    int cnt = 0;
    Arrays.sort(set, 0, end);
    for (int i = 0; i < end; i++) map[set[i]] = ++cnt;
    return cnt;
}