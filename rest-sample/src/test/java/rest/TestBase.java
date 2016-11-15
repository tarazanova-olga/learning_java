package rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;

import java.io.IOException;

public class TestBase {

    private boolean isIssueOpen(int issueId) throws IOException {
        String json = RestAssured.get("http://demo.bugify.com/api/issues/"+issueId+".json").asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issue = parsed.getAsJsonObject().get("issues").getAsJsonArray().get(0);
        Issue goalIssue = new Gson().fromJson(issue, Issue.class);
        if (!goalIssue.getState_name().equals("Closed") && !goalIssue.getState_name().equals("Resolved")){
            return true;
        } else {
            return false;
        }
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }
}
