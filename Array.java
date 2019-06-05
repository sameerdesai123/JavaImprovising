package ImpArray;

public class Array          // CHANGES NEED TO BE DONE mainly on DELETION
{
	protected int[] arr;
	protected int size = 1;
	int target = -1;
	public Array()
	{
		arr = new int[size];
		arr[size-1] = -1;

	}
	public void addElement(int x)
	{
		if(arr[0] == -1){
			arr[0] = x;
		}
		else{
			size++;
			int temp[] = new int[size - 1];
			for(int i=0;i<size-1;i++)
				temp[i] = arr[i];
			arr = new int[size];
			for(int i=0;i<size-1;i++)
			{	
				arr[i] = temp[i];			
			}
			arr[size-1] = x;	
			bubSort();
		}		
	}
	public void display()
	{
		for(int i=0;i<size;i++)
			System.out.print(arr[i] + "\t");
		System.out.println();
	}
	public void delElement(int x)
	{
		binSearch(x, size-1, 0);
		if(target == -1)
			System.out.println(x + " does not exist in array");
		else
		{
			int n = target;
			int m = target+1;
			while(m < size)
			{
				int t = arr[m];
				arr[m] = arr[n];
				arr[n] = t;
				n++;
				m++;
			}
			size--;
		}
	}
	protected void binSearch(int x, int h, int l)
	{
		int mid = (h+l)/2;
		if(l > h)
			target = -1;
		else
		{
			if(arr[mid] == x)
				target = mid;
			else if(arr[mid] < x)
				binSearch(x, h, mid+1);
			else
				binSearch(x, mid-1, l);
		}
			
	}
	protected void bubSort()
	{
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				if(arr[i] > arr[j])
				{
					int t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
			}
		}
	}
	/*
	public static void main(String args[])
	{
		Array a = new Array();
		a.addElement(8);
		a.addElement(5);
		a.addElement(3);
		a.addElement(4);
		a.display();
		a.delElement(5);
		a.display();
		a.addElement(5);
		a.display();
	}
	*/
	
}