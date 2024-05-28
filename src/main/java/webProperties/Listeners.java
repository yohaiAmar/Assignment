package webProperties;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println( "--------"+result.getName()+" started ----------");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println( "--------"+result.getName()+" passed ----------");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println( "--------"+result.getName()+" failed ----------");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println( "--------"+result.getName()+" was skipped ----------");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println( "--------"+result.getName()+" failed with percentage ----------");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println( "--------"+result.getName()+" didn't end on time ----------");
    }

    @Override
    public void onStart(ITestContext context) {
        // no real need for those right now
    }

    @Override
    public void onFinish(ITestContext context) {
        // also for this
    }
}
