public static int giveMe(HashSet<Integer> set) {
    int ans = -1;
    Iterator<Integer> pointer = set.iterator();
    ans = pointer.next();
    return ans;
}