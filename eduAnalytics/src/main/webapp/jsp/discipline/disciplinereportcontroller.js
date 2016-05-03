/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var colorArry = ["#FFB246", "Salmon","HotPink","LightSeaGreen","#999EFF","#3A78C1","#A9FF96","#FF7599","#7AC5CD","#FFB90F","#ADE6D8","LightGreen","#8282EE","#D8E6AD"];
eduAnalyticsApp.controller('disciplinereportcontroller', function($scope, $http) {
    $scope.yearArray=['2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013','2014','2015','2016'];
    $scope.initCharts = function(){
        $("#disciplineWiseStudentChart").show();
        $("#subdisciplineWiseStudentChart").hide();
        plotDisciplineWiseStudentCountChart();
    };
    
    $scope.changeYear = function(){
        if($scope.selectedYear != 0){
            plotDisciplineWiseStudentCountChartPerYear($scope.selectedYear);
        }
    };
});

function plotDisciplineWiseStudentCountChart() {
    var pie1 = $('#discipline-pie');

    if (pie1.length) {
        $.ajax({
            dataType: "json",
            url: '/eduAnalytics/reportscontroller.jsp?action=getDisciplineWiseStudentCount',
            success: function(data) {
                $('#discipline-pie').highcharts({
                    credits: false,
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false
                    },
                    title: {
                        text: null
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: {
                        pie: {
                            size:"40%",
                            center: ['50%', '30%'],
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: true
                            },
                            showInLegend: true
                        }
                    },
                    colors: colorArry,
                    legend: {
                        verticalAlign: "bottom"
                    },
                    series: [{
                            type: 'pie',
                            name: 'Visits',
                            data: data
                        }]
                });

            }
        });
    }
}

function plotDisciplineWiseStudentCountChartPerYear(year) {
    var pie1 = $('#discipline-pie');

    if (pie1.length) {
        $.ajax({
            dataType: "json",
            url: '/eduAnalytics/reportscontroller.jsp?action=getDisciplineWiseStudentCount&year='+year,
            success: function(data) {
                $('#discipline-pie').highcharts({
                    credits: false,
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false
                    },
                    title: {
                        text: null
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: {
                        pie: {
                            size:"40%",
                            center: ['50%', '30%'],
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: true
                            },
                            showInLegend: true
                        }
                    },
                    colors: colorArry,
                    legend: {
                        verticalAlign: "bottom"
                    },
                    series: [{
                            type: 'pie',
                            name: 'Visits',
                            data: data
                        }]
                });

            }
        });
    }
}

