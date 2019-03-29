
public class Philosopher extends Thread
{
	private Fork left;
	private Fork right;
	private String name;
	private int rounds = 100;
	Waiter waiter = new Waiter();

	public Philosopher (String name, Fork left, Fork right)
	{
		this.name = name;
		this.left = left;
		this.right = right;
	}
	
	public Philosopher getPhilosopher()
	{
		Philosopher p = new Philosopher(name, left, right);
		return p;
	}
	
	public boolean isLeft()
	{
		return !left.used;
	}
	
	public boolean isRight()
	{
		return !right.used;
	}
	 
	public void eat() 
	{
		left.take();
		right.take();

		System.out.println(name + " is eating");
				
		right.release();
		left.release();
		think();	

	}

	public void think() 
	{
	 	System.out.println(name + " is thinking");
	 	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void run()
	{
		for(int i=0; i<=rounds; i++)
		{
			Philosopher p = getPhilosopher();
			if (waiter.canEat(p)) // Asks waiter if they can eat
			{
				p.eat();
			}
			else 
			{
				think();
			}
		}
	}
}