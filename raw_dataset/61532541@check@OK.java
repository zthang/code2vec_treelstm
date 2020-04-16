boolean check() {
    for (int v : dada[1]) {
        ArrayList<Integer> red = new ArrayList<>();
        ArrayList<Integer> blue = new ArrayList<>();
        for (int q : g[v]) {
            if (color[q] == 2) {
                red.add(q);
            } else if (color[q] == 3) {
                blue.add(q);
            }
        }
        if (red.size() != dada[2].size() || blue.size() != dada[3].size()) {
            return false;
        }
    }
    for (int v : dada[2]) {
        ArrayList<Integer> red = new ArrayList<>();
        ArrayList<Integer> blue = new ArrayList<>();
        for (int q : g[v]) {
            if (color[q] == 1) {
                red.add(q);
            } else if (color[q] == 3) {
                blue.add(q);
            }
        }
        if (red.size() != dada[1].size() || blue.size() != dada[3].size()) {
            return false;
        }
    }
    for (int v : dada[3]) {
        ArrayList<Integer> red = new ArrayList<>();
        ArrayList<Integer> blue = new ArrayList<>();
        for (int q : g[v]) {
            if (color[q] == 1) {
                red.add(q);
            } else if (color[q] == 2) {
                blue.add(q);
            }
        }
        if (red.size() != dada[1].size() || blue.size() != dada[2].size()) {
            return false;
        }
    }
    return true;
}