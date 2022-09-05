package SpeckBuilder;

import TokenManager.Token;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static Utility.Routes.BASE_PATH;
import static Utility.Routes.BASE_URI;

public class SpecBuilder {
   //static String Token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkb2N1bWVudElEIjoiYzhldnNyZGtoNGRvNzIyamJzZTAiLCJ1c2VybmFtZSI6Ik1pa2UiLCJyb2xlIjoiIiwibmFtZSI6Ik1pa2UiLCJlbWFpbCI6ImphZ2FucHJlZXQuc2luZ2grMDEyQGJyYXZ2b3guY29tIiwicGhvbmUiOiIiLCJpc0FkbWluIjpmYWxzZSwiaXNDb250ZW50Q3JlYXRvciI6ZmFsc2UsImlzVmVyaWZpZWQiOnRydWUsInN0YXR1cyI6ImFjdGl2ZSIsImluZmx1ZW5jZXJTdGF0dXMiOmZhbHNlLCJleHAiOjE2NTAyOTk2NDIsImlhdCI6MTY1MDI4MTY0MiwiaXNzIjoiQnJhdnZveCJ9.pNdxYelvh9NUWEiuQNqTZTlUw0Kvy_G57R1i5owo5w8";
    public static RequestSpecification getRequestSpec(){
    return new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setBasePath(BASE_PATH)
            .addHeader("Authorization",Token.token())
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL).build();
    // build method return the request specification
}
public static ResponseSpecification getResponseSpec(){
   return new ResponseSpecBuilder()
            .log(LogDetail.ALL).
            build();
}
}
