package com.vaadin.demo.dashboard.view;

import com.vaadin.demo.dashboard.data.dummy.DummyDataGenerator;
import com.vaadin.demo.dashboard.data.dummy.DummyDataProvider;
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
import com.vaadin.ui.themes.ValoTheme;

import org.scribe.builder.api.Px500Api;
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
    private static Button signin;

    public LoginView()
    {
        setSizeFull();

        Component loginForm = buildLoginForm();
        addComponent(loginForm);
        setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);

        Notification notification = new Notification(
                "Welcome to Zeynin's Demo");
        notification
                .setDescription("<span>This application uses OAUTH delegate to leverage credentials " +
                        "to stream photos from 500px. Please select 500px and authorize.</span>");
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

        signin = new Button("Sign In");
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

    private Component buildOauthButtons()
    {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        buttons.addStyleName( ValoTheme.BUTTON_PRIMARY );
        //buttons.addComponents( add500pxButton(), addTwitterButton(), addLinkedInButton(), addGitHubButton() );
        Component px500btn = add500pxButton();
        buttons.addComponent( px500btn );
        buttons.setComponentAlignment( px500btn, Alignment.BOTTOM_LEFT );

        return buttons;
    }

	private Component addTwitterButton()
    {
		ApiInfo api = DummyDataGenerator.TWITTER_API;
		OAuthPopupButton button = new TwitterButton(api.getApiKey(), api.getApiSecret());
		addButton(api, button);
        return button;
	}

	private Component addFacebookButton() {
		ApiInfo api = DummyDataGenerator.FACEBOOK_API;
		OAuthPopupButton button = new FacebookButton(api.getApiKey(), api.getApiSecret());
		addButton(api, button);
        return button;
	}

    private Component addGPlusButton()
    {
        ApiInfo api = DummyDataGenerator.GOOGLEPLUS_API;
        OAuthPopupButton button = new GooglePlusButton(api.getApiKey(), api.getApiSecret());
        addButton(api, button);
        return button;
    }

	private Component addLinkedInButton() {
		ApiInfo api = DummyDataGenerator.LINKEDIN_API;
		OAuthPopupButton button = new LinkedInButton(api.getApiKey(), api.getApiSecret());
		addButton(api, button);
        return button;
	}

	private Component addGitHubButton() {
		ApiInfo api = DummyDataGenerator.GITHUB_API;
		OAuthPopupButton button = new GitHubButton(api.getApiKey(), api.getApiSecret());
		addButton(api, button);
        return button;
	}

	private Component add500pxButton()
    {
        ApiInfo api = DummyDataGenerator._500PX_API;
        OAuthPopupButton b = new OAuthPopupButton( DummyDataGenerator._500PX_API.getScribeApi(),
                DummyDataGenerator._500PX_API.getApiKey(),
                DummyDataGenerator._500PX_API.getApiSecret() );
        b.setCaption( "500px" );
        b.setIcon( FontAwesome._500PX );
        addButton( api, b );

		return b;
	}

    private void addButton( final ApiInfo service, OAuthPopupButton button)
    {
        // In most browsers "resizable" makes the popup
        // open in a new window, not in a tab.
        // You can also set size with eg. "resizable,width=400,height=300"
        button.setPopupWindowFeatures("resizable,width=400,height=300");

        HorizontalLayout hola = new HorizontalLayout();
        hola.setSpacing(true);
        hola.addComponent(button);

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
            ApiInfo getJson = new ApiInfo( "500pxJSON", Px500Api.class, accessToken, accessTokenSecret, "https://api.500px.com/v1/photos?feature=popular" );
            DummyDataProvider.getDynamicCarouselFeed( getJson, accessToken, accessTokenSecret );

            signin.click();
 		}

		@Override
		public void authDenied(String reason)
        {
			hola.addComponent(new Label("Auth failed."));
		}
	}

}
