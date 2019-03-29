public class Fork 
{
	public boolean used;
	public String forkNumber;

	public Fork(String forkNumber)
	{
		this.forkNumber = forkNumber;
	}

	public synchronized void take() 
	{
		System.out.println("Used " + forkNumber);
		this.used = true;
	}
	public synchronized void release() 
	{
		System.out.println("Released " + forkNumber);
		this.used = false;
	}
}
