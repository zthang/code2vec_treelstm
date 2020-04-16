public static String doMain(Reader reader) throws IOException {
    MyReader in = new MyReader(reader);
    int tests = in.nextInt();
    StringBuilder sb = new StringBuilder();
    for (int t = 0; t < tests; t++) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] ropes = in.readIntArray(n);
        int price = 0;
        if (m < n || n < 3) {
            sb.append(-1).append("\n");
        } else {
            for (int i : ropes) {
                price += i * 2;
            }
            m -= n;
            for (int i = 0; i < m; ++i) {
                price += ropes[0] + ropes[1];
            }
            StringBuilder curr = new StringBuilder();
            sb.append(price).append("\n");
            for (int i = 0; i < n - 1; i++) {
                sb.append((i + 1) + " " + (i + 2)).append("\n");
            }
            sb.append(1 + " " + n).append("\n");
            int min1 = 100000000, min2 = 1000000000;
            int i;
            for (i = 0; i < n; ++i) {
                min1 = Math.max(min1, ropes[i]);
            }
            for (i = 0; i < n; ++i) {
                min2 = Math.max(min2, ropes[i]);
            }
            for (int j = 0; j < m - n; ++j) {
                sb.append((min1 + 1) + " " + (min2 + 1)).append("\n");
            }
        }
    }
    return sb.toString();
}