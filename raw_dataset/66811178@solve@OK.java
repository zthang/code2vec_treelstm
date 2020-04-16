// int get_room(int i,int j){
// return i/3*3 + j/3;
// }
// int a[][] = new int[9][9];
// int space = 0;
// 
// boolean vis_row[][] = new boolean[9][10];
// boolean vis_col[][] = new boolean[9][10];
// boolean vis_room[][] = new boolean[9][10];
// int val[][][] =new int[9][9][];
// int prepare[][];
// 
// void dfs(int rt){
// 
// }
void solve() {
    int n = ni();
    int[] a = na(n);
    int[] q1 = new int[n];
    int[] d = new int[n];
    Arrays.fill(d, n + 2);
    List<Integer>[] from = new List[n];
    for (int i = 0; i < n; ++i) {
        from[i] = new ArrayList<>();
    }
    for (int u = 0; u < 2; ++u) {
        int s = 0;
        int e = 0;
        for (int i = 0; i < n; ++i) {
            if (a[i] % 2 == u) {
                int ck1 = a[i] + i;
                boolean ok = false;
                if (ck1 < n) {
                    if (a[ck1] % 2 == 1 - u) {
                        d[i] = 1;
                        ok = true;
                    } else {
                        from[ck1].add(i);
                    }
                }
                int ck2 = i - a[i];
                if (ck2 >= 0) {
                    if (a[ck2] % 2 == 1 - u) {
                        d[i] = 1;
                        ok = true;
                    } else {
                        from[ck2].add(i);
                    }
                }
                if (ok) {
                    q1[e++] = i;
                }
            }
        }
        while (s < e) {
            int c = q1[s++];
            for (int ck1 : from[c]) {
                if (d[ck1] > d[c] + 1) {
                    q1[e++] = ck1;
                    d[ck1] = d[c] + 1;
                }
            }
        }
    }
    for (int i = 0; i < n; ++i) {
        if (d[i] == n + 2) {
            d[i] = -1;
        }
    }
    printArray(d, 0);
}