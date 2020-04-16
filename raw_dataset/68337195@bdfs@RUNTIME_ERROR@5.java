        void bdfs(int u, int pa){
            pq.add(bd[u]);
            for(int v : ja[u]){
                if(v == pa)continue;
                pq.add(d[v] + 1);
            }
            for(int v : ja[u]){
                if(v == pa)continue;
                pq.remove(d[v] + 1);
                bd[v] = pq.peek() + 1;
                pq.add(d[v] + 1);
            }
            pq.clear();
            for(int v : ja[u]){
                if(v == pa)continue;
                bdfs(v, u);
            }
        }