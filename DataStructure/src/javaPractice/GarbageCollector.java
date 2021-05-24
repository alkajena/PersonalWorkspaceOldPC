package javaPractice;

//concept of island of isolation
public class GarbageCollector {
		GarbageCollector gc;
		public static void main(String[] args) {
			GarbageCollector gc1=new GarbageCollector();
			GarbageCollector gc2=new GarbageCollector();
			
			gc1.gc=gc2;
			gc2.gc=gc1;
			
			gc1=null;
			gc2=null;
			
			System.gc();
		}
		
		@Override
		  protected void finalize() throws Throwable
	    {
	        System.out.println("garbage collected");
	    }

	}

