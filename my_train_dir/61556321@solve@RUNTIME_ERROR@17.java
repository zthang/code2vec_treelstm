    void solve() throws IOException {
        int n=ni(), m=ni();
        ArrayList<Integer>[]A=new ArrayList[n+1];
        for (int x=1;x<=n;x++) A[x]=new ArrayList();
        for (int x=0;x<m;x++) {
            int p=ni(), q=ni();
            A[p].add(q);
            A[q].add(p);
        }
        
        HashSet<Integer>[] B = new HashSet[3];
        for (int x=0;x<3;x++) B[x]=new HashSet();
        HashSet<Integer> C = new HashSet(A[1]);
        int[]F=new int[n+1];
        B[0].add(1);
        F[1]=1;
        B[1].add(A[1].get(0));
        F[A[1].get(0)]=2;
        HashSet<Integer> D = new HashSet(A[A[1].get(0)]);
        
        
        for (int x=2;x<=n;x++) {
            if (x==A[1].get(0)) continue;
            if (!C.contains(x)) { B[0].add(x); F[x]=1; continue; }
            if (!D.contains(x)) { B[1].add(x); F[x]=2; continue; }
            B[2].add(x);
            F[x]=3;
        }
        
        int[]ss=new int[3];
        ss[0]=B[1].size()+B[2].size();
        ss[1]=B[0].size()+B[2].size();
        ss[2]=B[0].size()+B[1].size();
        
        boolean f=true;
        for (int x=1;x<=n;x++) {
            int cs=F[x]-1;
            for (int y=0;y<A[x].size();y++) if (B[cs].contains(A[x].get(y))) f=false;
            if (A[x].size()!=ss[cs]) f=false;
        }
        
        if (f) {
            for (int x=1;x<=n;x++) out.print(F[x]+" ");
            out.println();
        }
        else out.print("-1");
        
        out.flush();
    }