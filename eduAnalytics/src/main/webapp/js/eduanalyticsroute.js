var eduAnalyticsApp = angular.module('eduAnalyticsApp', ['ngRoute']);
console.log(eduAnalyticsApp);
eduAnalyticsApp.config(['$routeProvider', function($routeProvider) {

        $routeProvider
        .when('/dashboard', {
            templateUrl: 'jsp/dashboard/dashboard.jsp'
        }).when('/discipline', {
            templateUrl: 'jsp/discipline/disciplinereport.jsp'
        }).when('/trainingscheme', {
            templateUrl: 'jsp/trainingscheme/trainingschemereport.jsp'
        }).when('/datapopulation', {
            templateUrl: 'jsp/general/datapopulation/datapopulationinfo.jsp'
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


