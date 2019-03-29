/**
 * 
 * @author Jordan Trumbull
 *
 */
public class DiningPhilosopher
{
	public static void main(String[] args)
	{
		Fork[] forks = new Fork[5];

		for(int i = 0; i < forks.length; i++){
			forks[i] = new Fork("Fork " + i);
		}
		Philosopher[] philosophers = new Philosopher[5];
		philosophers[0] = new Philosopher("Socrates", forks[0], forks[1]);
		philosophers[1] = new Philosopher("Aristotle", forks[1], forks[2]);
		philosophers[2] = new Philosopher("Plato", forks[2], forks[3]);
		philosophers[3] = new Philosopher("Locke", forks[3], forks[4]);
		philosophers[4] = new Philosopher("Kant", forks[0], forks[4]);

		for(int i=0;i<philosophers.length;i++)
		{
			Thread t= new Thread(philosophers[i]);
			t.start();
		}
 	}
}