/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

/**
 *
 * @author Lasse
 */
public class convertSize {
    public String convertSize(long x) {
        int orderOfMagnitude = 0;
        String[] formats = {"Bytes","KB","MB","GB","TB","PB"};
        
        while(x>1024) {
            x = x/1024;
            orderOfMagnitude++;
        }
        return x + " " + formats[orderOfMagnitude];
    }
}
