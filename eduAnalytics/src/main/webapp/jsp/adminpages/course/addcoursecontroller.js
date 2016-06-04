/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
eduAnalyticsApp.controller('adddisciplinecontroller', function ($scope, $http) {

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
            url: '/eduAnalytics/FileUploadServlet?action=addDiscipline',
            data: fd,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
        }).then(function (response) {
            console.log(response);
            $scope.retMsg = "File Uploaded Successfully";
        }, function (response) {
            throw "Internal Error while uploading disciplines ";
        });

    };

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
                            $("#dvCSV").html('');
                            $("#dvCSV").append(table);
                            console.log(scope.fileReader);
                        });
                    };

                    r.readAsText(files[0]);
                }
            });
        }
    };
});



