static void process() throws Exception {
    // arrayTest();
    out = new BufferedWriter(new OutputStreamWriter(System.out));
    reader = new InputReader(System.in);
    int k = reader.readInt();
    int[][] list = new int[k][];
    long[] sum = new long[k];
    int[] L = new int[k];
    HashMap<Integer, int[]> target = new HashMap<Integer, int[]>();
    long tot = 0;
    for (int i = 0; i < k; i++) {
        L[i] = reader.readInt();
        list[i] = new int[L[i]];
        for (int j = 0; j < L[i]; j++) {
            list[i][j] = reader.readInt();
            sum[i] += list[i][j];
            target.put(list[i][j], new int[] { i, j });
        }
        tot += sum[i];
    }
    int MX = 1 << k;
    int AX = 1000000001;
    ArrayList<int[]>[] howto = new ArrayList[MX];
    log("ok with the data");
    if (tot % k != 0) {
        output("No");
    } else {
        tot /= k;
        for (int i = 0; i < k; i++) {
            if (sum[i] == tot) {
                // log("nothing to do for i:"+i);
                // nothing to do
                int mask = 1 << i;
                ArrayList<int[]> cand = new ArrayList<int[]>();
                cand.add(new int[] { i, 0 });
                howto[mask] = cand;
            } else
                for (int j = 0; j < L[i]; j++) {
                    int u = i;
                    int v = j;
                    boolean ok = true;
                    int src_u = u;
                    int src_v = v;
                    int mask = 0;
                    boolean goon = true;
                    ArrayList<int[]> cand = new ArrayList<int[]>();
                    // log("start loop");
                    while (goon) {
                        cand.add(new int[] { u, v });
                        // log("u:"+u+" v:"+v);
                        ok = false;
                        goon = false;
                        long need = tot - ((long) sum[u] - (long) list[u][v]);
                        if (Math.abs(need) <= AX) {
                            // log("need:"+need);
                            int nd = (int) need;
                            int[] tm = target.get(nd);
                            // log("tm:"+tm);
                            if (tm != null) {
                                // log("can find successor");
                                int nxu = tm[0];
                                int nxv = tm[1];
                                if ((mask & (1 << nxu)) == 0) {
                                    mask |= 1 << nxu;
                                    if (nxu == src_u) {
                                        // looping back to source
                                        if (nxv == src_v)
                                            ok = true;
                                    } else {
                                        u = nxu;
                                        v = nxv;
                                        ok = true;
                                        goon = true;
                                    }
                                }
                            }
                        }
                    }
                    if (ok) {
                        if (howto[mask] == null) {
                            howto[mask] = cand;
                        }
                    }
                }
        }
        log("step 1 done");
        // now mask
        ArrayList[] components = new ArrayList[MX];
        for (int m = 0; m < MX; m++) {
            if (howto[m] != null) {
                // String s=Integer.toBinaryString(m);
                // while (s.length()<k)
                // s="0"+s;
                // log("found mask:"+s);
                components[m] = new ArrayList<Integer>();
                components[m].add(m);
            }
        }
        int[] msk = new int[MX];
        int w = 0;
        for (int a = 0; a < MX; a++) {
            if (howto[a] != null) {
                ArrayList<Integer> add = new ArrayList<Integer>();
                int ww = w;
                for (int i = 0; i < ww; i++) {
                    int b = msk[i];
                    if ((b & a) == 0) {
                        int c = b | a;
                        log("creating c:" + c + " ");
                        if (components[c] == null) {
                            components[c] = new ArrayList<Integer>();
                            components[c].add(a);
                            components[c].add(b);
                            msk[w++] = c;
                        }
                    }
                }
                msk[w++] = a;
            }
        }
        // log(components[MX-1]);
        if (components[MX - 1] != null) {
            output("Yes");
            int[][] move = new int[k][2];
            explore(components, components[MX - 1], move, howto, list);
            for (int i = 0; i < k; i++) {
                output(move[i][0] + " " + (move[i][1] + 1));
            }
        } else {
            output("No");
        }
    }
    try {
        out.close();
    } catch (Exception e) {
    }
}