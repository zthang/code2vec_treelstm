static void check(boolean[] b) {
    for (int k = 0; k < 26; k++) {
        for (int l = k + 1; l < 26; l++) {
            if (b[k] && b[l] && find(l) != find(k)) {
                union(find(l), find(k));
            }
        }
    }
}