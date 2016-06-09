package com.vaadin.demo.dashboard.view;

import com.vaadin.demo.dashboard.data.dummy.DummyDataGenerator;
import com.vaadin.demo.dashboard.domain.ApiInfo;
import com.vaadin.demo.dashboard.event.DashboardEvent.UserLoginRequestedEvent;
import com.vaadin.demo.dashboard.event.DashboardEventBus;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.shared.Position;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;
import com.vaadin.ui.themes.ValoTheme;

import org.vaadin.addon.oauthpopup.OAuthListener;
import org.vaadin.addon.oauthpopup.OAuthPopupButton;
import org.vaadin.addon.oauthpopup.buttons.FacebookButton;
import org.vaadin.addon.oauthpopup.buttons.GitHubButton;
import org.vaadin.addon.oauthpopup.buttons.GooglePlusButton;
import org.vaadin.addon.oauthpopup.buttons.LinkedInButton;
import org.vaadin.addon.oauthpopup.buttons.TwitterButton;

@SuppressWarnings("serial")
public class LoginView extends VerticalLayout
{

    public LoginView() {
        setSizeFull();

        Component loginForm = buildLoginForm();
        addComponent(loginForm);
        setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);

        Notification notification = new Notification(
                "Welcome to Zeynin's Demo");
        notification
                .setDescription("<span>This application uses OAUTH delegate to leverage credentials to stream photos from 500px. Please enter a valid user/password.</span>");
        notification.setHtmlContentAllowed(true);
        notification.setStyleName("tray dark small closable login-help");
        notification.setPosition(Position.BOTTOM_CENTER);
        notification.setDelayMsec(20000);
        notification.show(Page.getCurrent());
    }

    private Component buildLoginForm() {
        final VerticalLayout loginPanel = new VerticalLayout();
        loginPanel.setSizeUndefined();
        loginPanel.setSpacing(true);
        Responsive.makeResponsive(loginPanel);
        loginPanel.addStyleName("login-panel");

        loginPanel.addComponent(buildLabels());
        loginPanel.addComponent(buildFields());
        loginPanel.addComponent( buildOauthButtons() );
        loginPanel.addComponent(new CheckBox("Remember me", true));

        return loginPanel;
    }

    private Component buildFields() {
        HorizontalLayout fields = new HorizontalLayout();
        fields.setSpacing(true);
        fields.addStyleName("fields");

        final TextField username = new TextField("Username");
        username.setIcon(FontAwesome.USER);
        username.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        final PasswordField password = new PasswordField("Password");
        password.setIcon(FontAwesome.LOCK);
        password.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        final Button signin = new Button("Sign In");
        signin.addStyleName(ValoTheme.BUTTON_PRIMARY);
        signin.setClickShortcut(KeyCode.ENTER);
        signin.focus();

        fields.addComponents(username, password, signin);
        fields.setComponentAlignment(signin, Alignment.BOTTOM_LEFT);

        signin.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(final ClickEvent event) {
                DashboardEventBus.post(new UserLoginRequestedEvent(username
                        .getValue(), password.getValue()));
            }
        });
        return fields;
    }

    private Component buildLabels() {
        CssLayout labels = new CssLayout();
        labels.addStyleName("labels");

        Label welcome = new Label("Welcome");
        welcome.setSizeUndefined();
        welcome.addStyleName(ValoTheme.LABEL_H4);
        welcome.addStyleName(ValoTheme.LABEL_COLORED);
        labels.addComponent(welcome);

        Label title = new Label("Zeynin's Dashboard");
        title.setSizeUndefined();
        title.addStyleName(ValoTheme.LABEL_H3);
        title.addStyleName(ValoTheme.LABEL_LIGHT);
        labels.addComponent(title);
        return labels;
    }
    /* taken from demo */

/*
	private final VerticalLayout layout = new VerticalLayout();

	@Override
	protected void init(VaadinRequest request) {

		layout.setMargin(true);
		layout.setSpacing(true);

		addTwitterButton();
		addFacebookButton();
		addLinkedInButton();
		addGitHubButton();

		addTwitterNativeButton();

		layout.addComponent(new Link("Add-on at Vaadin Directory", new ExternalResource("http://vaadin.com/addon/oauth-popup-add-on")));
		layout.addComponent(new Link("Source code at GitHub", new ExternalResource("https://github.com/ahn/vaadin-oauthpopup")));
	}
*/
	private Component addTwitterButton()
    {
		ApiInfo api = DummyDataGenerator.TWITTER_API;
		OAuthPopupButton button = new TwitterButton(api.apiKey, api.apiSecret);
		addButton(api, button);
        return button;
	}

	private Component addFacebookButton() {
		ApiInfo api = DummyDataGenerator.FACEBOOK_API;
		OAuthPopupButton button = new FacebookButton(api.apiKey, api.apiSecret);
		addButton(api, button);
        return button;
	}

    private Component addGPlusButton() {
        ApiInfo api = DummyDataGenerator.GOOGLEPLUS_API;
        OAuthPopupButton button = new GooglePlusButton(api.apiKey, api.apiSecret);
        addButton(api, button);
        return button;
    }

	private Component addLinkedInButton() {
		ApiInfo api = DummyDataGenerator.LINKEDIN_API;
		OAuthPopupButton button = new LinkedInButton(api.apiKey, api.apiSecret);
		addButton(api, button);
        return button;
	}

	private Component addGitHubButton() {
		ApiInfo api = DummyDataGenerator.GITHUB_API;
		OAuthPopupButton button = new GitHubButton(api.apiKey, api.apiSecret);
		addButton(api, button);
        return button;
	}
/*
	private void addTwitterNativeButton() {
		final NativeButton b = new NativeButton("Another Twitter Auth Button");

		OAuthPopupOpener opener = new OAuthPopupOpener(
				TWITTER_API.scribeApi,
				TWITTER_API.apiKey,
				TWITTER_API.apiSecret);
		opener.extend(b);
		opener.addOAuthListener(new OAuthListener() {
			@Override
			public void authSuccessful(String accessToken,
					String accessTokenSecret, String oauthRawResponse) {
				Notification.show("authSuccessful");
			}

			@Override
			public void authDenied(String reason) {
				Notification.show("authDenied");
			}
		});

		layout.addComponent(b);
	}
*/
	private void addButton( final ApiInfo service, OAuthPopupButton button) {

    // In most browsers "resizable" makes the popup
    // open in a new window, not in a tab.
    // You can also set size with eg. "resizable,width=400,height=300"
    button.setPopupWindowFeatures("resizable,width=400,height=300");

    HorizontalLayout hola = new HorizontalLayout();
    hola.setSpacing(true);
    hola.addComponent(button);

    //layout.addComponent(hola);

    button.addOAuthListener(new Listener(service, hola));
}

	private class Listener implements OAuthListener
    {

		private final ApiInfo service;
		private final HorizontalLayout hola;

		private Listener(ApiInfo service, HorizontalLayout hola) {
			this.service = service;
			this.hola = hola;
		}

		@Override
		public void authSuccessful(final String accessToken,
				final String accessTokenSecret, String oauthRawResponse)
        {
			hola.addComponent(new Label("Authorized " + service.name + "." ));

			Button testButton = new Button("Test " + service.name + " API");
			testButton.addStyleName( BaseTheme.BUTTON_LINK);
			hola.addComponent(testButton);
			testButton.addClickListener(new ClickListener()
            {
				@Override
				public void buttonClick(ClickEvent event)
                {
                    int i = 0;
                    /*
					GetTestComponent get = new GetTestComponent(service,
							accessToken, accessTokenSecret);
					Window w = new Window(service.name, get);
					w.center();
					w.setWidth("75%");
					w.setHeight("75%");
					addWindow(w);
					*/
				}
			});

		}

		@Override
		public void authDenied(String reason) {
			hola.addComponent(new Label("Auth failed."));
		}
	}



    private Component buildOauthButtons()
    {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        buttons.addStyleName("buttons");

        buttons.addComponents( addGPlusButton(), addTwitterButton(), addLinkedInButton(), addGitHubButton() );
/*
        OAuthPopupButton gplus, facebook, linkedin, twitter;
        String key = "xHkW9aeTnoYk4k1lUYicCjbKY9VXjYOWxE3OsBt8";
        String secret = "Bxh2d4fDMCJm1DTMCYGY9PcfQ0gvJMwTC0McYVEM";

        // GPlus
        gplus = new GooglePlusButton( key, secret );

        // Facebook; you could ask for email w/ this
        facebook = new FacebookButton( key, secret );

        // LinkedIn
        linkedin = new LinkedInButton( key, secret );

        // Twitter
        twitter = new TwitterButton( key, secret );

        OAuthListener oauthListener = new OAuthListener()
        {
            @Override
            public void authSuccessful(String accessToken, String accessTokenSecret, String accessRawResp )
            {
                Notification.show("Authorized");
                // TODO: do something with the access token
            }

            @Override
            public void authDenied(String reason)
            {
                Notification.show("Authorization denied");
            }
        };

        gplus.addOAuthListener( oauthListener );
        facebook.addOAuthListener( oauthListener );
        linkedin.addOAuthListener( oauthListener );
        twitter.addOAuthListener( oauthListener );

        buttons.addComponents( gplus, facebook, linkedin, twitter );
*/
        return buttons;
    }

/*
    private Component buildGPlusLogin()
    {
        String GPLUS_KEY = "xHkW9aeTnoYk4k1lUYicCjbKY9VXjYOWxE3OsBt8";
        String GPLUS_SECRET = "Bxh2d4fDMCJm1DTMCYGY9PcfQ0gvJMwTC0McYVEM";

        OAuthPopupButton ob = new GooglePlusButton( GPLUS_KEY, GPLUS_SECRET );

        ob.addOAuthListener(new OAuthListener() {
            @Override
            public void authSuccessful(String accessToken, String accessTokenSecret, String accessRawResp )
            {
                Notification.show("Authorized");
                // TODO: do something with the access token
            }

            @Override
            public void authDenied(String reason)
            {
                Notification.show("Authorization denied");
            }
        });

        return ob;
    }

    private Component buildFacebookLogin()
    {
        String FACEBOOK_KEY = "xHkW9aeTnoYk4k1lUYicCjbKY9VXjYOWxE3OsBt8";
        String FACEBOOK_SECRET = "Bxh2d4fDMCJm1DTMCYGY9PcfQ0gvJMwTC0McYVEM";

        OAuthPopupButton ob = new FacebookButton( FACEBOOK_KEY, FACEBOOK_SECRET );

        return ob;
    }

    private Component buildLinkedInLogin()
    {
        String LINKEDIN_KEY = "xHkW9aeTnoYk4k1lUYicCjbKY9VXjYOWxE3OsBt8";
        String LINKEDIN_SECRET = "Bxh2d4fDMCJm1DTMCYGY9PcfQ0gvJMwTC0McYVEM";

        OAuthPopupButton ob = new FacebookButton( LINKEDIN_KEY, LINKEDIN_SECRET );

        return ob;
    }
*/
/*
    private Component buildOtherLogin()
    {
        OAuthListener oauthListener = new OAuthListener()
        {
            public void userAuthenticated(User user) {
                OAuthWindow.this.setContent(new LoggedInView(user));
            }

            public void failed(String reason) {
                OAuthWindow.this.showNotification("Login failed", reason,
                        Notification.TYPE_ERROR_MESSAGE);
            }
        };
        // LinkedIn
        addComponent(new LinkedinButton("LINKEDIN_API_KEY", "LINKEDIN_API_SECRET",
                oauthListener));

        // Facebook; you could ask for email w/ this
        addComponent(new FacebookButton("FACEBOOK_API_KEY",
                "FACEBOOK_API_SECRET", oauthListener));

        // Twitter
        addComponent(new TwitterButton("TWITTER_API_KEY",
                "TWITTER_API_SECRET", oauthListener));
    }
*/
}
