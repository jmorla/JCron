
package org.jcron.test;

import org.jcron.annotations.Cron;
import org.jcron.annotations.Task;
import org.jcron.core.JCron;
import java.util.Date;
/**
 *
 * @author jmorla
 */
@Cron
public class MisTareas {


    @Task(name = "hello", seconds = 1,minute = 5,hour = 3,dayOfWeek = 5,dayOfMonth = 25,month = -1)
    public void hola(){
        System.out.println("Hello world, I will execute in"+new Date());
    }
    
    public static void main(String[] args) {
        JCron c = new JCron();
        c.runTasks(new MisTareas());
    }
}
