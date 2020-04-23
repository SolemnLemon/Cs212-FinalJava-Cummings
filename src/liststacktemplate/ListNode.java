/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liststacktemplate;

/**
 *
 * @author Paul
 */
public class ListNode<T> {

    /**
     * Create a new ListNode given a value.
     *
     * @param v
     */
    ListNode(Value v, MyList ownedby, int index, ListNode previous) {
setValue(v);
setOwnedBy(ownedby);
setIndex(index);
if(previous!=null){
previous.setPointer(this);
}
//trial
ownedBy.setLastTerm(this);
    }

    private int index;
    private ListNode pointer;
    private Value value;
    private MyList ownedBy;

    /**
     * return the value being held by this Node.
     *
     * @return
     */
    public Value getValue() {
        return this.value;
    }
    public void setValue(Value v){
    this.value=v;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ListNode getPointer() {
        return pointer;
    }

    public void setPointer(ListNode pointer) {
        this.pointer = pointer;
    }

    public MyList getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(MyList ownedBy) {
        this.ownedBy = ownedBy;
    }
}
