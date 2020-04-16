private static boolean checkPrivate(ArrayList<Integer>[] adj) {
    for (ArrayList<Integer> list : adj) {
        if (list.size() < 2) {
            return false;
        }
    }
    return true;
}