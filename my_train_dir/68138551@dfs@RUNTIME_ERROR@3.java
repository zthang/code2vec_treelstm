   static void dfs(int node, int par) {
      if (!vis.contains(node)) {
         vis.add(node);
         for (int adj : adjList[node]) {
            if (adj != par) {
               if (vis.contains(adj)) {
                  poss = false;
               } else {
                  dfs(adj, node);
               }
            }
         }
      }
   }