public void go() throws IOException {
    ntok();
    int n = ipar();
    int m = ipar();
    Vertex[] vertices = new Vertex[n];
    for (int i = 0; i < n; i++) {
        vertices[i] = new Vertex(i);
    }
    for (int i = 0; i < m; i++) {
        ntok();
        int a = ipar() - 1;
        int b = ipar() - 1;
        vertices[a].add(vertices[b]);
    }
    int c = 1;
    boolean works = true;
    ArrayList<Integer> counts = new ArrayList<>();
    for (Vertex curr : vertices) {
        // out.println(Arrays.toString(vertices));
        if (curr.comp == 0) {
            int co = 1;
            curr.comp = c;
            for (Vertex v : vertices) {
                if (v == curr) {
                    continue;
                }
                if (!curr.others.contains(v)) {
                    if (v.comp != 0) {
                        works = false;
                        break;
                    }
                    v.comp = c;
                    co++;
                } else if (v.comp == c) {
                    works = false;
                    break;
                }
            }
            c++;
            counts.add(co);
        } else {
            for (Vertex v : curr.others) {
                if (v.comp == curr.comp) {
                    // out.println(v.i + " !!! " + curr.i);
                    works = false;
                    break;
                }
            }
        }
    }
    for (Vertex curr : vertices) {
        if (curr.comp < 1 || curr.comp > 3) {
            works = false;
            break;
        }
        for (Vertex other : curr.others) {
            if (curr.comp == other.comp) {
                works = false;
                break;
            }
        }
    }
    long sum = 0;
    for (int i = 0; i < counts.size(); i++) {
        for (int e = i + 1; e < counts.size(); e++) {
            sum += counts.get(i) * counts.get(e);
        }
    }
    if (sum != m) {
        works = false;
    }
    // out.println(Arrays.toString(vertices));
    if (c == 4 && works) {
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                out.print(" ");
            }
            out.print(vertices[i].comp);
        }
        out.println();
    } else {
        out.println(-1);
    // out.println("FFSDFS");
    }
    out.flush();
    in.close();
}