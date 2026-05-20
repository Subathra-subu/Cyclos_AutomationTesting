/*package com.Actions;

import java.io.IOException;

import org.openqa.selenium.Keys;
import com.Pages.PaymentRequestPage;
import com.Utilities.ExcelData;
import com.Utilities.HelperClass;

public class ReqpaymentActions extends BaseAction {

    PaymentRequestPage paypage = new PaymentRequestPage();

    public void navigateToPaymentRequestPage() {
        click(paypage.Banking);
        click(paypage.paymentrequest);
    }

    public void clickSendRequest() {
        click(paypage.sendrequest);
    }

   public void clickExistingUser() {
	   jsClick(paypage.existingUser);
   }

  public String paymentPageAssert() {
	  return getText(paypage.paypageAssert);
  }
    

    public void printRequest() {
        click(paypage.print);
    }

    public void cancelRequest() {
        click(paypage.cancel);
    }

}

}*/
 