    void solve(){
        int u =1;
       while(u-->0){
           int n = ni();
           if(lenbuf==-1) return;
           int k = ni();
           Set<String> st = new HashSet<>();
           String s[] = new String[n];
           for(int j=0;j<n;++j){
               s[j] = ns();
               st.add(s[j]);
           }
            int r = 0;
           for(int j=0;j<n;++j){
               for(int l=j+1;l<n;++l){
                   StringBuilder sb = new StringBuilder();
                   for(int c=0;c<k;++c){
                       if(s[j].charAt(c)==s[l].charAt(c)){
                           sb.append(s[j]);
                       }else{
                           sb.appendCodePoint('S'+'E'+'T'-s[j].charAt(c)-s[l].charAt(c));
                       }
                   }
                   if(st.contains(sb.toString())){
                       r++;
                   }
               }
           }
            println(r/3);





       }




    }