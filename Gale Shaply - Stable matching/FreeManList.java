public class FreeManList {
    private Node FreeManRec, TempRec, CurrentRec, head;
    int size = 0;

    // When we are starting a new list, the temp will have the index 1, the other Nodes will point on it
    public FreeManList(){
        TempRec.val = 1;
        TempRec.next = null;
        head = TempRec;
        CurrentRec = TempRec;
    }


//    public add(){}
}
