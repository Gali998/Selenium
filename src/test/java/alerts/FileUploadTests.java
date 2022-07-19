package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {
   
    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        //uploadPage.uploadFile("C:/Users/gmannage/Downloads/ChromeSetup");
        assertEquals(uploadPage.getUploadFiles(),"chromedriver.exe","uploaded successfully");
    }


}
