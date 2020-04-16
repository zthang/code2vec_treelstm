public void process(PriorityQueue<Node> toAddTo, int curLabel) {
    this.label = curLabel;
    Node curPar = par;
    while (curPar != null) {
        curPar.indeg--;
        if (curPar.indeg == 0)
            toAddTo.add(curPar);
        curPar = curPar.par;
    }
}