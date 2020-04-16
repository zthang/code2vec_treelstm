public static void sliding() {
    int n = Integer.parseInt(in.next());
    int k = Integer.parseInt(in.next());
    int[] z = new int[n];
    for (int i = 0; i < n; i++) {
        z[i] = Integer.parseInt(in.next());
    }
    int wind = 0;
    for (int i = 0; i < k; i++) {
        wind += z[i];
    }
    int max = wind;
    for (int i = k; i < n; i++) {
        wind += z[i];
        wind -= z[i - k];
        max = Math.max(max, wind);
    }
    System.out.println(max);
}