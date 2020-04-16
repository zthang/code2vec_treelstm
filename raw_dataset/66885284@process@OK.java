static void process() throws Exception {
    // String bob=")))aaa(R(RaR))R(R(a)))RRaLaa)LRaa(aR))(LaRR(a(a)LaR()R(RR)(RaRa(()aaLLLLL(a)(()R(()LRaaL(L()L))aLa)aaR()R)()L)(RLRa)L()R)RRL)LL)R)aaR()a)RR)aRL())R)R(aL)))R(a(RR)L(Raa)RL)aR(LLaRR(LaLR(L((a(aaRL))aa)RR()LRL)aaa))aaaLaRLLaaa)aa())R)aaL(()a)(aR(LRaR(a)a((aLL(L)RLL)a)(a)LL(LLR)(R((a(()a(LRL(()LRRaaRLLRaR()RR(a(R)a((((L(Raa)aa())a(a(R(aR)L))Ra()RLRL)(L)RaL)LaaaRaR))a)Ra)LL))((aR))LL)(L()R))L(aaR(LRRRaL)L(LaLR)L))RR((aaaL)((L()aL)La(a(R)(aR((RLaLaR)RaRL)))aRaL))RR)L)(()()LaLRaR)((aaaLa)R)aL(RR(Ra(RRaRR";
    // log(bob.length());
    // arrayTest();
    out = new BufferedWriter(new OutputStreamWriter(System.out));
    reader = new InputReader(System.in);
    int time = 0;
    int[] visited = new int[200000];
    int[] stack = new int[200000];
    int T = reader.readInt();
    for (int t = 0; t < T; t++) {
        time++;
        int n = reader.readInt();
        int m = reader.readInt();
        int a = reader.readInt() - 1;
        int b = reader.readInt() - 1;
        ArrayList<Integer>[] friends = new ArrayList[n];
        for (int u = 0; u < n; u++) friends[u] = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            int u = reader.readInt() - 1;
            int v = reader.readInt() - 1;
            friends[u].add(v);
            friends[v].add(u);
        }
        int A = 1;
        int B = 2;
        int AB = 3;
        int[] num = new int[4];
        for (int u = 0; u < n; u++) {
            if (u != a && u != b) {
                int cnt = 1;
                int mask = 0;
                if (visited[u] < time) {
                    int st = 0;
                    stack[st++] = u;
                    visited[u] = time;
                    while (st > 0) {
                        int v = stack[--st];
                        for (int w : friends[v]) {
                            if (visited[w] < time) {
                                if (w == a)
                                    mask |= A;
                                else if (w == b)
                                    mask |= B;
                                else {
                                    stack[st++] = w;
                                    visited[w] = time;
                                    cnt++;
                                }
                            }
                        }
                    }
                    // log("found "+cnt+" with mask:"+Integer.toBinaryString(mask));
                    num[mask] += cnt;
                }
            }
        }
        long na = num[A];
        long nb = num[B];
        output(na * nb);
    }
    try {
        out.close();
    } catch (Exception e) {
    }
}