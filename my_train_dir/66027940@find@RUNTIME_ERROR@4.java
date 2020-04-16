    public static int find(int [] ar, int i) {
        if (ar[i] == 0)
            return i;
        return find(ar, ar[i]);
    }