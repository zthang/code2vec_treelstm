void print1(int[] c, int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < 3; ++j) {
            sb.appendCodePoint(c[j] + 'a');
        }
    }
    println(sb);
}