public static void SolveA() {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int[] r = new int[t];
    int[] g = new int[t];
    int[] b = new int[t];
    for (int i = 0; i < t; i++) {
        r[i] = sc.nextInt();
        g[i] = sc.nextInt();
        b[i] = sc.nextInt();
    }
    for (int i = 0; i < t; i++) {
        int answer;
        // answer = Math.min( r[i] + g[i], b[i]);
        // answer = Math.max (answer,
        // Math.min(r[i] + b[i], g[i])
        // );
        // answer = Math.max (answer,
        // Math.min(g[i] + b[i], r[i])
        // );
        int[] a = new int[3];
        a[0] = r[i];
        a[1] = g[i];
        a[2] = b[i];
        Arrays.sort(a);
        // make a[1] the same as a[2]
        if (a[0] + a[1] <= a[2]) {
            System.out.println(a[0] + a[1]);
        } else {
            a[0] -= a[2] - a[1];
            System.out.println(a[0] / 2 + a[2]);
        }
    // System.out.println( Math.max(answer, answer1));
    }
    System.exit(0);
}