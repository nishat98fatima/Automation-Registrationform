package Utilities;

import org.openqa.selenium.WebElement;

public class common_methods {
	public static void send_keys(WebElement element, String Value) throws Throwable {
		try {
			if (Value.equals("") || Value == null) {
				System.out.println("Blank or null value found");
			} else {
				element.sendKeys(Value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
