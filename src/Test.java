
public class Test {

	public static void main(String[] args) {
		Genera gen = new Genera();

		Generatori[] gene = null;

		long end,begin;

		for(int nThread = 0; nThread < 7;nThread++)
		{
			begin = System.currentTimeMillis();
			gene = new Generatori[(int) Math.pow(2.0,(double)nThread)];
			for(int i = 0; i < Math.pow(2.0,(double)nThread);i++)
			{
				gene[i] = new Generatori(gen, i+1);
				gene[i].start();
			}

			for(int j = 0;j<Math.pow(2.0,(double)nThread);j++)
			{
				try {
					gene[j].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			end = System.currentTimeMillis();
			System.out.println("Time: " + (end - begin) + "ms con " + Math.pow(2.0,(double)nThread)+" thread");
			gen = new Genera();
		}
	}

}
