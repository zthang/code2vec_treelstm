static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    int t = ni();
    while (t-- > 0) {
        int n = ni(), m = ni();
        long sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += ni();
        }
        if (m < n || n == 2) {
            pl(-1);
        } else {
            pl(sum * 2);
            for (int i = 1; i < n; ++i) {
                pl(i + " " + (i + 1));
            }
            pl("1 " + n);
        }
    }
    pw.flush();
    pw.close();
}