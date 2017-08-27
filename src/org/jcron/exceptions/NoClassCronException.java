
package org.jcron.exceptions;

/**
 *
 * @author jmorla
 */
public class NoClassCronException extends Exception{
    
    public NoClassCronException(){
        super("This class no contain Cron Annotation");
    }
}
