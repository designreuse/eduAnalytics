<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>eduAnalytics</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <%@include file="loadstyle.jsp"%>
        <%@include file="loadscripts.jsp"%>
    </head>
    <body class="skin-blue fixed" ng-app="eduAnalyticsApp">
        <!-- header logo: style can be found in header.less -->
        <%@include file="header.jsp"%>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <%@include file="adminleftmenu.jsp"%>
            <decorator:body />
            <div ng-view=""></div>
        </div><!-- ./wrapper -->
    </body>
</html>