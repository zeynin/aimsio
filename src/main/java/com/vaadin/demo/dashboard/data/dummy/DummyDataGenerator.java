package com.vaadin.demo.dashboard.data.dummy;

import com.vaadin.addon.charts.model.style.Color;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.demo.dashboard.domain.ApiInfo;
import com.vaadin.demo.dashboard.domain.DashboardNotification;

import org.scribe.builder.api.FacebookApi;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.builder.api.Px500Api;
import org.scribe.builder.api.TwitterApi;
import org.vaadin.addon.oauthpopup.buttons.GitHubApi;
import org.vaadin.addon.oauthpopup.buttons.GooglePlusApi;

import java.util.Arrays;
import java.util.Collection;

public abstract class DummyDataGenerator {

    static String randomFirstName() {
        String[] names = { "Dave", "Mike", "Katherine", "Jonas", "Linus",
                "Bob", "Anne", "Minna", "Elisa", "George", "Mathias", "Pekka",
                "Fredrik", "Kate", "Teppo", "Kim", "Samatha", "Sam", "Linda",
                "Jo", "Sarah", "Ray", "Michael", "Steve" };
        return names[(int) (Math.random() * names.length)];
    }

    static String randomLastName() {
        String[] names = { "Smith", "Lehtinen", "Chandler", "Hewlett",
                "Packard", "Jobs", "Buffet", "Reagan", "Carthy", "Wu",
                "Johnson", "Williams", "Jones", "Brown", "Davis", "Moore",
                "Wilson", "Taylor", "Anderson", "Jackson", "White", "Harris",
                "Martin", "King", "Lee", "Walker", "Wright", "Clark",
                "Robinson", "Garcia", "Thomas", "Hall", "Lopez", "Scott",
                "Adams", "Barker", "Morris", "Cook", "Rogers", "Rivera",
                "Gray", "Price", "Perry", "Powell", "Russell", "Diaz" };
        return names[(int) (Math.random() * names.length)];
    }

    static String randomCompanyName() {

        String name = randomName();
        if (Math.random() < 0.03) {
            name += " Technologies";
        } else if (Math.random() < 0.02) {
            name += " Investment";
        }
        if (Math.random() < 0.3) {
            name += " Inc";
        } else if (Math.random() < 0.2) {
            name += " Ltd.";
        }

        return name;
    }

    public static String randomWord(int len, boolean capitalized) {
        String[] part = { "ger", "ma", "isa", "app", "le", "ni", "ke", "mic",
                "ro", "soft", "wa", "re", "lo", "gi", "is", "acc", "el", "tes",
                "la", "ko", "ni", "ka", "so", "ny", "mi", "nol", "ta", "pa",
                "na", "so", "nic", "sa", "les", "for", "ce" };
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            String p = part[(int) (Math.random() * part.length)];
            if (i == 0 && capitalized) {
                p = Character.toUpperCase(p.charAt(0)) + p.substring(1);
            }
            sb.append(p);
        }
        return sb.toString();

    }

    public static String randomText(int words) {
        StringBuffer sb = new StringBuffer();
        int sentenceWordsLeft = 0;
        while (words-- > 0) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            if (sentenceWordsLeft == 0 && words > 0) {
                sentenceWordsLeft = (int) (Math.random() * 15);
                sb.append(randomWord(1 + (int) (Math.random() * 3), true));
            } else {
                sentenceWordsLeft--;
                sb.append(randomWord(1 + (int) (Math.random() * 3), false));
                if (words > 0 && sentenceWordsLeft > 2 && Math.random() < 0.2) {
                    sb.append(',');
                } else if (sentenceWordsLeft == 0 || words == 0) {
                    sb.append('.');
                }
            }
        }
        return sb.toString();
    }

    static String randomName() {
        int len = (int) (Math.random() * 4) + 1;
        return randomWord(len, true);
    }

    static String randomTitle(int words) {
        StringBuffer sb = new StringBuffer();
        int len = (int) (Math.random() * 4) + 1;
        sb.append(randomWord(len, true));
        while (--words > 0) {
            len = (int) (Math.random() * 4) + 1;
            sb.append(' ');
            sb.append(randomWord(len, false));
        }
        return sb.toString();
    }

    static String randomHTML(int words) {
        StringBuffer sb = new StringBuffer();
        while (words > 0) {
            sb.append("<h2>");
            int len = (int) (Math.random() * 4) + 1;
            sb.append(randomTitle(len));
            sb.append("</h2>");
            words -= len;
            int paragraphs = 1 + (int) (Math.random() * 3);
            while (paragraphs-- > 0 && words > 0) {
                sb.append("<p>");
                len = (int) (Math.random() * 40) + 3;
                sb.append(randomText(len));
                sb.append("</p>");
                words -= len;
            }
        }
        return sb.toString();
    }

    static Collection<DashboardNotification> randomNotifications() {
        DashboardNotification n1 = new DashboardNotification();
        n1.setId(1);
        n1.setFirstName(randomFirstName());
        n1.setLastName(randomLastName());
        n1.setAction("created a new report");
        n1.setPrettyTime("25 minutes ago");
        n1.setContent(randomText(18));

        DashboardNotification n2 = new DashboardNotification();
        n2.setId(2);
        n2.setFirstName(randomFirstName());
        n2.setLastName(randomLastName());
        n2.setAction("changed the schedule");
        n2.setPrettyTime("2 days ago");
        n2.setContent(randomText(10));

        return Arrays.asList(n1, n2);
    }

    public static int[] randomSparklineValues(int howMany, int min, int max) {
        int[] values = new int[howMany];

        for (int i = 0; i < howMany; i++) {
            values[i] = (int) (min + (Math.random() * (max - min)));
        }

        return values;
    }

    public static Color[] chartColors = new Color[] {
            new SolidColor("#3090F0"), new SolidColor("#18DDBB"),
            new SolidColor("#98DF58"), new SolidColor("#F9DD51"),
            new SolidColor("#F09042"), new SolidColor("#EC6464") };


    // Twitter test application at http://localhost:8080
    public static final ApiInfo TWITTER_API = new ApiInfo("Twitter",
            TwitterApi.class,
            "31ssXGMU4WW6KPxWwT6IMQ",
            "FR3wJmGyGAdpQMxB3vMreED2UnsHVb6nPF16f1RrtU",
            "https://api.twitter.com/1.1/account/settings.json");

    // Facebook test application at http://localhost:8080
    public static final ApiInfo FACEBOOK_API = new ApiInfo("Facebook",
            FacebookApi.class,
            "170732353126405",
            "dd59293cda395bf38a88044c22937e7e",
            "https://graph.facebook.com/me");

    // GPlus test application at http://localhost:8080
    public static final ApiInfo GOOGLEPLUS_API = new ApiInfo("GooglePlus",
            GooglePlusApi.class,
            "xHkW9aeTnoYk4k1lUYicCjbKY9VXjYOWxE3OsBt8",
            "Bxh2d4fDMCJm1DTMCYGY9PcfQ0gvJMwTC0McYVEM",
            "https://www.google.com/accounts/OAuthLogin");
//https://www.googleapis.com/auth/plus.login

    // 500px test application at http://localhost:8080 - doesn't work...yet
    public static final ApiInfo _500PX_API = new ApiInfo("500px",
            Px500Api.class,
            "5oJJ6EvqsIm5Tx1LQGl45Ke3sqo9I1XSzLjhA52N",
            "wCBjfRcqQSLhnqaMY50B5CsYpwCBYwkoAFcZZHlR",
            "https://api.500px.com/v1/oauth/authorize");
//https://api.500px.com/v1/oauth/authorize?oauth_token=zqY2kFgULeIuQJgvNsd9wQQwxBMTxVn21kLO0sOF
    // LinkedIn test application at http://localhost:8080
    public static final ApiInfo LINKEDIN_API = new ApiInfo("LinkedIn",
            LinkedInApi.class,
            "bp0aa1rxk2re",
            "Q2Na42cZmVs3OWnI",
            "https://api.linkedin.com/v1/people/~");

    public static final ApiInfo GITHUB_API = new ApiInfo("GitHub",
            GitHubApi.class,
            "97a7e251c538106e7922",
            "6a36b0992e5e2b00a38c44c21a6e0dc8ae01d83b",
            "https://api.github.com/user");

}