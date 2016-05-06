<%@page import="com.eduAnalytics.dao.InstituteDAO"%>
<%@page import="com.eduAnalytics.utilities.AnalyticsConstants"%>
<%
    String action = request.getParameter("action");
    if (action != null && !action.isEmpty()) {
        InstituteDAO dao = new InstituteDAO();
        if (action.equalsIgnoreCase(AnalyticsConstants.GETTRAININGSCHEMEWISE_INSTITUTE_COUNT)) {
            String year = request.getParameter("year");
            out.println(dao.getTrainingSchemeWiseInstituteCount(Integer.parseInt(year)));
        } else if (action.equalsIgnoreCase(AnalyticsConstants.GETSUBTRAININGSCHEMEWISE_INSTITUTE_COUNT)) {
            String year = request.getParameter("year");
            String schemetype = request.getParameter("schemetype");
            out.println(dao.getSubTrainingSchemeWiseInstituteCount(schemetype,Integer.parseInt(year)));
        } else if (action.equalsIgnoreCase(AnalyticsConstants.GETDISCIPLINEWISE_INSTITUTE_COUNT)) {
            out.println(dao.getDisciplineWiseInstituteCount());
        }else if (action.equalsIgnoreCase(AnalyticsConstants.GETINSTITUTESBYSELECTEDDISCIPLINE)) {
            String discipline = request.getParameter("discipline");
            out.println(dao.getInstituteListFromDiscipline(discipline));
        } else if (action.equalsIgnoreCase(AnalyticsConstants.GETSUBDISCIPLINEWISE_INSTITUTE_COUNT)) {
            out.println(dao.getSubDisciplineWiseInstituteCount());
        }else if(action.equalsIgnoreCase(AnalyticsConstants.GETYEARWISEINSTITUTE_COUNT)){
            out.println(dao.getYearWiseInstituteCount());
        }else if(action.equalsIgnoreCase(AnalyticsConstants.GETYEARWISEINSTITUTE_COUNT_SubTrainingScheme)){
            out.println(dao.getYearWiseInsCountPerSubTS());
        }else if(action.equalsIgnoreCase(AnalyticsConstants.GETINSTITUTEDETAILBYNAME)){
            String name = request.getParameter("name");
            out.println(dao.getInstituteDetailByName(name));
        }else if(action.equalsIgnoreCase(AnalyticsConstants.GETINSTITUTELISTFROMSUBDISCIPLINE)){
            String name = request.getParameter("coursename");
            out.println(dao.getInstituteListFromSubDiscipline(name));
        }
    }
%>
