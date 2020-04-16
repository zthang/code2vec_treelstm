void run(FastIO io) {
    int t = io.nextInt();
    long a, m;
    long sum;
    StringBuilder sb;
    for (int i = 0; i < t; i++) {
        a = io.nextInt();
        m = io.nextInt();
        sum = 0;
        sb = new StringBuilder();
        for (int j = 1; j < a; j++) {
            sum += io.nextLong() * 2;
            sb.append(j + " " + (j + 1) + "\r\n");
        }
        sum += io.nextLong() * 2;
        sb.append(1 + " " + a);
        if (a > 2 && m == a)
            io.println(sum + "\r\n" + sb.toString());
        else
            io.println(-1);
    }
}