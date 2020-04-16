private void insertToAuxis(NodeInfo info) {
    {
        AuxiliaryEdge next = lvs[info.level].auxis[info.from];
        lvs[info.level].auxis[info.from] = info.ft;
        lvs[info.level].nauxis[info.from]++;
        info.ft.next = next;
        if (next != null)
            next.prev = info.ft;
        info.ft.prev = null;
        updateForestIns(info.level, info.from);
    }
    {
        AuxiliaryEdge next = lvs[info.level].auxis[info.to];
        lvs[info.level].auxis[info.to] = info.tf;
        lvs[info.level].nauxis[info.to]++;
        info.tf.next = next;
        if (next != null)
            next.prev = info.tf;
        info.tf.prev = null;
        updateForestIns(info.level, info.to);
    }
}