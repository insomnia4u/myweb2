
public class ForTest {

	public static void main(String[] args) {
		
		String arr[]={"사과","포도","배","수박"};
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("----------------------");
		
		for(String temp:arr)
		{
			System.out.print(temp+" ");
		}
	}

}
