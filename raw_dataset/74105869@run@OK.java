/*Code lies here*/
@Override
public void run() {
    int t = in.nextInt(), n;
    HashSet<Integer> set = new HashSet();
    int k, y, ind, small;
    int[] res;
    while (t-- > 0) {
        n = in.nextInt();
        res = new int[n];
        for (int i = 0; i < n; i++) {
            k = in.nextInt();
            small = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                y = in.nextInt();
                if (!set.contains(y)) {
                    small = min(small, y);
                }
            }
            set.add(small);
            res[i] = small;
        }
        ind = -1;
        for (int i = 0; i < n; i++) if (res[i] == Integer.MAX_VALUE) {
            ind = i;
            break;
        }
        if (ind == -1)
            appn("OPTIMAL");
        else {
            app("IMPROVE\n" + (ind + 1) + " ");
            for (int i = 1; i <= n; i++) if (!set.contains(i)) {
                ind = i;
                break;
            }
            appn(ind);
        }
        set.clear();
    }
    pn(ans);
}