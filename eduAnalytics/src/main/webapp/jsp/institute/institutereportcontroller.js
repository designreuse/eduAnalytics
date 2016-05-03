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
            series: [{
                    name: 'Tokyo',
                    data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6,25.2, 26.5, 23.3, 18.3, 13.9]
                }, {
                    name: 'New York',
                    data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5,25.2, 26.5, 23.3, 18.3, 13.9]
                }, {
                    name: 'Berlin',
                    data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0,25.2, 26.5, 23.3, 18.3, 13.9]
                }, {
                    name: 'London',
                    data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8,25.2, 26.5, 23.3, 18.3, 13.9]
                }]
        });


//        if (pie1.length) {
//            $.ajax({
//                dataType: "json",
//                url: '/eduAnalytics/reportscontroller.jsp?action=getDisciplineWiseStudentCount&year=' + year,
//                success: function(data) {
//                    console.log(data);
//                    $('#discipline-pie').highcharts({
//                        credits: false,
//                        chart: {
//                            plotBackgroundColor: null,
//                            plotBorderWidth: null,
//                            plotShadow: false
//                        },
//                        title: {
//                            text: "Discipline wise Student Count"
//                        },
//                        tooltip: {
//                            pointFormat: '{series.name}: <b>{point.y} ({point.percentage:.1f}%)</b>'
//                        },
//                        plotOptions: {
//                            pie: {
//                                size: "40%",
//                                center: ['50%', '30%'],
//                                allowPointSelect: true,
//                                cursor: 'pointer',
//                                dataLabels: {
//                                    enabled: true
//                                },
//                                showInLegend: true
//                            }
//                        },
//                        colors: colorArry,
//                        legend: {
//                            verticalAlign: "bottom"
//                        },
//                        series: [{
//                                type: 'pie',
//                                name: 'Students',
//                                data: data,
//                                point: {
//                                    events: {
//                                        click: function(event) {
//                                            $scope.plotSubDisciplineWiseStudentCountChart(this.name, $scope.selectedYear);
//                                        }
//                                    }
//                                }
//                            }]
//                    });
//
//                    var chart = $('#discipline-pie').highcharts();
//                    if (year != 0) {
//                        chart.setTitle({text: 'Discipline wise Student Count for year-' + year});
//                    }
//                }
//            });

    };
});
