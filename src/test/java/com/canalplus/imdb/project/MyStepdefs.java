package com.canalplus.imdb.project;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import java.util.Objects;

@CucumberContextConfiguration
public class MyStepdefs {

    RestTemplate restTemplate;
    ResponseEntity responsed;

    static String expectedFindTitle = "[{\"name\":\"Carmencita\",\"profession\":\"soundtrack\"},{\"name\":\"Oskar Messter\",\"profession\":\"producer,director,writer\"},{\"name\":\"William Heise\",\"profession\":\"cinematographer,director,producer\"},{\"name\":\"William K.L. Dickson\",\"profession\":\"cinematographer,director,producer\"}]";

    static String expectedFindCrew = "[{\"primaryTitle\":\"Quick Fix: Denim on Denim\",\"episodeNumber\":91334},{\"primaryTitle\":\"HDIL Quick Fix: Maxi Dresses\",\"episodeNumber\":72615},{\"primaryTitle\":\"Episode #1.46002\",\"episodeNumber\":46002},{\"primaryTitle\":\"Episode #1.40000\",\"episodeNumber\":40000},{\"primaryTitle\":\"25k Views Super Spectacular\",\"episodeNumber\":25000},{\"primaryTitle\":\"Episode #1.23478\",\"episodeNumber\":23478},{\"primaryTitle\":\"Episode #1.21907\",\"episodeNumber\":21907},{\"primaryTitle\":\"BBC 6 O'Clock News\",\"episodeNumber\":20008},{\"primaryTitle\":\"8 News Now at 5\",\"episodeNumber\":18081},{\"primaryTitle\":\"Episode #1.16607\",\"episodeNumber\":16607}]";

    String apiMostEpisode = "http://localhost:8080/canalplus/imdb/mostepisode/";
    String apiTitle = "http://localhost:8080/canalplus/imdb/crews/";




    @Rule
    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().port(8080).httpsPort(8443));

    @Before
    public void setup()  {

        restTemplate = new RestTemplate();
        responsed = null;

    }


    @Given("I enter the title {string}")
    public void iEnterTheTitle(String title) {
        StringBuilder apiCallTitle = new StringBuilder(apiTitle);
        responsed =  restTemplate.getForEntity(apiCallTitle.append(title).toString(), String.class);
    }

    @Then("the requested data is returned")
    public void theRequestedDataIsReturned() {
        Assertions.assertEquals(Objects.requireNonNull(responsed.getBody()).toString(), expectedFindTitle);
    }


    @Given("I call the API for this")
    public void iCallTheAPIForThis() {
        responsed =  restTemplate.getForEntity(apiMostEpisode, String.class);
    }

    @Then("the answer returned is the most greteast number episodes")
    public void theAnswerReturnedIsTheMostGreteastNumberEpisodes() {
        Assertions.assertEquals(Objects.requireNonNull(responsed.getBody()).toString(), expectedFindCrew);
    }
}
