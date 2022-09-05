package GET_Method;
import TokenManager.Token;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileOutputStream;
import java.io.IOException;
public class Event_Details {
    String myresponse;
    @Test(description = "verify to get eventdetails successfully")
    @Epic("EP001")
    @Feature("Feature1 : verify the event detail")
    @Story("Event details")
    @Step("STEP 1: EVENT DETAILS")
    @Severity(SeverityLevel.MINOR)
    public void EventDetail() throws IOException {
//        given().
//                header("Authorization", Token.token())
//                .header("Accept", "application/json", "Content-Type", "multipart/from-data")
//                .when()
//                .get("https://qa.bravvox.com/services/event/v1/event/c97vkc8r67nih8v3ul1g")
//                .then()
//                .log().all().statusCode(200);
        RestAssured.baseURI = "https://qa.bravvox.com";
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", Token.token());
        request.header("Accept","application/json");
        request.header("Content-Type", "multipart/from-data");
        Response responseFormToken =   request.get("services/event/v1/event/c97vkc8r67nih8v3ul1g");
        myresponse = responseFormToken.asString();
        String split =myresponse;
        String str[] =split.split(",");
        String filename = ".\\Datafiles\\employee.xlsx";
//creating an instance of HSSFWorkbook class
        HSSFWorkbook workbook = new HSSFWorkbook();
//invoking creatSheet() method and passing the name of the sheet to be created
        HSSFSheet sheet = workbook.createSheet("January");
//creating the 0th row using the createRow() method
        HSSFRow rowhead = sheet.createRow((short)0);
//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method
        for(int i=0; i<str.length;i++) {
            rowhead.createCell(i).setCellValue(str[i]);
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
//closing the Stream
        fileOut.close();
        }
//closing the workbook
        workbook.close();
//prints the message on the console
        System.out.println("Excel file has been generated successfully.");

    }
}

