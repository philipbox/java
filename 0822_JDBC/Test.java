

import java.util.ArrayList;

public class Test {
	private void printAllBooks(ArrayList<Book> list)
	{
		if(list == null)
			return;
		for(Book book : list)
			System.out.println(book);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test();
		BookDAO mgr= new BookDAO();					
		
		//3번
		ArrayList<Book> list = mgr.find_join();
		test.printAllBooks(list);
		
		//4번
		System.out.println(mgr.findName("김태희"));
		

	}

}
