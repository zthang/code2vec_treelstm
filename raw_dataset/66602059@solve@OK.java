public void solve(int testNumber, InputReader in, PrintWriter out) {
    int k = in.nextInt();
    int[][] a = new int[k][];
    int[] n = new int[k];
    long[] sum = new long[k];
    long S = 0;
    for (int i = 0; i < k; i++) {
        n[i] = in.nextInt();
        a[i] = new int[n[i]];
        for (int j = 0; j < n[i]; j++) {
            a[i][j] = in.nextInt();
            sum[i] += a[i][j];
            map.put(a[i][j], i);
        }
        S += sum[i];
    }
    if (S % k != 0)
        out.println("No");
    else {
        ArrayList<boxPair>[] maskPath = new ArrayList[two(k)];
        boolean[] hasCycle = new boolean[two(k)];
        for (int i = 0; i < two(k); i++) {
            maskPath[i] = new ArrayList<>();
        }
        long balance = S / k;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n[i]; j++) {
                long remove = a[i][j];
                int curID = i;
                int curMask = 0;
                ArrayList<boxPair> curPath = new ArrayList<>();
                while (true) {
                    curMask |= two(curID);
                    remove = (balance - (sum[curID] - remove));
                    int nxtID = get(remove);
                    curPath.add(new boxPair(curID, (int) remove));
                    if (nxtID == i && remove == a[i][j]) {
                        if (hasCycle[curMask] == false) {
                            hasCycle[curMask] = true;
                            maskPath[curMask] = curPath;
                        }
                        break;
                    }
                    if (nxtID == -1 || contain(curMask, nxtID))
                        break;
                    curID = nxtID;
                }
            }
        }
        vis = new boolean[two(k)];
        dp = new boolean[two(k)];
        if (rec(two(k) - 1, hasCycle) == false)
            out.println("No");
        else {
            ans = new boxPair[k];
            findPath(two(k) - 1, hasCycle, maskPath);
            out.println("Yes");
            for (int i = 0; i < k; i++) {
                out.println(ans[i].addTo + " " + (ans[i].boxID + 1));
            }
        }
    }
}