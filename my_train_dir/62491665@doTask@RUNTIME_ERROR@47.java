    public static void doTask(){
        int  n = sc.nextInt();
        int[][] cost = new int[n][3];

        for (int i=0; i<3; i++) {
            for (int j = 0;j < n; j++) {
                cost[j][i] = sc.nextInt();
            }
        }

        int[][] neigbs = new int[n+1][3];
        int[] number = new int[n+1];

        boolean can = true;
        for (int i=0; i<n-1; i++) {
            int u = sc.nextInt()-1, v = sc.nextInt()-1;
            neigbs[u][number[u]] = v;
            neigbs[v][number[v]] = u;
            number[u]++;
            number[v]++;
            if (number[u] == 3 || number[v] == 3) {
                can = false;
                break;
            }
        }

        if (can) {
            int first = 0;
            while (number[first]>1) first++;

            int[] idx = new int[n];
            boolean[] used = new boolean[n];
            used[first] = true;
            int index = 0;
            while (index<n) {
                idx[index] = first;
                index++;
                if (index<n) {
                    first = !used[neigbs[first][0]] ? neigbs[first][0] : neigbs[first][1];
                    used[first] = true;
                }
            }

            int bestOpts = -1;
            long minResut = 1_000_000_000_000_000_000L;
            for (int j=0; j<n; j++) {
                int[] opt = opts[j];
                long res = 0;

                int optIdx = 0;
                for (int i=0; i<n; i++) {
                    int v = idx[i];
                    res += cost[v][opt[optIdx]];
                    optIdx++;
                    if (optIdx == 3) optIdx = 0;
                }

                if (res < minResut) {
                    minResut = res;
                    bestOpts = j;
                }
            }

            out.println(minResut);
            for (int i=0; i<n; i++) {
                int resIdx = opts[bestOpts][idx[i]%3] + 1;
                out.print( resIdx+ " ");
            }
        } else {
            out.println(-1);
        }
    }