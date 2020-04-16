public boolean union(int a, int b) {
    if ((a = find(a)) == (b = find(b))) {
        return false;
    }
    if (s[a] == s[b]) {
        s[a]--;
    }
    if (s[a] <= s[b]) {
        s[b] = a;
        min[a] = Math.min(min[b], min[a]);
        max[a] = Math.max(max[b], max[a]);
    } else {
        s[a] = b;
        min[b] = Math.min(min[b], min[a]);
        max[b] = Math.max(max[b], max[a]);
    }
    return true;
}