import java.util.logging.Logger;

public class Genera {

	private boolean show = false;
	private volatile int numberAttempts;
	private volatile int numberSuccess;
	private static final long  attempts = 10000000;
	private Logger log = Logger.getLogger("Global");
	Object lock1 = new Object();
	Object lock2 = new Object();


	public void genera(int valore,Generatori ge,double z) 
	{
		log.setUseParentHandlers(false);
		if(numberAttempts > attempts)
		{
			log.info("Lanciata");
			if(!show)
			{
				System.out.println(this.getValue());
				show = true;
			}
			throw new IllegalArgumentException();
		}
		else
		{
			 
				if(z < 1)
				{
					//log.info("Thread: "+Thread.currentThread()+" z vale: " + z);
					synchronized (lock2)
					{
						log.info("Thread: "+Thread.currentThread()+" tentativi vale: " + numberAttempts);
						numberAttempts++;
					}
					synchronized (lock1) {
						numberSuccess++;
						log.info("Thread: "+Thread.currentThread()+" tentativi riusciti vale: " + numberSuccess);
					}
						
					
				}	
				else
				{
					synchronized (lock2)
					{
						log.info("Thread: "+Thread.currentThread()+" tentativi vale: " + numberAttempts);
						numberAttempts++;
					}
				}

			
		}

	}

	public double getValue()
	{
		double value = 4*((double)numberSuccess/(double)numberAttempts);
		return value;

	}

	public void setBoolean()
	{
		this.show = false;
	}
	
}
