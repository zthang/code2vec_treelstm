public static void SolveE() {
    Scanner sc = new Scanner(System.in);
    long H = sc.nextLong();
    int n = sc.nextInt();
    int[] d = new int[n];
    long[] par_d = new long[n];
    long min_d = 0;
    for (int i = 0; i < n; i++) {
        d[i] = sc.nextInt();
        if (i == 0) {
            par_d[i] = d[i];
        } else {
            par_d[i] = d[i] + par_d[i - 1];
        }
        if (par_d[i] < min_d) {
            min_d = par_d[i];
        }
    }
    if (H + min_d > 0 && par_d[n - 1] >= 0) {
        pri_result(-1);
    }
    if (H + min_d <= 0) {
        // Wrong test #12
        System.out.println(find_i(-1L * H, par_d));
        // wrong answer on Test #4
        System.exit(0);
    }
    long temp = (H + min_d) / (-1L * par_d[n - 1]);
    long H_temp = H + temp * par_d[n - 1];
    if (H_temp + min_d > 0) {
        temp++;
        H_temp += par_d[n - 1];
    }
    System.out.println(temp * n + find_i(-1L * H_temp, par_d));
}