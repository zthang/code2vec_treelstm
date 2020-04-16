            Graph build(Scanner in) {
                return new Graph(
                        in,
                        n == -1 ? in.nextInt() : n,
                        m == -1 ? in.nextInt() : m,
                        adjustIndex,
                        withWeights);
            }