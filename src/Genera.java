import java.util.logging.Logger;

public class Genera {

	private double x,y,z;
	private boolean show = false;
	private volatile int numberAttempts;
	private volatile int numberSuccess;
	private static final long  attempts = 9999999;
	private Logger log = Logger.getLogger("OFF");
	Object lock1 = new Object();
	Object lock2 = new Object();
	Object lock3 = new Object();
	Object lock4 = new Object();



	public void genera(int valore,Generatori ge) 
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
			log.info("Sono il thread numero:"+valore);
			double result;
			synchronized (lock1) {
				x = Math.random();
				y = Math.random();
				z = x*x+y*y;
				
			}
			synchronized (lock2) {
				if(z < 1)
				{
					
					numberAttempts++;
					numberSuccess++;
				}	
				else
					numberAttempts++;

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
