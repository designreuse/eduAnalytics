<%@page import="com.eduAnalytics.utilities.AnalyticsConstants"%>
<%@page import="com.eduAnalytics.dao.ReportsDAO"%>
<%
    String action = request.getParameter("action");
    if (action != null && !action.isEmpty()) {
        ReportsDAO dao = new ReportsDAO();
        if (action.equalsIgnoreCase(AnalyticsConstants.GETDISCIPLINEWISE_STUDENT_COUNT)) {
            out.println(dao.getDisciplineWiseStudentCount());
        }else if (action.equalsIgnoreCase(AnalyticsConstants.GETDISCIPLINEWISE_STUDENT_COUNT_YEAR)) {
            String year = request.getParameter("year");
            out.println(dao.getDisciplineWiseStudentCount_year(Integer.parseInt(year)));
        }
    }

%>