static void tr(int c, int n) {
    int t = 0, i, j;
    if (c > n) {
        /*String s1,s2;
            HashMap<String,Integer>map=new HashMap<>();
            for(i=1;i<=n;i++){
                for(j=0;j<adj.get(i).size();j++){
                    s1=a[i]+" "+a[adj.get(i).get(j)];
                    s2=a[adj.get(i).get(j)]+" "+a[i];
                    if(a[i]!=0&&a[adj.get(i).get(j)]!=0&&!map.containsKey(s1)&&!map.containsKey(s2)){
                        ++t;
                        map.put(s1,1);
                        map.put(s2,1);
                    }
                }
            }
            ans=Math.max(ans,t);*/
        co.add(sb.toString());
        return;
    }
    for (i = 1; i <= 6; i++) {
        sb.append(i);
        tr(c + 1, n);
        sb.setLength(sb.length() - 1);
    }
}