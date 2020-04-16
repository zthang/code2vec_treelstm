public Iterator<Graph.Edge> edgeIterator() {
    return new Iterator<Edge>() {

        private int vertex = -1;

        private VectorElementIterator iterator = null;

        private Edge nxt = null;

        public boolean hasNext() {
            int n = getVertexCount();
            if (nxt == null) {
                do {
                    while (iterator == null || !iterator.hasNext()) {
                        if (++vertex >= n)
                            return false;
                        iterator = getNeighbours(vertex);
                    }
                    nxt = new Edge(vertex, iterator.nextInt(), iterator.getValue());
                } while (!directed && nxt.to >= nxt.from);
            }
            return true;
        }

        public Edge next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Edge res = nxt;
            nxt = null;
            return res;
        }
    };
}