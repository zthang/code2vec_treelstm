int minar() {
    int min = ar.size();
    // System.out.println();
    for (int x = 1; x < ar.size(); x++) {
        if (ar.size() % x == 0) {
            // System.out.println(x);
            boolean valid = true;
            for (int x1 = 0; x1 < x; x1++) {
                valid = true;
                int begin = x1;
                int temp2 = (x1 + x) % ar.size();
                int fcolor = ar.get(x1);
                while (temp2 != begin) {
                    if (ar.get(temp2) != fcolor) {
                        valid = false;
                        break;
                    }
                    temp2 += x;
                    temp2 %= ar.size();
                }
                if (valid) {
                    min = Math.min(x, min);
                    break;
                }
            }
        }
        if (min != ar.size())
            break;
    }
    ar.clear();
    return min;
}