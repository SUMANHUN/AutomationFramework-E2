package Vtiger.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * This class provides implimentation to ITestlistener interface of TestNg
 * @author suman
 *
 */
public class ListenerImplimentationClass implements ITestListener 
{

	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("------Execution Started-----"+methodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("------Pass-----"+methodName);
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("------Fail-----"+methodName);
		
		System.out.println(result.getThrowable());
		
		WebDriverUtility wu = new  WebDriverUtility();
		JavaUtilities ju = new JavaUtilities();
		
		String screenshotName = methodName+ju.getSystemDateInFormat();
		/*take screen shot for failed test scripts- to attach with bug rising*/
		try {
			wu.takeScreenShot(BaseClass.sdriver, screenshotName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("------SKIP-----"+methodName);
		
		System.out.println(result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("------Suite Execution Started-----");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("------Suite Execution Ended-----");
		
	}
	
	

}
