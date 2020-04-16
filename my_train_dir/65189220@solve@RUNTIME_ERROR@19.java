        public void solve(int testNumber, FastInput in, FastOutput out) {
            int n = in.readInt();
            int m = in.readInt();

            TaskD.Node[] nodes = new TaskD.Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new TaskD.Node();
                nodes[i].l = nodes[i].r = i;
            }

            int[][] edges = new int[m][2];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 2; j++) {
                    edges[i][j] = in.readInt();
                }
            }

            for (int[] e : edges) {
                TaskD.Node.merge(nodes[e[0]], nodes[e[1]]);
            }

            int cc = 0;
            for (int i = 0; i < n; i++) {
                if (nodes[i].find() == nodes[i]) {
                    cc++;
                }
            }

            for (int i = 0; i < n; i++) {
                nodes[i].init();
            }

            for (int[] e : edges) {
                TaskD.Node a = nodes[e[0]].find();
                TaskD.Node b = nodes[e[1]].find();
                if (a.l > b.l) {
                    TaskD.Node tmp = a;
                    a = b;
                    b = tmp;
                }

                while (a.r < b.l) {
                    TaskD.Node next = nodes[a.r + 1].find();
                    a.r = next.r;
                    TaskD.Node.merge(a, next);
                }
            }

            int curCC = 0;
            for (int i = 0; i < n; i++) {
                if (nodes[i].find() == nodes[i]) {
                    curCC++;
                }
            }

            out.println(cc - curCC);
        }