/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author ASUS
 */
public class Cart {
    private double totalPrice;
    static int cartid;
    protected Vector item;
    
    public Cart(){
        item = new Vector();
    }
    
    public Vector getItem(){
        return (Vector) item.clone();
    }
    
    public void addItam(Catalog cat){
        Boolean flag = false;
        if(item.size()==0){
            item.addElement(cat);
            return;
        }
        for(int i=0; i < item.size(); i++){
            Catalog ca = (Catalog) item.elementAt(i);
            if(ca.getDvdnames().equals(cat.getDvdnames())){
                ca.setQuantity(cat.getQuantity()+ca.getQuantity());
                item.setElementAt(ca, i);
                flag = true;
                break;
            }
        }
        if(cat.getQuantity() > 0 && (flag == false)){
            item.addElement(cat);
        }
    }
    
    public void removeItem (int itemIndex){
        item.removeElementAt(itemIndex);
    }
    
    public void calTotal (){
        Enumeration dc = item.elements();
        while(dc.hasMoreElements()){
            Catalog item = (Catalog) dc.nextElement();
            
            totalPrice = totalPrice + item.getPrice() * item.getQuantity();
        }
    }
    public double getTotal(){
        return this.totalPrice;
    }
    
    
}
