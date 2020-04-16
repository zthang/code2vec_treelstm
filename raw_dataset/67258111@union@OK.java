public boolean union(int a, int b) {
    if ((a = find(a)) == (b = find(b))) {
        return false;
    }
    if (s[a] == s[b]) {
        s[a]--;
    }
    if (s[a] <= s[b]) {
        s[b] = a;
    } else {
        s[a] = b;
    }
    return true;
}