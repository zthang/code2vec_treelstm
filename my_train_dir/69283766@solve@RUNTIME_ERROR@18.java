        public void solve(int testNumber, FastInput in, FastOutput out) {
            EulerSieve es = new EulerSieve(5000);
            nodes = new Node[5000 + 1];
            for (int i = 1; i <= 5000; i++) {
                nodes[i] = new Node();
                nodes[i].id = i;
            }

            n = in.readInt();
            for (int i = 1; i <= 5000; i++) {
                for (int j = 0; j < limit; j++) {
                    nodes[i].status[j] = countFactor(i, es.get(j));
                }
            }

            for (int i = 0; i < n; i++) {
                int which = in.readInt();
                nodes[which].weight++;
            }
            rec(nodes.clone(), 1, 5000, limit - 1);
            dfs(nodes[1], null);
            Node center = findCenter(nodes[1], null, nodes[1].size);
            int ans = count(center, null, 0);
            out.println(ans);
        }