package annotations;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitAnnotations 
{
	
	
	@BeforeClass
	public static void BeforeClassAnnotate()
	{
		System.out.println("BeforeClass");
	}
	
	@Before
	public void BeforeAnnotate()
	{
		System.out.println("");
		System.out.println("Before....");
	}
	
	@Test
	public void Test1()
	{
		System.out.println("Test1....");
	}
	
	@Ignore
	public void Ignore1()
	{
		System.out.println("Ignore1");
	}
	
	@Test
	public void Test2()
	{
		System.out.println("Test2....");
	}
	
	@Test(timeout=50)
	public void Test3()
	{
		System.out.println("Test3....");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void Test4()
	{
		System.out.println("Test4....");
	}
	
	@After
	public void AfterAnnotate()
	{
		System.out.println("After...");
		System.out.println("");
	}
	
	
	@AfterClass
	public static void AfterClassAnnotate()
	{
		System.out.println("AfterClass");
		
	}
	
	
	
}
