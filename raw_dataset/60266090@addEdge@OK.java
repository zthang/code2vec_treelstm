public void addEdge(EdgeChain newChain) {
    newChain.next = chain;
    chain = newChain;
    containEdge = this;
}