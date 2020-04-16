void startAlgo() {
    boolean[] isTaken = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
        if (y[i] % 2 == 0) {
            if (i - y[i] >= 1) {
                evenGraph[i - y[i]].add(i);
                if (y[i - y[i]] % 2 != 0) {
                    if (isTaken[i - y[i]] == false) {
                        isTaken[i - y[i]] = true;
                        evenQueue.add(i - y[i]);
                    }
                }
            }
            if (i + y[i] <= n) {
                evenGraph[i + y[i]].add(i);
                if (y[i + y[i]] % 2 != 0) {
                    if (isTaken[i + y[i]] == false) {
                        isTaken[i + y[i]] = true;
                        evenQueue.add(i + y[i]);
                    }
                }
            }
        } else {
            if (i - y[i] >= 1) {
                oddGraph[i - y[i]].add(i);
                if (y[i - y[i]] % 2 == 0) {
                    if (isTaken[i - y[i]] == false) {
                        isTaken[i - y[i]] = true;
                        oddQueue.add(i - y[i]);
                    }
                }
            }
            if (i + y[i] <= n) {
                oddGraph[i + y[i]].add(i);
                if (y[i + y[i]] % 2 == 0) {
                    if (isTaken[i + y[i]] == false) {
                        isTaken[i + y[i]] = true;
                        oddQueue.add(i + y[i]);
                    }
                }
            }
        }
    }
    processForOdd();
    processForEven();
    for (int i = 1; i <= n; i++) {
        if (y[i] % 2 == 0) {
            evenD[i] = evenD[i] == 0 ? -1 : evenD[i];
            z.print(evenD[i] + " ");
        } else {
            oddD[i] = oddD[i] == 0 ? -1 : oddD[i];
            z.print(oddD[i] + " ");
        }
    }
    z.println();
}