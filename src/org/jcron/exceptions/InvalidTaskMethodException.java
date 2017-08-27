
package org.jcron.exceptions;

/**
 *
 * @author jmorla
 */
public class InvalidTaskMethodException extends Exception{
 
    public InvalidTaskMethodException(String taskname){
        super(taskname+" method are invalid expecifications, the methods can't parameters or returns values");
    }
}
