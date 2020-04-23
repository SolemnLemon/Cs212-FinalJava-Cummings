/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liststacktemplate;

/**
 *
 * @author Paul
 *
 */
public class MyList<T> {

    private int size;
    private ListNode FirstTerm;
    private ListNode lastTerm;

    public MyList() {
        setSize(0);
    }

    /**
     * get the ith element stored in the list. Note that this does not return
     * the containing node, but the stored element in the node. Null if D.N.E.
     *
     * @param i
     * @return
     */
    public Value get(int i) {
        ListNode camera = getFirstTerm();

        while (camera.getIndex() != i) {
            System.out.println("camera value:" + camera.getValue().getValue() + " " + i + " index: " + camera.getIndex());
            
            if (camera == null) {
                System.out.println("term of that index does not exist");
                return null;
            }
            camera = camera.getPointer();
        }

        return camera.getValue();
    }

    /**
     * Add an element to the end of the list.
     *
     * @param v the element to insert.
     * @return the modified list object
     */
    public MyList add(char c) {
        // method is overloaded to take ints or chars as needed
        Value v = formatValue(c);
        //update size after add so that index 0 actually starts at 0
        ListNode node = new ListNode(v, this, size(), getLastTerm());
        if (node.getIndex() == 0) {
            //if this is the first term added
            setFirstTerm(node);
        }
        if (checkFinal(node)) {
            System.out.println("added term " + node.getValue().getValue() + " number " + size() + " succesfully");
        }
        setSize(size() + 1);
        correctIndex();
        return this;

    }

    public Value formatValue(char v) {
        if (v >= '0' && v <= '9') {
            return new Numeric(v);
        } else if (v == '+' || v == '-' || v == '*' || v == '/'|| v=='^') {
            return new Symbol(v);
        } else if (v == ' ') {
            return new Spacer(v);
        }
        System.out.println("something is wrong");
        return null;
    }

    /**
     * to be done after anything is added to the list the only condition where
     * the pointer should be null is when the term is the last term in the list
     *
     * @param term
     * @return returns if the the term was final or not
     *
     */
    public boolean checkFinal(ListNode term) {
        if (term.getPointer() == null) {
            setLastTerm(term);
            return true;
        }
        return false;

    }

    /**
     * removes an element (node) at the index specified.
     *
     * @param i
     * @return the element which was removed. null if invalid index.
     */
    public T removeAtIndex(int i) {
        /*
        Be careful here! think about edge cases. If you choose to keep a
        'last' pointer, what if the element being removed is last?
         */

        ListNode camera = getFirstTerm();
        ListNode previousTerm = null;
        while (camera.getIndex() != i) {
            previousTerm = camera;
            camera = camera.getPointer();
            if (camera.getPointer() == null) {
                System.out.println("term of that index does not exist");
                return null;
            }
        }
        if (camera.getPointer() == null) {
            setLastTerm(previousTerm);
        }
        if (previousTerm == null) {
            setFirstTerm(camera.getPointer());
        } else {
            previousTerm.setPointer(camera.getPointer());
        }
        correctIndex();
        setSize(size() - 1);
        return (T) camera.getValue();
    }

    /**
     * makes sure index still lines up after any changes to the list
     */
    public void correctIndex() {
        ListNode camera = getFirstTerm();
        int i = 0;
        while (camera.getPointer() != null) {
            camera.setIndex(i);
            camera = camera.getPointer();
            i++;
        }

    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * returns the index of the element given. -1 if not found.
     *
     * @param v The element to look for.
     * @return the index or -1 if not found.
     */
    public int indexOf(T v) {

        ListNode camera = getFirstTerm();
        while (camera.getValue() != v) {
            camera = camera.getPointer();
            if (camera.getPointer() == null) {
                System.out.println("term of that value does not exist");
                //returns -1 to signify an issue
                return -1;
            }
        }
        return camera.getIndex();
    }

    /**
     * removes the first occurrence of given element. Does nothing if the
     * element is not present in the list.
     *
     * @param v the element to remove
     * @return the modified list to allow chaining i.e.
     * ls.remove(3).remove(4)...
     */
    public MyList<T> remove(T v) {
        removeAtIndex(size());
        return this;
    }

    /**
     * calculates and returns the size/length of the list.
     *
     * @return the length/size.
     */
    public int size() {
        return this.size;
    }

    /**
     * Answers if there are any elements in the list.
     *
     * @return true if list contains at least 1 element, false otherwise.
     */
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * A pretty toString for lists.
     *
     * @return MyList: [elem1, elem2, elem3...]
     */
    @Override
    public String toString() {
        //throw new UnsupportedOperationException("Not supported yet.");
        String s = "";
        ListNode camera = getFirstTerm();
        while (camera != null) {
            s = s + camera.getValue().toString();
            camera = camera.getPointer();

        }
        return s;

    }

    public ListNode getLastTerm() {
        return lastTerm;
    }

    public void setLastTerm(ListNode lastTerm) {
        this.lastTerm = lastTerm;
    }

    public ListNode getFirstTerm() {
        return FirstTerm;
    }

    public void setFirstTerm(ListNode FirstTerm) {
        this.FirstTerm = FirstTerm;
    }

}
