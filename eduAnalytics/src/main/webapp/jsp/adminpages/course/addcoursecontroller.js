/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
eduAnalyticsApp.controller('addcoursecontroller', function ($scope, $http) {

    $scope.attachFile = function (element) {
        $scope.$apply(function ($scope) {
            $scope.files = element.files;
            console.log($scope.files);
        });
    };

    $scope.uploadDiscipline = function () {
        var file = '';
        if ($scope.files !== undefined) {
            file = $scope.files[0];
        }
        var fd = new FormData();
        fd.append("file", file);
        $http({
            method: 'POST',
            withCredentials: false,
            url: '/eduAnalytics/FileUploadServlet?action=addCourse',
            data: fd,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
        }).then(function (response) {
            console.log(response);
            $scope.retMsg = "File Uploaded Successfully";
            $("#noofrecstoimported").append(" Records successfully imported:");
            $("#noofrecstoimported").append(response.data);
        }, function (response) {
            throw "Internal Error while uploading disciplines ";
        });

    };

});





