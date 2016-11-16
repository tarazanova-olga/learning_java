package github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GitHubTests {

    @Test

    public void testCommits() throws IOException {
        Github github = new RtGithub("0bed79a37dc9c8ca11e5adc741928078d8d48e68"); //токен из гитхаба
        RepoCommits commits = github.repos().get(new Coordinates.Simple("tarazanova-olga", "learning_java")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }

}
