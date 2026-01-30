package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {

    public static String videoUrl(String sessionId) {
        final BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
        String url = String.format(config.getBrowserstackAPI(), sessionId);
        String user = config.getUsername();
        String key = config.getKey();

        return given()
                .auth().basic(user, key)
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}