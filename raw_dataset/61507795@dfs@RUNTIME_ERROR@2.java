        void dfs(int from) {
            for (int v : g[from]) {
                edgeTypes[v] |= color[from];
            }
            for (int v : g[from]) {
                if (color[v] != 0)
                    continue;
                if ((edgeTypes[v] & type1) == 0) {
                    color[v] = type1;
                } else if ((edgeTypes[v] & type2) == 0) {
                    color[v] = type2;
                } else if ((edgeTypes[v] & type3) == 0) {
                    color[v] = type3;
                }
                dfs(v);
            }
        }