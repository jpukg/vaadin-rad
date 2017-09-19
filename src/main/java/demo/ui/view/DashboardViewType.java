package demo.ui.view;


import demo.ui.view.dashboard.DashboardView;
import demo.ui.view.transactions.TransactionsView;
import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;

public enum DashboardViewType {
    DASHBOARD("Dashboard", "", DashboardView.class, FontAwesome.HOME, true), TRANSACTIONS(
            "Transactions", "transactions", TransactionsView.class, FontAwesome.TABLE, false);

    private final String title;
    private final String viewName;
    private final Class<? extends View> viewClass;
    private final Resource icon;
    private final boolean stateful;

    private DashboardViewType(final String title, final String viewName,
                              final Class<? extends View> viewClass, final Resource icon,
                              final boolean stateful) {
        this.title = title;
        this.viewName = viewName;
        this.viewClass = viewClass;
        this.icon = icon;
        this.stateful = stateful;
    }

    public boolean isStateful() {
        return stateful;
    }

    public String getViewName() {
        return viewName;
    }

    public String getTitle() { return title; }

    public Class<? extends View> getViewClass() {
        return viewClass;
    }

    public Resource getIcon() {
        return icon;
    }

    public static DashboardViewType getByViewName(final String viewName) {
        DashboardViewType result = null;
        for (DashboardViewType viewType : values()) {
            if (viewType.getViewName().equals(viewName)) {
                result = viewType;
                break;
            }
        }
        return result;
    }

}