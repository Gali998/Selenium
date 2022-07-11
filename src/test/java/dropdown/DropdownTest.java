package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTests {

    @Test
    public void testSelectOption(){
        var dropDownPage =homePage.clickDropDown();

        String option = "Option 1";
        dropDownPage.selectFromDropdown(option);
        var selectedOptions = dropDownPage.getSelectedOption();
        assertEquals(selectedOptions.size(),1,"Incorrect no of selections");
        assertTrue(selectedOptions.contains(option),"Option not selected");
    }
}
