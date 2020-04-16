public IntegerIterator iterator() {
    return new IntegerIterator() {

        int index = bpos;

        public boolean hasNext() {
            return index != epos;
        }

        public int next() {
            int ans = data[index];
            index = IntegerDequeImpl.this.next(index);
            return ans;
        }
    };
}