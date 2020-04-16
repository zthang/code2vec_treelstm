void print2(int[] c, int n) {
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < 3; ++j) {
        for (int i = 0; i < n; ++i) {
            sb.appendCodePoint(c[j] + 'a');
        }
    }
    println(sb);
}