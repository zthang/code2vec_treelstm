public IntIterator iterator(final int queue) {
    return new IntIterator() {

        int ele = heads[queue];

        public boolean hasNext() {
            return ele != 0;
        }

        public int next() {
            int ans = values[ele];
            ele = next[ele];
            return ans;
        }
    };
}