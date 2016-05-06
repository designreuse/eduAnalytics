<%@page import="com.eduAnalytics.dao.TrainingSchemeDAO"%>
<%@page import="com.eduAnalytics.dao.InstituteDAO"%>
<%@page import="com.eduAnalytics.dao.DashboardDAO"%>
<%@page import="com.eduAnalytics.utilities.AnalyticsConstants"%>
<%
    String action = request.getParameter("action");
    if (action != null && !action.isEmpty()) {
        TrainingSchemeDAO dao = new TrainingSchemeDAO();
        if(action.equalsIgnoreCase(AnalyticsConstants.GETALLTRAININGSCHEMES)){
            out.println(dao.getAllTrainingSchemes());
        }
    }
%>
