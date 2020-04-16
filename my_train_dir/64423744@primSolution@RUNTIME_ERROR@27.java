    public void primSolution(){
        int n = in.nextInt();
        int m = in.nextInt();
        Map<Integer, Set<Integer>> edges = new HashMap();

        for(int i = 1; i <= m; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            if(!edges.containsKey(u)) edges.put(u, new HashSet());
            edges.get(u).add(v);
                
            if(!edges.containsKey(v)) edges.put(v, new HashSet());
            edges.get(v).add(u);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (int)(a[0]-b[0]));
        pq.offer(new int[]{0, 1});
        Set<Integer> seen = new HashSet();
        long cost = 0; 
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(seen.contains(cur[1])) continue;
            seen.add(cur[1]);
            cost += cur[0];
            for(int i = 1; i <= n ; i++){
                if(seen.contains(i)) continue;
                if(edges.get(cur[1]).contains(i)){
                    pq.offer(new int[]{1, i});
                }else{
                    pq.offer(new int[]{0, i});
                }
            }
        }

        out.println(cost);
        out.flush();
    }