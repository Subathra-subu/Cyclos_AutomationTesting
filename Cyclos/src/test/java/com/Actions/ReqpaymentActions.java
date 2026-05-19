/*package com.Actions;

import java.io.IOException;

import org.openqa.selenium.Keys;
import com.Pages.PaymentRequestPage;
import com.Utilities.ExcelData;
import com.Utilities.HelperClass;

public class ReqpaymentActions extends BaseAction {

    PaymentRequestPage paypage = new PaymentRequestPage();

    public void navigatetoPayRequest() {
        click(paypage.Banking);
        click(paypage.paymentrequest);
    }

    public void clickSendRequest() {
        click(paypage.sendrequest);
    }

    public void excelPaymentData() throws IOException {

        ExcelData excelData = new ExcelData();

        Object[][] data = excelData.getExcelData(
                "src/test/resources/testData/ExcelData.xlsx",
                "PaymentRequest_Krishna"
        );

        for (Object[] row : data) {

            String receiver = row[0].toString();
            String amount = row[1].toString();
            String date = row[2].toString();

             enterPaymentDetails(receiver, amount, date);
        }


    }
    public void confirmRequest() {
        click(paypage.confirm);
    }

    public void printRequest() {
        click(paypage.print);
    }

    public void cancelRequest() {
        click(paypage.cancel);
    }
}*/
