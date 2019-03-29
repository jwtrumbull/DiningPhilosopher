import java.util.Queue;

public class Waiter {
	
	public boolean canEat(Philosopher p)
	{
		if (p.isLeft())
		{
			if (p.isRight())
			{
				return true;
			}
		}
		return false;
	}
	
}
