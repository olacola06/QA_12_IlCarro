package manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListenerNG implements ITestListener {
    Logger logger = LoggerFactory.getLogger(MyListenerNG.class);

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        logger.info("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info("onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        logger.info("onTestFailure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        logger.info("onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        logger.info("onTestFailedButWithinSuccessPercentage");

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        logger.info("onTestFailedWithTimeout");
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        logger.info("onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        logger.info("onFinish");
    }
}
