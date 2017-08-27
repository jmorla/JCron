/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jcron.exceptions;

/**
 *
 * @author jmorla
 */
public class InvalidCronDateException extends Exception{
    
    public InvalidCronDateException(){
        super("Invalid cron date check a valid format");
    }
}
