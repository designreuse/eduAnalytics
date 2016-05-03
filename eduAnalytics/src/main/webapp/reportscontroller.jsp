<%@page import="com.eduanalytics.utilities.AnalyticsConstants"%>
<%@page import="com.eduanalytics.dao.ReportsDAO"%>
<%
    String action = request.getParameter("action");
    if (action != null && !action.isEmpty()) {
        ReportsDAO dao = new ReportsDAO();
        if (action.equalsIgnoreCase(AnalyticsConstants.GETDISCIPLINEWISE_STUDENT_COUNT)) {
            String year = request.getParameter("year");
            out.println(dao.getDisciplineWiseStudentCount(Integer.parseInt(year)));
        }else if (action.equalsIgnoreCase(AnalyticsConstants.GETSUBDISCIPLINEWISE_STUDENT_COUNT)) {
            String year = request.getParameter("year");
            String discipline = request.getParameter("discipline");
            out.println(dao.getSubDisciplineWiseStudentCount(discipline,Integer.parseInt(year)));
        }else if (action.equalsIgnoreCase(AnalyticsConstants.GETTRAININGSCHEMEWISE_STUDENT_COUNT)) {
            String year = request.getParameter("year");
            out.println(dao.getTrainingSchemeWiseStudentCount(Integer.parseInt(year)));
        } else if (action.equalsIgnoreCase(AnalyticsConstants.GETSUBTRAININGSCHEMEWISE_STUDENT_COUNT)) {
            String year = request.getParameter("year");
            String schemetype = request.getParameter("schemetype");
            out.println(dao.getSubTrainingSchemeWiseStudentCount(schemetype,Integer.parseInt(year)));
        }       
    }
%>
