package yammer4j;

import yammer4j.opengraph.OpenGraph;

public interface Yammer extends Autocomplete,
        Groups,
        Invitations,
        Messages,
        Networks,
        Notifications,
        OAuth,
        OAuthImpersonation,
        OpenGraph,
        Relationships,
        Search,
        Subscriptions,
        Suggestions,
        Users {
}
