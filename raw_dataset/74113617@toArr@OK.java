int[] toArr(ArrayList<Integer> al) {
    int[] rv = new int[al.size()];
    for (int i = 0; i < rv.length; i++) rv[i] = al.get(i);
    return rv;
}