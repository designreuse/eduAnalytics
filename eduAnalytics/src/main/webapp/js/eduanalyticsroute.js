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
        }).when('/viewdiscipline', {
            templateUrl: 'jsp/adminpages/discipline/viewdiscipline.jsp'
        }).when('/addcourse', {
            templateUrl: 'jsp/adminpages/course/addcourse.jsp'
        }).when('/viewcourse', {
            templateUrl: 'jsp/adminpages/course/viewcourse.jsp'
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

eduAnalyticsApp.directive('fileReader', function () {
    return {
        scope: {
            fileReader: "="
        },
        link: function (scope, element) {
            $(element).on('change', function (changeEvent) {
                var files = changeEvent.target.files;
                if (files.length) {
                    var r = new FileReader();
                    r.onload = function (e) {
                        var table = $("<table class=\"table table-condensed\"/>");
                        var rows = e.target.result.split("\n");
                        scope.$apply(function () {

                            for (var i = 0; i < rows.length; i++) {
                                var row = $("<tr />");
                                var cells = rows[i].split(",");
                                for (var j = 0; j < cells.length; j++) {
                                    var cell = $("<td />");
                                    cell.html(cells[j]);
                                    row.append(cell);
                                }
                                table.append(row);
                            }
                            $("#noofrecstoimported").html('');
                            $("#noofrecstoimported").append(" Records to be imported:");
                            $("#noofrecstoimported").append(rows.length-1);
                            $("#dvCSV").html('');
                            $("#dvCSV").append(table);
                        });
                    };

                    r.readAsText(files[0]);
                }
            });
        }
    };
});



