void merge(int x, int y) {
    int i = 0;
    int j = 0;
    ArrayList<Long> tmp = new ArrayList<>();
    while (i < a[x].size() && j < a[y].size()) {
        long get1 = (long) a[x].get(i);
        long get2 = (long) a[y].get(j);
        if (get1 <= get2) {
            tmp.add(get1);
            i++;
        } else {
            tmp.add(get2);
            j++;
        }
    }
    while (i < a[x].size()) {
        long get1 = (long) a[x].get(i);
        tmp.add(get1);
        i++;
    }
    while (j < a[y].size()) {
        long get2 = (long) a[y].get(j);
        tmp.add(get2);
        j++;
    }
    a[x] = (ArrayList<Long>) tmp.clone();
}