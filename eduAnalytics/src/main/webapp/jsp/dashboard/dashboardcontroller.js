/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
eduAnalyticsApp.controller('dashboardcontroller',function($scope,$http){
    
    $scope.initCharts = function() {
        $http({
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            dataType: 'text',
            method: 'GET',
            url: '/eduAnalytics/servicejsp/dashboardcontroller.jsp?action=getDashboardCounts'
        }).then(function(response) {
            $scope.dashboardObject = response.data;
        }, function(response) {
            throw "Internal Error occured while fetching dashboard counts";
        });
    };
    
});

