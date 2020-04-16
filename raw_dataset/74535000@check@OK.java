static boolean check(ArrayList<Integer> temp, int index) {
    boolean ok = true;
    for (int c : temp) if (tin[c] <= tin[index] && tout[c] >= tout[index])
        continue;
    else
        ok = false;
    return ok;
}