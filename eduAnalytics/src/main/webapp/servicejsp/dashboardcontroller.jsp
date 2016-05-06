<%@page import="com.eduAnalytics.dao.DashboardDAO"%>
<%@page import="com.eduAnalytics.utilities.AnalyticsConstants"%>
<%
    String action = request.getParameter("action");
    if (action != null && !action.isEmpty()) {
        DashboardDAO dao = new DashboardDAO();
        if (action.equalsIgnoreCase(AnalyticsConstants.GETDASHBOARDCOUNTS)) {
            out.println(dao.getDashboardCounts());
        }     
    }
%>
