package resource;

import java.util.ArrayList;
import java.util.HashSet;

public class TestClass {

	public static void main(String[] args) {
		
		int aar[] = {10,50,20,10,30,50};
		String val = "India";
		
		
		HashSet<Integer> list = new HashSet<Integer>();
		
		for(int e : aar)
		{
			if(list.add(e) == false)
			{
				System.out.println(e);
			}
		}
		
		
		System.out.println(list);
		
		System.out.println("==================================");
		
		for(int i=0;i<aar.length;i++)
		{
			for(int j=i+1;j<aar.length;j++)
			{
				if(aar[i] == aar[j])
				{
					System.out.println(aar[i]);
				}
			}
			
	
		}
		
		
		
		
		System.out.println("==================================");
		
		
		
		
		
	
	}
}
