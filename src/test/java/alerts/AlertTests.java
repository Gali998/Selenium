package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptableAlert(){
        var alertsPage = homePage.clickJSAlert();
        alertsPage.triggerAlert();
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResults(),"You successfully clicked an alert","Result text incorrect");
    }


}
