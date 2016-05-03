/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var colorArry = ["#FFB246", "Salmon", "HotPink", "LightSeaGreen", "#999EFF", "#3A78C1", "#A9FF96", "#FF7599", "#7AC5CD", "#FFB90F", "#ADE6D8", "LightGreen", "#8282EE", "#D8E6AD"];
eduAnalyticsApp.controller('institutereportcontroller', function($scope, $http) {
    $scope.initCharts = function() {
        $scope.plotInstituteChart();
    };

    $scope.changeYear = function() {
        $scope.plotDisciplineWiseStudentCountChart($scope.selectedYear);
    };

    $scope.plotInstituteChart = function() {
        var pie1 = $('#institute-line');
        if (pie1.length) {
            $.ajax({
                dataType: "json",
                url: '/eduAnalytics/reportscontroller.jsp?action=getYearWiseInstituteCount',
                success: function(data) {
                    console.log(data);
                    $('#institute-line').highcharts({
                        title: {
                            text: 'Year wise Institute Count',
                            x: -20 //center
                        },
                        xAxis: {
                            categories: [2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016]
                        },
                        yAxis: {
                            title: {
                                text: 'No. of Institutes'
                            },
                            plotLines: [{
                                    value: 0,
                                    width: 1,
                                    color: '#808080'
                                }]
                        },
                        tooltip: {
                            //valueSuffix: '°C'
                        },
                        legend: {
                            layout: 'vertical',
                            align: 'right',
                            verticalAlign: 'middle',
                            borderWidth: 0
                        },
                        series: data
                    });
                }
            });
        }

    };
});
