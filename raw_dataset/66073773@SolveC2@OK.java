public static void SolveC2() {
    PrintWriter out = new PrintWriter(System.out);
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int n;
    for (int i = 0; i < t; i++) {
        n = sc.nextInt();
        int total = 3;
        ArrayList<Integer> f = new ArrayList();
        ArrayList<Integer> b = new ArrayList();
        f.add(0);
        f.add(1);
        b.add(n);
        if (n == 1) {
            total = 2;
            out.println(total);
            out.println("0 1");
            continue;
        }
        int mid = (int) Math.round(Math.sqrt(1.0 * n));
        int low = 1;
        int upp = n;
        for (int j = 2; j <= mid; j++) {
            if (j * j > n)
                break;
            if (j * j == n) {
                f.add(j);
                break;
            }
            int new_upp = n / j;
            if (new_upp < upp) {
                if (new_upp > j) {
                    f.add(j);
                    b.add(new_upp);
                    upp = new_upp;
                } else {
                    if (new_upp == j) {
                        f.add(j);
                        break;
                    }
                }
            }
        }
        out.println(f.size() + b.size());
        for (int j = 0; j < f.size(); j++) out.print(f.get(j) + " ");
        for (int j = b.size() - 1; j >= 0; j--) {
            out.print(b.get(j));
            if (j > 0)
                out.print(" ");
        }
        out.println();
    }
    out.close();
    System.exit(0);
}