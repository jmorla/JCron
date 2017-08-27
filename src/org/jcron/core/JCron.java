
package org.jcron.core;

import org.jcron.annotations.Cron;
import org.jcron.annotations.Task;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jcron.exceptions.NoClassCronException;
import org.jcron.util.CronDate;


public class JCron {
    
    public void runTasks(Object cron) {
        String classname = cron.getClass().getName();
       
        if(cron.getClass().isAnnotationPresent(Cron.class)){
            try{
                Method[] methods = Class.forName(classname).getMethods();

                for(Method m : methods){
                    invokeTask(m, cron);
                }
         
            } catch (ClassNotFoundException | SecurityException | IllegalAccessException 
                    | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(JCron.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                throw new NoClassCronException();
            } catch (NoClassCronException ex) {
                Logger.getLogger(JCron.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private void invokeTask(Method method,Object cron)
        throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        Task task = method.getAnnotation(Task.class);
        
        if(task != null){
           CronDate cronDate = new CronDate();
           cronDate.setSeconds(task.seconds());
           cronDate.setMinute(task.minute());
           cronDate.setHour(task.hour());
           cronDate.setDayOfWeek(task.dayOfWeek());
           cronDate.setDayOfMonth(task.dayOfMonth());
           cronDate.setMonth(task.month());
                   
           new TaskThread(method, cron, cronDate).start();
        }
    }
}
