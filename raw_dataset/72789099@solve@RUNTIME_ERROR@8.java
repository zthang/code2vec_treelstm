    void solve(int TC)throws Exception {
        int n = ni();
        ArrayList<Integer>[] age = new ArrayList[1<<B];
        for(int i = 0; i< age.length; i++)age[i] = new ArrayList<>();
        long ans = 0;
        for(int i = 0; i< n; i++){
            int x = ni();
            age[x].add(i);
            ans -= x;
        }
        age[0].add(n);
        int[] set = new int[n+1];
        for(int i = 0; i< set.length; i++)set[i] = i;
        for(int i = -1+(1<<B); i>= 0; i--){
            for(int j = i; j> 0; j = (j-1)&i){
                if(!age[j].isEmpty() && !age[i^j].isEmpty() && find(set, age[j].get(0)) != find(set, age[i^j].get(0))){
                    int fi = age[i^j].get(0), fj = age[j].get(0);
                    set[find(set, fj)] = find(set, fi);
                    ans += i;
                    for(int x:age[j]){
                        if(find(set, x) != find(set, fj)){
                            ans += i;
                            set[find(set, x)] = find(set, fj);
                        }
                    }
                    for(int x:age[i^j]){
                        if(find(set, x) != find(set, fi)){
                            ans += i;
                            set[find(set, x)] = find(set, fi);
                        }
                    }

                    age[j] = new ArrayList<>(1);
                    age[i^j] = new ArrayList<>(1);
                    age[i^j].add(fi);
                    age[j].add(fj);
                }
            }
        }
        pn(ans);
    }