/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
eduAnalyticsApp.controller('viewdisciplinecontroller', function ($scope, $http) {

    $scope.loadDisciplines = function (element) {
        $http({
            method: 'POST',
            withCredentials: false,
            url: '/eduAnalytics/servicejsp/admincontroller.jsp?action=viewDiscipline',
            transformRequest: angular.identity
        }).then(function (response) {
            $scope.disciplineArray = response.data;
        }, function (response) {
            throw "Internal Error while loading disciplines ";
        });
    };
});





