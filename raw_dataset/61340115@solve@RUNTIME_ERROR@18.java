    static void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
        for (int ii = 0; ii < testNumber; ii++) {
            int n = in.nextInt(), m = in.nextInt();
            if (m < 7) {
                System.out.println(m);
                return;
            }
            int[][] graph = new int[n][n];
            int[] dominos = {6, 6, 6, 6, 6, 6};
            for (int i = 0; i < m; i++) {
                int a = in.nextInt()-1;
                int b = in.nextInt()-1;
                graph[a][b] = graph[b][a]= 1;
            }
            int ans = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = i+1; j < 7; j++) {
                    if (graph[i][j] == 1 && j < 6) {
                        ans++;
                        dominos[i]--;
                        dominos[j]--;
                    }
                }
            }
            Arrays.sort(dominos);
            int ones = 0;
            for (int i = 0; i < graph[6].length; i++) {
                if(graph[6][i]==1) ones++;
            }
            ans+=Math.min(dominos[5],ones);
            System.out.println(ans);
        }
    }