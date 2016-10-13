import java.util.logging.Logger;

public class Genera {

	private double x,y,z;
	private boolean show = false;
	private volatile int numberAttempts;
	private volatile int numberSuccess;
	private static final long  attempts = 999999999;
	private Logger log = Logger.getLogger("OFF");
	



	synchronized public void genera(int valore,Generatori ge) 
	{
		log.setUseParentHandlers(false);
		if(numberAttempts == attempts)
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
			x = Math.random();
			y = Math.random();
			z = x*x+y*y;
			if(z < 1)
			{
				numberAttempts++;
				numberSuccess++;
			}	
			else
				numberAttempts++;
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
