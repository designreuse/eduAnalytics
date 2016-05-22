var eduAnalyticsApp = angular.module('eduAnalyticsApp', ['ngRoute']);
eduAnalyticsApp.config(['$routeProvider', function($routeProvider) {

        $routeProvider
        .when('/dashboard', {
            templateUrl: 'jsp/dashboard/dashboard.jsp'
        }).when('/trainingscheme', {
            templateUrl: 'jsp/trainingscheme/trainingschemereport.jsp'
        }).when('/institute', {
            templateUrl: 'jsp/institute/institutereport.jsp'
        }).when('/student', {
            templateUrl: 'jsp/student/studentreport.jsp'
        }).when('/adddiscipline', {
            templateUrl: 'jsp/adminpages/discipline/adddiscipline.jsp'
        }).otherwise({
            templateUrl: 'jsp/errorpages/error404.jsp'
        });
    }]);


eduAnalyticsApp.run(function($rootScope, $templateCache, $location) {
    $rootScope.$on('$routeChangeStart', function(event, next, current) {
        if (typeof (current) !== 'undefined') {
            $templateCache.remove(current.templateUrl);
        }
    });
});


