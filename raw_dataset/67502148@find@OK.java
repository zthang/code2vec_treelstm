int find(int i) {
    return s[i] < 0 ? i : (s[i] = find(s[i]));
}