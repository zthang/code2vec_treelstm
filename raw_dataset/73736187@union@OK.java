void union(int p, int q) {
    int a = root(p);
    int b = root(q);
    if (a != b) {
        cnt--;
    }
    /*if(!belongs[p]&&!belongs[q])cnt++;
            else if(belongs[p]&&belongs[q]){
                if(a!=b)cnt--;
            }
            belongs[p]=belongs[q]=true;*/
    if (a == b) {
        return;
    }
    if (size[a] < size[b]) {
        int temp = a;
        a = b;
        b = temp;
    }
    par[b] = a;
    size[a] += size[b];
    roots.add(a);
    if (roots.contains(b)) {
        roots.remove(b);
    }
}