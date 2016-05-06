/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var colorArry = ["#FFB246", "Salmon", "HotPink", "LightSeaGreen", "#999EFF", "#3A78C1", "#A9FF96", "#FF7599", "#7AC5CD", "#FFB90F", "#ADE6D8", "LightGreen", "#8282EE", "#D8E6AD"];
eduAnalyticsApp.controller('trainingschemecontroller', function($scope, $http) {
    $scope.trainingschemeArray=[];
    $scope.initCharts = function() {
        $scope.loadTrainingSchemes();
    };

    $scope.loadTrainingSchemes = function() {
        
        $http({
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            dataType: 'text',
            method: 'GET',
            url: '/eduAnalytics/servicejsp/trainingschemecontroller.jsp?action=getAllTrainingSchemes'
        }).then(function(response) {
            $scope.trainingschemeArray = response.data;
            console.log(JSON.stringify($scope.trainingschemeArray));
        }, function(response) {
            throw "Internal Error occured while saving Examination Notes,Please try after some time";
        });
    };
   
});
