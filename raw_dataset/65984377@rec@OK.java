void rec(int[][] a, int i, int[] dp, int ct, ArrayList<ArrayList<Integer>> al) {
    if (i >= a.length) {
        if (min > ct) {
            min = ct;
            x = new ArrayList<>();
            for (ArrayList<Integer> j : al) {
                ArrayList<Integer> yt = new ArrayList<>();
                for (int k : j) {
                    yt.add(k);
                }
                x.add(yt);
            }
        }
    } else {
        for (int j = 0; j < a.length; j++) {
            if (dp[j] == -1) {
                dp[j] = a[i][0] + a[i][1];
                ArrayList<Integer> f = new ArrayList<Integer>();
                f.add(i);
                al.add(f);
                rec(a, i + 1, dp, ct + 1, al);
                al.remove(al.size() - 1);
                dp[j] = -1;
                break;
            } else {
                if (Math.max(0, dp[j] - a[i][0]) + a[i][1] < 10) {
                    int temp = dp[j];
                    dp[j] = a[i][0] + Math.max(0, dp[j] - a[i][0]) + a[i][1];
                    al.get(j).add(i);
                    rec(a, i + 1, dp, ct, al);
                    al.get(j).remove(al.get(j).size() - 1);
                    dp[j] = temp;
                }
            }
        }
    }
}