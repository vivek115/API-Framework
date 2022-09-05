package TokenManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static Utility.Routes.BASE_URI;
import static Utility.Routes.TOKEN;

public class Token {
    @Test
    public static String token() {
        		String[] items = null;
		String token;

		// User Token Generate
        RestAssured.baseURI = BASE_URI;

		RequestSpecification request = RestAssured.given();

		String payload = "{\r\n"
				+ "    \"username\": \"Mike\",\r\n"
				+ "    \"password\": \"Test123@\"\r\n"
				+ "}\r\n"
				+ "}";

		request.header("Content-Type","application/json");
		Response responseFormToken =   request.body(payload).post(TOKEN);
		String jsont = responseFormToken.asString();
		responseFormToken.prettyPrint();
		String[] couple = jsont.split("\",\"refreshToken\"");
		String[] nexts = couple[0].split("token\":\"");
		return nexts[1];
     }
     }

