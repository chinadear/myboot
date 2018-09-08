package com.bootplus.thread.task;

import java.util.Iterator;
/**
 * java内存模型：可见性，原子性，有序性
 * 内存机制：i=i+1;内存变量i,将i的内存值复制到cpu缓存中执行i+1然后cpu缓存中i=i+1了将这个值再更新到内存中
 * 可见性：多个线程请求多个cpu处理单元，各自独立，各自缓存，导致线程间不可见性，线程1修改的结果线程2看不到，导致覆盖
 * 原子性：最小操作比如a=0不可分割一步操作完无线程问题，a=a+1可分割由中间过程如a=a,a=a+1,因此存在线程问题
 * 有序性：不能并行只能串行，加锁的操作同一时间多个线程中只能有一个线程正在执行，其他等候
 * volatile、synchronized 和 final 实现可见性，加锁，每个线程都能看到正在修改的线程值
 * synchronized 和在 lock、unlock 中操作保证原子性。
 * volatile 和 synchronized 两个关键字来保证线程之间操作的有序性
 * @author liulu
 *
 */
public class ThreadTaskManager {
	private static volatile long tid=-1;
	
	/**
     * 启动任务
     */
    public static void start(){
    	if(ThreadTaskManager.getThread(tid)==null){
    		ThreadTask tt=new ThreadTask();
    		tt.start();
    		tid=tt.getId();
	 	}
    }
    
    public static void start(String name){
    	if(ThreadTaskManager.getThreadByName(name)==null){
    		ThreadTask tt=new ThreadTask(name);
    		tt.start();
    		tid=tt.getId();
	 	}
    }
   /**
    * 停止任务
    */
    public static void stop(){
    	ThreadTask tt = (ThreadTask)ThreadTaskManager.getThread(tid);
    	if(tt!=null){
    		tt.setStat(false);
    	}
    }
    public static void stop(String name){
    	ThreadTask tt = (ThreadTask)ThreadTaskManager.getThreadByName(name);
    	if(tt!=null){
    		tt.setStat(false);
    	}
    }
    /**
     *终止任务
     */
    public static void interrupt(){
    	ThreadTask tt = (ThreadTask)ThreadTaskManager.getThread(tid);
    	if(tt!=null){
    		tt.interrupt();
    	}
    }
    
    public static void interrupt(String name){
    	ThreadTask tt = (ThreadTask)ThreadTaskManager.getThreadByName(name);
    	if(tt!=null){
    		tt.interrupt();
    	}
    }
    /**
     * 主线程中是否有线程在运行
     * @return true:有，false:没有
     */
    public static boolean isRunning(){
    	ThreadTask tt = (ThreadTask)ThreadTaskManager.getThread(tid);
    	if(tt==null){
    		return false;
    	}else{
    		String state=tt.getState().toString();
    		if("RUNNABLE".equals(state) || "TIMED_WAITING".equals(state)){
    			return true;
    		}else{
    			return false;
    		}
    	}
    }
    
    public static boolean isRunning(String name){
    	ThreadTask tt = (ThreadTask)ThreadTaskManager.getThreadByName(name);
    	if(tt==null){
    		return false;
    	}else{
    		String state=tt.getState().toString();
    		if("RUNNABLE".equals(state) || "TIMED_WAITING".equals(state)){
    			return true;
    		}else{
    			return false;
    		}
    	}
    }
	/**
	 * 通过线程id获取线程
	 * 线程栈方式[与findThread(threadId)这个方法实现相同功能，只是实现方式不同，乐意用哪个就用哪个]
	 * @param threadId
	 * @return
	 */
	public static Thread getThread(long threadId){
		Iterator iterator = Thread.getAllStackTraces().keySet().iterator();
		// 在Thread对象中取得所有的线程所在的栈，然后取得Set对象，便利取得所有的线程
		Thread myThread = null ;
		while(iterator.hasNext()){
			Thread t = (Thread)iterator.next();
			// 根据线程名取得自己想要的线程
			if(t.getId()==threadId){
				myThread = t ;
				break;
			}
		}
		return myThread ;
	}
	
	public static Thread getThreadByName(String name){
		Iterator iterator = Thread.getAllStackTraces().keySet().iterator();
		// 在Thread对象中取得所有的线程所在的栈，然后取得Set对象，便利取得所有的线程
		Thread myThread = null ;
		while(iterator.hasNext()){
			Thread t = (Thread)iterator.next();
			// 根据线程名取得自己想要的线程
			if(name.equals(t.getName())){
				myThread = t ;
				break;
			}
		}
		return myThread ;
	}
}
