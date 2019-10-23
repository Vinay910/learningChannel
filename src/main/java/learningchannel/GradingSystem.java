package learningchannel;

public class GradingSystem {
	
	public String grading(int value)
	{
		if(value>=0&&value<50)
		{
			return "FAIL";
		}
		else if(value>=50&&value<70)
		{
			return "AVERAGE";
		}
		else if(value>=70&&value<90)
		{
			return "GOOD";
		}
		else if(value>=90&&value<=100)
		{
			return "Excelent";
		}
		else
		{
			return "INVALID ENTRY";
		}
	}

}
