package arrayDSA;
class MyThread extends Thread 
{ 
    public void run() 
    { 
        for (int i=0; i<5 ; i++) {
        	System.out.println("leena jena");
        
            System.out.println(Thread.currentThread().getName() 
                                + " in control"); 
        }
    } 
} 
public class MethodOverloading implements Runnable {
	 public static Thread thread1; 
	    public static MethodOverloading obj; 
	    
	    
	      
	    public static void main(String[] args) 
	    { 
	     /*   obj = new MethodOverloading(); 
	        thread1 = new Thread(obj); 
	          
	        // thread1 created and is currently in the NEW state. 
	        System.out.println("State of thread1 after creating it - " +Thread.currentThread().getName()+ thread1.getState()); 
	        thread1.start(); 
	          
	        // thread1 moved to Runnable state 
	        System.out.println("State of thread1 after calling .start() method on it - " + Thread.currentThread().getName()+ 
	            thread1.getState()); */
	    	
	    	 MyThread t = new MyThread(); 
	         t.start(); 
	   
	         for (int i=0; i<5; i++) 
	         { 
	             // Control passes to child thread 
	             Thread.yield(); 
	   
	             // After execution of child Thread 
	             // main thread takes over 
	             //System.out.println("Alka jena");
	             System.out.println(Thread.currentThread().getName() 
	                                 + " in control"); 
	             System.out.println("pupu jena");
	         } 
	     } 
	    
	      
	    public void run() 
	    { 
	        thread myThread = new thread(); 
	        Thread thread2 = new Thread(myThread); 
	          
	        // thread1 created and is currently in the NEW state. 
	        System.out.println("State of thread2 after creating it - "+Thread.currentThread().getName()+ thread2.getState()); 
	        thread2.start(); 
	          
	        // thread2 moved to Runnable state 
	        System.out.println("State of thread2 after calling .start() method on it - " +Thread.currentThread().getName()+  
	            thread2.getState()); 
	          
	        // moving thread1 to timed waiting state 
	        try
	        { 
	            //moving thread1 to timed waiting state 
	        	System.out.println(Thread.currentThread().getName()+" "+
	    	            thread2.getState()); 
	            Thread.sleep(200); 
	            System.out.println(Thread.currentThread().getName()+" "+
	    	            thread2.getState()); 
	        }  
	        catch (InterruptedException e)  
	        { 
	            e.printStackTrace(); 
	        } 
	        System.out.println("State of thread2 after calling .sleep() method on it - "+Thread.currentThread().getName()+
	            thread2.getState()); 
	          
	          
	        try 
	        { 
	            // waiting for thread2 to die 
	        	System.out.println(Thread.currentThread().getName()+" "+
	    	            thread2.getState()); 
	            thread2.join(); 
	            System.out.println(Thread.currentThread().getName()+" "+
	    	            thread2.getState()); 
	        }  
	        catch (InterruptedException e)  
	        { 
	            e.printStackTrace(); 
	        } 
	        System.out.println("State of thread2 when it has finished it's execution - " +Thread.currentThread().getName()+  
	            thread2.getState()); 
	    } 
	 

} 

 class thread implements Runnable 
 { 
     public void run() 
     { 
         // moving thread2 to timed waiting state 
         try
         { 
        	 System.out.println(Thread.currentThread().getName()+" "+
        			 MethodOverloading.thread1.getState()); 
             Thread.sleep(1500); 
             System.out.println(Thread.currentThread().getName()+" "+
        			 MethodOverloading.thread1.getState()); 
         }  
         catch (InterruptedException e)  
         { 
             e.printStackTrace(); 
         } 
           
         System.out.println("State of thread1 while it called join() method on thread2 -"+ Thread.currentThread().getName()+
        		 MethodOverloading.thread1.getState()); 
         try
         { 
             Thread.sleep(200); 
         }  
         catch (InterruptedException e)  
         { 
             e.printStackTrace(); 
         }      
     } 
 } 