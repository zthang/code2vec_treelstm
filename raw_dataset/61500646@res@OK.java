boolean res(int a) {
    TreeSet<Integer> tset = new TreeSet();
    while (a != 0) {
        int dig = a % 10;
        if (tset.contains(dig)) {
            return false;
        }
        tset.add(dig);
        a = a / 10;
    }
    return true;
}