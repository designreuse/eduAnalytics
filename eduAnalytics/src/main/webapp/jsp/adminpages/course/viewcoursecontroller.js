/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
eduAnalyticsApp.controller('viewcoursecontroller', function ($scope, $http) {

    $scope.loadCourses = function (element) {
        $http({
            method: 'POST',
            withCredentials: false,
            url: '/eduAnalytics/servicejsp/admincontroller.jsp?action=viewCourse',
            transformRequest: angular.identity
        }).then(function (response) {
            $scope.courseArray = response.data;
        }, function (response) {
            throw "Internal Error while loading courses ";
        });
    };
});





