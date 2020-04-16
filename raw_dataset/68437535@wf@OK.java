void wf(String str) {
    boolean[] use = new boolean[26];
    for (int i = 0; i < str.length(); i++) {
        use[str.charAt(i) - 'a'] = true;
        a[str.charAt(i) - 'a'] = true;
    }
    for (int i = 0; i < 26; i++) {
        for (int j = 0; j < 26; j++) {
            if (use[i] && use[j]) {
                c[i][j] = true;
            }
        }
    }
}