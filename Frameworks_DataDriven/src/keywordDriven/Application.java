package keywordDriven;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {
	
	@Test
	public void getTextExe() throws IOException {
		String[][] data = GenericMethods.getData("C:\\Ritu\\Selenium Training\\TestData.xlsx", "Sheet3");
		
		for (int i=1;i<data.length; i++) {
			switch(data[i][3]) {
			
			case"Launch_App":
			Method.Launch_App(data[i][6]);
			break;
			
			case"Imp_Wait":
			Method.Imp_Wait();
			break;
			
			case"Set_TextBox":
			Method.Set_TextBox(data[i][5], data[i][6]);
			break;
			
			case"Click_Submit":
			Method.Click_Submit(data[i][5]);
			break;
			
			case"Verify_Msg":
			String ActMsg=Method.Verify_Msg(data[i][5]);
			String ExpMsg=data[i][6];
			Assert.assertEquals(ActMsg, ExpMsg);
			break;
			
			case"Close_App":
			Method.Close_App();
			break;
		
			}
		}
	
	}

}
