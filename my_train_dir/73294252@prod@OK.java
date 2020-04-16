int prod(ArrayList<Integer> div) {
    if (div.size() == 1) {
        return div.get(0);
    }
    return div.get(0) * div.get(1);
}