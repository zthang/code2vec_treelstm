public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[m];
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
        a[i] = in.nextInt() - 1;
        b[i] = in.nextInt() - 1;
    }
    if (n < 7) {
        out.println(m);
    } else {
        int max = 0;
        int[] color = new int[7];
        for (int seven = 0; seven < 6; seven++) {
            for (int one = 0; one < 6; one++) {
                for (int two = 0; two < 6; two++) {
                    for (int three = 0; three < 6; three++) {
                        for (int four = 0; four < 6; four++) {
                            for (int five = 0; five < 6; five++) {
                                for (int six = 0; six < 6; six++) {
                                    color[0] = one;
                                    color[1] = two;
                                    color[2] = three;
                                    color[3] = four;
                                    color[4] = five;
                                    color[5] = six;
                                    color[6] = seven;
                                    max = Math.max(max, count(a, b, color));
                                }
                            }
                        }
                    }
                }
            }
        }
        out.println(max);
    }
}