public static void SolveB() {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
        int n = sc.nextInt();
        char[][] p = new char[n][4];
        int[] p1 = new int[n];
        HashSet<Integer> ap = new HashSet();
        HashSet<Integer> ap1 = new HashSet();
        int changes = 0;
        for (int j = 0; j < n; j++) {
            p[j] = sc.next().toCharArray();
            p1[j] = calpc(p[j]);
            ap.add(p1[j]);
            ap1.add(p1[j]);
        }
        for (int j = 0; j < n; j++) {
            if (ap1.contains(p1[j])) {
                ap1.remove(p1[j]);
                continue;
            }
            changes++;
            // change each digit up or down
            for (int k = 0; k < 4; k++) {
                // change digit k
                char savec = p[j][k];
                p[j][k] = upp(p[j][k]);
                int pcnew = calpc(p[j]);
                if (!ap.contains(pcnew)) {
                    ap.add(pcnew);
                    break;
                }
                p[j][k] = upp(p[j][k]);
                pcnew = calpc(p[j]);
                if (!ap.contains(pcnew)) {
                    ap.add(pcnew);
                    break;
                }
                p[j][k] = savec;
                if (p[j][k] == '0') {
                    p[j][k] = '9';
                } else
                    p[j][k]--;
                pcnew = calpc(p[j]);
                if (!ap.contains(pcnew)) {
                    ap.add(pcnew);
                    break;
                }
                p[j][k] = savec;
            }
        }
        System.out.println(changes);
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < 4; k++) System.out.print(p[j][k]);
            System.out.println();
        }
    }
    System.exit(0);
}