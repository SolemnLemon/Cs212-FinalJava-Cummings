/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liststacktemplate;

/**
 *
 * @author sunbe
 */
public class Numeric extends Value {

    public Numeric(char c) {
        super(c);
        System.out.println("added a number");
setValue(c);
    }
    private int value;

    @Override
    public String getValue() {
       
        return ""+value;
    }
    public int getIntValue(){
    return value;
    }

    public void setValue(char c) {
        this.value = Character.getNumericValue(c);

    }

}
