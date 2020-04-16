private void removeFromAuxis(NodeInfo info) {
    {
        if (lvs[info.level].auxis[info.from] == info.ft) {
            lvs[info.level].auxis[info.from] = info.ft.next;
        }
        lvs[info.level].nauxis[info.from]--;
        AuxiliaryEdge next = info.ft.next;
        AuxiliaryEdge prev = info.ft.prev;
        if (next != null)
            next.prev = prev;
        if (prev != null)
            prev.next = next;
        updateForestRem(info.level, info.from);
    }
    {
        if (lvs[info.level].auxis[info.to] == info.tf) {
            lvs[info.level].auxis[info.to] = info.tf.next;
        }
        lvs[info.level].nauxis[info.to]--;
        AuxiliaryEdge next = info.tf.next;
        AuxiliaryEdge prev = info.tf.prev;
        if (next != null)
            next.prev = prev;
        if (prev != null)
            prev.next = next;
        updateForestRem(info.level, info.to);
    }
}