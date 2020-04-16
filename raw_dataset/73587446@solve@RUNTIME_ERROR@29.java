    void solve() {
        int n = ni();
        int[] a = na(n);

        //Arrays.sort(a);
        path = new ArrayList[N];
        dist = new int[N];
        for (int i = 1; i < N; i++) {
            path[i] = new ArrayList<>();
        }

        for (int x : a) {
            List<Integer> primesOfAi = getPrimes(x);

            if (primesOfAi.isEmpty()) {
                debug("1", x);
                out.println(1);
                out.flush();
                System.exit(0);
            } else if (primesOfAi.size() == 1) {
                primesOfAi.add(1);
            }

            int u = primesOfAi.get(0);
            int v = primesOfAi.get(1);
            path[u].add(v);
            path[v].add(u);

            primeSet.addAll(primesOfAi);
        }
       
        int result =
                primeSet.stream().filter(prime -> prime <= 1000)
                .map(this::getCircleLength)
                .reduce(Math::min)
                .get();

        out.println(result >= INF ? -1 : result);
    }