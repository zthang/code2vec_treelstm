static boolean compare(ArrayList<Integer> la, ArrayList<Integer> lb) {
    if (la.size() != lb.size())
        return false;
    int L = la.size();
    for (int i = 0; i < L; i++) if (la.get(i) != lb.get(i))
        return false;
    return true;
}