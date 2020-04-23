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
public class MyStack {

    MyList arr = new MyList();

    /**
     * push an element onto the stack
     *
     * @param t the element to add to the stack
     * @return return the stack to allow chaining. i.e. stack.push(1).push(2)...
     */
    public MyStack push(char t) {
        arr.add(t);
        return this;
    }

    /**
     * remove and return the top element from the stack. This method should
     * throw an exception of your own descriptive making when this method is
     * called on an empty stack. needs work
     *
     * @return the top of the stack/removed element
     */
    public Value pop() {

        System.out.println("popping " + arr.getFirstTerm().getValue().getValue());
 ListNode camera=arr.getFirstTerm();
        arr.setSize(arr.size() - 1);
        if (arr.getFirstTerm().getPointer() == null) {
            //in the case of a one term 
System.out.println("removing from a term soon to be empty stack");
arr.setFirstTerm(null);
        } else {
             arr.setFirstTerm(arr.getFirstTerm().getPointer());
            System.out.println("setting new first to be "+ arr.getFirstTerm().getValue().getValue());
           

        }

        return camera.getValue();

    }

    /**
     * returns the top element on the stack, but does not remove it.
     *
     * @return the top element of the stack
     */
    public Value peek() {

        if (arr.isEmpty()) {
            System.out.println("peek saw list was empty");
            return null;
        }else{
            System.out.println("Peeking saw first term was "+arr.getFirstTerm().getValue().getValue());
            return arr.getFirstTerm().getValue();
        }
     
    }

    /**
     * Answers whether or not the stack contains elements.
     *
     * @return true-contains elements; false otherwise.
     */
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    /**
     * returns how many elements are in the stack.
     *
     * @return
     */
    public int size() {
        return arr.size();
    }

    /**
     * Custom toString which prints the stack... as a stack. (See example test
     * case from lab.
     *
     * @return
     */
    public MyList getArr(){
    return arr;
    }
    @Override
    public String toString() {
        return arr.toString();
    }
}
