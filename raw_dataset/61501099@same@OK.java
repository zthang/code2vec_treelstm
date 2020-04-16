private static boolean same(ArrayList<Integer> adjList, ArrayList<Integer> rep) {
    if (adjList.size() != rep.size())
        return false;
    for (int i = 0; i < adjList.size(); i++) {
        if (adjList.get(i).intValue() != rep.get(i).intValue())
            return false;
    }
    return true;
}