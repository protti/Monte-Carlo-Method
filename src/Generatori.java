
public class Generatori extends Thread{
	
	private Genera gen;
	private int valore;
	
	public Generatori(Genera gen,int valore)
	{
		this.gen=gen;
		this.valore=valore;
	}
	
	public void lancia() 
	{
		this.start();
		
	}
	
	
	@Override
	public void run()  {
		// TODO Auto-generated method stub
			while(true)
			{
				try {
					gen.genera(valore,this);
				} catch (IllegalArgumentException e) {
					break;
				}
			}	
			
			
	}
}
