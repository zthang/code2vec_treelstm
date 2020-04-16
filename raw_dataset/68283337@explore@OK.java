static int explore(int u, int base) {
    // log("==== exploring :"+(u+1));
    int ref = base;
    if (below[u] == 0)
        base++;
    if (below[u] > sub[u] - 1)
        return -1;
    if (sub[u] == 1) {
        ar[u] = base;
        // log("explore:"+(u+1)+" returning:"+base);
        return base;
    }
    for (int v : friends[u]) {
        int ans = explore(v, base);
        if (ans == -1) {
            log("problem");
            return -1;
        }
        base = ans + 1;
    }
    st = 0;
    populate(u);
    Arrays.parallelSort(stack, 0, sub[u] - 1);
    if (below[u] > 0) {
        int thre = stack[below[u] - 1];
        // log(ar);
        // log("u:"+(u+1)+" thre:"+thre);
        adjust(u, thre);
        ar[u] = thre + 1;
        base++;
    } else {
        ar[u] = ref;
    }
    // log("explore:"+(u+1)+" returning:"+base);
    return base;
}