        public void solve(int testNumber, FastInput in, FastOutput out) {
            int n = in.readInt();
            LCTNode[] nodes = new LCTNode[n + 1];
            for (int i = 1; i <= n; i++) {
                nodes[i] = new LCTNode();
                nodes[i].id = (int) 1e7;
            }

            LCTNode[] edges = new LCTNode[n];
            int[][] t1 = new int[n][2];
            for (int i = 1; i < n; i++) {
                edges[i] = new LCTNode();
                edges[i].id = i;

                t1[i][0] = in.readInt();
                t1[i][1] = in.readInt();

                LCTNode.join(nodes[t1[i][0]], edges[i]);
                LCTNode.join(nodes[t1[i][1]], edges[i]);
            }

            out.println(n - 1);
            for (int i = 1; i < n; i++) {
                int a = in.readInt();
                int b = in.readInt();
                LCTNode.findRoute(nodes[a], nodes[b]);
                LCTNode.splay(nodes[a]);
                LCTNode replace = nodes[a].minIdNode;
                replace.pushUp();

                out.append(t1[replace.id][0]).append(' ').append(t1[replace.id][1])
                        .append(' ').append(a).append(' ').append(b).println();

                LCTNode.cut(replace, nodes[t1[replace.id][0]]);
                LCTNode.cut(replace, nodes[t1[replace.id][1]]);
                LCTNode.join(nodes[t1[replace.id][0]], nodes[t1[replace.id][1]]);
            }
        }