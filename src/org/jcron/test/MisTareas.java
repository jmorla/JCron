
package org.jcron.test;

import org.jcron.annotations.Cron;
import org.jcron.annotations.Task;
import org.jcron.core.JCron;

/**
 *
 * @author jmorla
 */
@Cron
public class MisTareas {


    @Task(name = "hola", seconds = 1,minute = 5,hour = 3,dayOfWeek = 5,dayOfMonth = 25,month = -1)
    public void hola(){
        System.out.println("Hola palomo");
    }
    
    public static void main(String[] args) {
        JCron c = new JCron();
        c.runTasks(new MisTareas());
    }
}
