
package org.jcron.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.jcron.util.CronDate;


public class TaskThread extends Thread{

    private final Method method;
    private final Object cronObject;
    private final CronDate crondate;

    public TaskThread(Method method, Object cronObject, CronDate crondate) {
        this.method = method;
        this.cronObject = cronObject;
        this.crondate = crondate;
    }
     
    @Override
    public void run() {
     try{  
       while(this.isAlive()){
          if(crondate.getSeconds()<=-1){
             Thread.sleep(1000);
          }else{
              Thread.sleep(crondate.getSeconds()*1000);
          }
          method.invoke(cronObject, (Object[])null);
       }
     }catch(IllegalAccessException | IllegalArgumentException | InterruptedException | InvocationTargetException e){
     
     }
    }
    
}
