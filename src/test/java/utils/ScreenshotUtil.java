package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    /**
     * Captures a screenshot, saves it to ./screenshots/<sanitizedTestName>_yyyyMMdd_HHmmss.png
     * and returns the saved file path.
     */
    public static String captureScreenshot(WebDriver driver, String testName) {
        if (driver == null) return null;

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String dir = "screenshots";
        Path screenshotsDir = Paths.get(dir);

        try {
            Files.createDirectories(screenshotsDir);
        } catch (IOException e) {
            System.err.println("Could not create screenshots directory: " + e.getMessage());
        }

        // sanitize testName for filesystem
        String safeName = testName == null ? "screenshot" : testName.replaceAll("[^a-zA-Z0-9-_\\.]", "_");
        String fileName = safeName + "_" + timestamp + ".png";
        Path destination = screenshotsDir.resolve(fileName);

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(src.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved at: " + destination.toString());
            return destination.toString();
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
            return null;
        }
    }

    /**
     * Returns screenshot as byte[] (useful for scenario.attach in Cucumber).
     */
    public static byte[] getScreenshotAsBytes(WebDriver driver) {
        if (driver == null) return new byte[0];
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
