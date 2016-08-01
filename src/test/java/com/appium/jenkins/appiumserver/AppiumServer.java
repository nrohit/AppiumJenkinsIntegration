package com.appium.jenkins.appiumserver;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

public class AppiumServer {

	
	public void startAppium() throws ExecuteException, IOException, InterruptedException{
		CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
		command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);
		command.addArgument("--address", false);
		command.addArgument("127.0.0.1");
		command.addArgument("--port", false);
		command.addArgument("4723");
		command.addArgument("--no-reset", false);
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command, resultHandler);
		Thread.sleep(3000);
	}
	
	public void stopAppium() throws IOException{
		Runtime.getRuntime().exec("killall node");
	}
	
	public void adbPermisions() throws IOException{
		Runtime.getRuntime().exec("/Users/rohit/Library/Android/sdk/platform-tools/adb shell pm grant com.driveu.customer android.permission.READ_PHONE_STATE");
		Runtime.getRuntime().exec("/Users/rohit/Library/Android/sdk/platform-tools/adb shell pm grant com.driveu.customer android.permission.ACCESS_FINE_LOCATION");
		Runtime.getRuntime().exec("/Users/rohit/Library/Android/sdk/platform-tools/adb shell pm grant com.driveu.customer android.permission.ACCESS_COARSE_LOCATION");
		Runtime.getRuntime().exec("/Users/rohit/Library/Android/sdk/platform-tools/adb shell pm grant com.driveu.customer android.permission.WAKE_LOCK");
		Runtime.getRuntime().exec("/Users/rohit/Library/Android/sdk/platform-tools/adb shell pm grant com.driveu.customer android.permission.RECEIVE_SMS");
		Runtime.getRuntime().exec("/Users/rohit/Library/Android/sdk/platform-tools/adb shell pm grant com.driveu.customer android.permission.READ_SMS");
		Runtime.getRuntime().exec("/Users/rohit/Library/Android/sdk/platform-tools/adb shell pm grant com.driveu.customer android.permission.CALL_PHONE");
		Runtime.getRuntime().exec("/Users/rohit/Library/Android/sdk/platform-tools/adb shell pm grant com.driveu.customer android.permission.INTERNET");
		Runtime.getRuntime().exec("/Users/rohit/Library/Android/sdk/platform-tools/adb shell pm grant com.driveu.customer android.permission.android.permission.ACCESS_NETWORK_STATE");
	}
	
}

