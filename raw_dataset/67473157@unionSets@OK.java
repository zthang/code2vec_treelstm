public void unionSets(int a, int b) {
    a = findSet(a);
    b = findSet(b);
    if (a != b) {
        parent[b] = a;
        for (int i = 0; i < 26; i++) {
            values[a][i] |= values[b][i];
        }
    }
}