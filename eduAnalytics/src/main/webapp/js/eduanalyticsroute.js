var eduAnalyticsApp = angular.module('eduAnalyticsApp', ['ngRoute']);
console.log(eduAnalyticsApp);
eduAnalyticsApp.config(['$routeProvider', function($routeProvider) {

        $routeProvider
        .when('/dashboard', {
            templateUrl: 'jsp/dashboard/dashboard.jsp'
        }).when('/device', {
            templateUrl: 'jsp/general/device/deviceinfo.jsp'
        }).when('/performance', {
            templateUrl: 'jsp/general/performance/performanceinfo.jsp'
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


