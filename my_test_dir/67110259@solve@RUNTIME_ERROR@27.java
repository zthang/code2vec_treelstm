        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Pair>[] list = new ArrayList[n + 1];
            for (int i = 0 ; i <= n ; i++) {
                list[i] = new ArrayList<Pair>();
            }
            for (int i = 0 ; i < m ; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int cost = in.nextInt();
                Pair p = new Pair(v, cost);                
                boolean exist = false;
                for (int j = 0 ; j < list[u].size() ; j++) {
                    if (list[u].get(j).to == v) {
                        Pair p2 = list[u].get(j);
                        p2.cost += cost;
                        list[u].set(j, p2);
                        exist = true;
                    }
                }
                if (!exist) {
                    list[u].add(p);
                }
            }
            for (int i = 1 ; i <= n ; i++) {
                Collections.sort(list[i], Collections.reverseOrder());
            }
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 0 ; j < list[i].size() ; j++) {
                    Pair pr1 = list[i].get(j);
                    int to1 = pr1.to;
                    int cost1 = pr1.cost;
                    if (cost1 == 0) continue;
                    for (int k = 0 ; k < list[to1].size() ; k++) {
                        Pair pr2 = list[to1].get(k);
                        int to2 = pr2.to;
                        int cost2 = pr2.cost;
                        int finalCost = Math.min(cost1, cost2);
                        pr1.cost -= finalCost;
                        pr2.cost -= finalCost;
                        list[i].set(j, pr1);
                        list[to1].set(k, pr2);
                        if (i != to2 && finalCost > 0) {
                            Pair pr3 = new Pair(to2, finalCost);
                            list[i].add(pr3);
                            // out.println("Adding: " + to2 + " " + finalCost);                            
                        }
                        if (pr1.cost == 0) break;
                    }
                }
            }
            int totalCnt = 0;
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 0 ; j < list[i].size() ; j++) {
                    Pair pr = list[i].get(j);
                    if (pr.cost != 0) {
                        totalCnt += 1;
                    }
                }
            }
            out.println(totalCnt);
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 0 ; j < list[i].size() ; j++) {
                    Pair pr = list[i].get(j);
                    if (pr.cost != 0) {
                        totalCnt += 1;
                        out.println(i + " " + pr.to + " " + pr.cost);
                    }
                }
            }
        }