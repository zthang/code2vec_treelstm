    public static boolean dfs(GraphNode parent, int[] res, int[] visited, HashMap<Integer,Integer>[] edges) {
        boolean cycle = false;
        visited[parent.index] = 1;
        for (GraphNode child : parent.children) {
            if (visited[child.index] == 0) {
                if(dfs(child, res, visited, edges))
                    cycle = true;
                res[edges[parent.index].get(child.index)]=1;
            }
            else if (visited[child.index] == 1){
                res[edges[parent.index].get(child.index)]=2;
                cycle = true;
            }
            else
                res[edges[parent.index].get(child.index)]=1;

        }
        visited[parent.index] = 2;
        return cycle;
    }