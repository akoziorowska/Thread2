package com.example.thread.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;

public class MyBean {

    @Autowired
    TaskExecutor taskExecutor;

    public void runTasks(){
        for(int i=0;i<5;i++){
            taskExecutor.execute(getTask(i));
        }
    }

    private Runnable getTask(int i){
        return ()->{
            System.out.printf("Running task %d, thread: %s%n", i, Thread.currentThread().getName());
        };
    }
}
