package com.vaadin.demo.dashboard.event;

import com.vaadin.demo.dashboard.domain.Transaction;
import com.vaadin.demo.dashboard.view.DashboardViewType;

import org.scribe.model.Token;

import java.util.Collection;

/*
 * Event bus events used in Dashboard are listed here as inner classes.
 */
public abstract class DashboardEvent
{

    public static final class UserLoginRequestedEvent
    {
        private final String userName, password;

        public UserLoginRequestedEvent(final String userName,
                final String password) {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class BrowserResizeEvent {

    }

    public static class UserLoggedOutEvent {

    }

    public static class NotificationsCountUpdatedEvent {
    }

    public static final class ReportsCountUpdatedEvent
    {
        private final int count;

        public ReportsCountUpdatedEvent(final int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

    }

    public static final class TransactionReportEvent
    {
        private final Collection<Transaction> transactions;

        public TransactionReportEvent(final Collection<Transaction> transactions) {
            this.transactions = transactions;
        }

        public Collection<Transaction> getTransactions() {
            return transactions;
        }
    }

    public static final class PostViewChangeEvent
    {
        private final DashboardViewType view;

        public PostViewChangeEvent(final DashboardViewType view) {
            this.view = view;
        }

        public DashboardViewType getView() {
            return view;
        }
    }

    public static class CloseOpenWindowsEvent {
    }

    public static class ProfileUpdatedEvent {
    }

    public static final class Px500PhotoFeedRequestEvent
    {
        private static Token token;

        public Px500PhotoFeedRequestEvent( String accessToken, String accessTokenSecret )
        {
            this.token = new Token( accessToken, accessTokenSecret );
        }

        public static Token getToken() { return token; }
    }

}
