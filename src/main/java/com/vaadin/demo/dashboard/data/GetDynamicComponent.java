package com.vaadin.demo.dashboard.data;

import com.vaadin.demo.dashboard.domain.ApiInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

/**
 * Created by Zeynin on 2016-06-10.
 */
public class GetDynamicComponent
{
    private final VerticalLayout layout = new VerticalLayout();
    private final Token accessToken;
    private final ApiInfo service;
    private TextArea responseArea;

    GetDynamicComponent(ApiInfo service, String accessToken, String accessTokenSecret)
    {
        //setSizeFull();

        //setContent(layout);
        layout.setSizeFull();

        this.service = service;
        this.accessToken = new Token(accessToken, accessTokenSecret);

        layout.setMargin(true);
        final TextField field = new TextField("Request:", "https://api.500px.com/v1/photos?feature=popular");
        field.setWidth("100%");
        layout.addComponent(field);

        Button bu = new Button("GET");
        layout.addComponent(bu);
        bu.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                sendGet(field.getValue());
            }
        });

        Button buttonPUT = new Button("PUT");
        layout.addComponent(buttonPUT);
        buttonPUT.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                sendPut(field.getValue());
            }
        });

        responseArea = new TextArea("Response:");
        responseArea.setSizeFull();
        layout.addComponent(responseArea);
        layout.setExpandRatio(responseArea, 1);
    }

    private void sendGet(String get) {
        OAuthRequest request = new OAuthRequest( Verb.GET, get);
        createOAuthService().signRequest(accessToken, request);
        Response resp = request.send();
        responseArea.setValue(resp.getBody());

    }

    private void sendPut(String get) {
        OAuthRequest request = new OAuthRequest(Verb.PUT, get);
        createOAuthService().signRequest(accessToken, request);
        Response resp = request.send();
        responseArea.setValue(resp.getBody());

    }

    private OAuthService createOAuthService() {
        ServiceBuilder sb = new ServiceBuilder();
        sb.provider(service.getScribeApi());
        sb.apiKey(service.getApiKey());
        sb.apiSecret(service.getApiSecret());
        sb.callback("http://www.google.fi");
        return sb.build();
    }

}


/*

    private static String getPx500PhotoStream()
    {
        final String PROTECTED_RESOURCE_URL = "https://api.500px.com/v1/";

        OAuthService service = new ServiceBuilder()
                .provider( DummyDataGenerator._500PX_API.getScribeApi() )
                .apiKey( DummyDataGenerator._500PX_API.getApiKey() )
                .apiSecret( DummyDataGenerator._500PX_API.getApiSecret() )
                .build();
        Scanner in = new Scanner(System.in);

        System.out.println("=== 500Px's OAuth Workflow ===");
        System.out.println();

        // Obtain the Request Token
        System.out.println("Fetching the Request Token...");
        Token requestToken = service.getRequestToken();
        System.out.println("Got the Request Token!");
        System.out.println();

        System.out.println("Now go and authorize Scribe here:");
        System.out.println(service.getAuthorizationUrl(requestToken));
        System.out.println("And paste the verifier here");
        System.out.print(">>");
        Verifier verifier = new Verifier(in.nextLine());
        System.out.println();

        // Trade the Request Token and Verfier for the Access Token
        System.out.println("Trading the Request Token for an Access Token...");
        Token accessToken = service.getAccessToken(requestToken, verifier);
        System.out.println("Got the Access Token!");
        System.out.println("(if your curious it looks like this: " + accessToken + " )");
        System.out.println();

        // Now let's go and ask for a protected resource!
        System.out.println("Now we're going to access a protected resource...");
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
        service.signRequest(accessToken, request);
        Response response = request.send();
        System.out.println("Got it! Lets see what we found...");
        System.out.println();
        System.out.println(response.getBody());

        System.out.println();
        System.out.println("Thats it man! Go and build something awesome with Scribe! :)");

        return response.getBody();
    }


	public void GetTestComponent( ApiInfo service )
	{
		Token token = new Token( service.getApiKey(), service.getApiSecret() );

		//final TextField field = new TextField("Request:", service.exampleGetRequest);

    	px500Response = sendGet( token, service );
        px500Api = service;

		//responseArea = new TextArea("Response:");
		//responseArea.setSizeFull();
	}

	private static String sendGet(Token token, ApiInfo service)
	{
		OAuthRequest request = new OAuthRequest(Verb.GET, service.getExampleGetRequest());
		createOAuthService( service ).signRequest(token, request);
		Response resp = request.send();
		//responseArea.setValue(resp.getBody());
        return resp.getBody();
	}

	private static OAuthService createOAuthService( ApiInfo service )
	{
		ServiceBuilder sb = new ServiceBuilder();
		sb.provider(service.getScribeApi());
		sb.apiKey(service.getApiKey());
		sb.apiSecret(service.getApiSecret());
		//sb.callback("http://www.google.fi");
		return sb.build();
	}
*/