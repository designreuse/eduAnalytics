<%@page import="java.util.Enumeration"%>
<%@page import="com.eduAnalytics.dao.AdminDAO"%>
<%@page import="com.eduAnalytics.dao.DashboardDAO"%>
<%@page import="com.eduAnalytics.utilities.AnalyticsConstants"%>
<%
    String action = request.getParameter("action");
    if (action != null && !action.isEmpty()) {
        AdminDAO dao = new AdminDAO();
        if (action.equalsIgnoreCase("uploadDiscipline")) {
            String file = request.getParameter("file");
            Enumeration e = request.getParameterNames();

            while (e.hasMoreElements()) {
                Object obj = e.nextElement();
                String fieldName = (String) obj;
                String fieldValue = request.getParameter(fieldName);
                System.out.println(fieldName + " : " + fieldValue);
            }
        }
    }
%>
