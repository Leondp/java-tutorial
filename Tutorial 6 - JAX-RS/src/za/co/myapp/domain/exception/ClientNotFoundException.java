/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.myapp.domain.exception;

/**
 *
 * @author leon
 */
public class ClientNotFoundException  extends Exception {

    public ClientNotFoundException(String string) {
        super(string);
    }
    
}
