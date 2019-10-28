package learningchannel;

public class Main
{
    public static int removeAlternate(int n)
{
    	int tracker;
    if (n == 1)
    {
        return 1;
    }
    if (n % 2 == 0)
    {
    	tracker=2 * removeAlternate(n / 2) - 1;
        return tracker;
    } 
    else
    {
    	tracker=2 * removeAlternate(((n - 1) / 2)) + 1;
        return tracker;
    }
        
}

public static void main(String[] args)
{
    int n = 100;
    System.out.print("\n"+removeAlternate(n));
}
}