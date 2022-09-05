package POST_Method;
import DataDriven.XLUtils;
import POJO_Classes.CreateEvent_POJO;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import static SpeckBuilder.SpecBuilder.getRequestSpec;
import static SpeckBuilder.SpecBuilder.getResponseSpec;
import static Utility.Routes.END_POINT;
import static io.restassured.RestAssured.given;

public class CreateEvent {
    @Test(dataProvider = "CreateEvent")
    @Description("Verify event create successfully")
    @Epic("EP002")
    @Feature("Feature1 : verify that event create successfully")
    @Story("Event details")
    @Step("STEP 1: EVENT DETAILS")
    @Severity(SeverityLevel.CRITICAL)
   public  void CreateEvent(String Title,String Subtitle,String Details,String EventStartTime,String EventEndTime,String Location, String s, String m, String l , String p)
    {
        // use builder pattern in POJO
        CreateEvent_POJO request = new CreateEvent_POJO().
                //setTitle("Country  game")
                setTitle(Title).
                setSubtitle(Subtitle).
                setDetails(Details).
                setEventStartTime(EventStartTime).
                setEventEndTime(EventEndTime).
                setLocation(Location).
                setRequireAttendeeApproval(true).
                setIsModerated(false).
                setIsPostingOpen(true).
                setIsPublic(true);
     given(getRequestSpec())
                .body(request)
                .when().post(END_POINT).then().spec(getResponseSpec()).assertThat().statusCode(200);
//              .extract().response().as(CreateEvent_POJO.class);
//        assertThat(response.getTitle(), equalTo(request.getTitle()));
//       assertThat(response.getSubtitle(), equalTo(request.getSubtitle()));
    }
    @DataProvider(name="CreateEvent")
    Object[][] getCreateEvent() throws IOException {
        // Read data from excel
        String path="C:\\Users\\VivekJoshi\\IdeaProjects\\Dandy\\APIFramework\\src\\test\\java\\DataDriven\\Book 16.xlsx";
        int rownum= XLUtils.getRowCount(path,"Sheet1");
        int column=XLUtils.getCellCount(path,"Sheet1",1);
        // here we define static array to get same number of rows and coum in the excel sheet
        String[][] empdata = new String[rownum][column];
        for(int i=1;i<=rownum;i++){
            for(int j=0;j<column;j++)  {
                empdata[i-1][j]=XLUtils.getcelldata(path,"Sheet1",i,j);
            }
        }
        //String empdata [][]={{"abc123","tesla"},{"cde123","tata"},{"efg","mahindra"}};
        return empdata;
    }
}
