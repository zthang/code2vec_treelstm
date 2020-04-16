public void solve() throws QuickAnswer {
    int n = nextInt();
    boolean[][] passwords = new boolean[n][];
    boolean[] has = new boolean[26];
    for (int i = 0; i < n; i++) {
        boolean[] b = new boolean[26];
        for (char ch : nextString().toCharArray()) {
            b[ch - 'a'] = true;
            has[ch - 'a'] = true;
        }
        passwords[i] = b;
    }
    int[] colors = new int[26];
    int color = 0;
    for (int i = 0; i < 26; ++i) {
        if (!has[i])
            continue;
        if (colors[i] != 0)
            continue;
        colors[i] = ++color;
        for (int j = i; j < 26; j++) {
            if (colors[j] != color)
                continue;
            for (boolean[] b : passwords) {
                if (!b[j])
                    continue;
                for (int k = 0; k < 26; k++) {
                    if (b[k])
                        colors[k] = color;
                }
            }
        }
    }
    print(color);
}