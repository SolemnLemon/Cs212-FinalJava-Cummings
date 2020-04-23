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
public  class Value {

 
    public Value(char value){
   
    }
    @Override
    public String toString(){
    return getValue();
    }
    
    public String getValue(){
    return null;
    }
    public int getIntValue(){
        System.out.println("you fucked up somewhere this method should never be called");
    return 0;
    }
}
