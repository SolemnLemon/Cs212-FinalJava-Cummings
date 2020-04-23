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
public class Symbol extends Value {

    public Symbol(char c) {
        super(c);
        System.out.println("added a symbol");
        setValue(c);

    }
    private char value;

    @Override
    public String getValue() {
        String s = "";
        s = s + value;
        return s;
    }

    public void setValue(char c) {
        this.value = c;

    }

}
