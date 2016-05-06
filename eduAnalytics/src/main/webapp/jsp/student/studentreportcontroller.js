/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var colorArry = ["#FFB246", "Salmon", "HotPink", "LightSeaGreen", "#999EFF", "#3A78C1", "#A9FF96", "#FF7599", "#7AC5CD", "#FFB90F", "#ADE6D8", "LightGreen", "#8282EE", "#D8E6AD"];
eduAnalyticsApp.controller('studentreportcontroller', function($scope, $http) {
    $scope.selectedTSYear = 0;
    $scope.selectedDisciplineYear = 0;
    $scope.yearArray = ['2001', '2002', '2003', '2004', '2005', '2006', '2007', '2008', '2009', '2010', '2011', '2012', '2013', '2014', '2015', '2016'];
    $scope.initCharts = function() {
        $scope.plotTSWiseStudentCountChart($scope.selectedTSYear);
        $scope.plotSubTSWiseStudentCountChart('KVK', $scope.selectedTSYear);
        $scope.plotDisciplineWiseStudentCountChart($scope.selectedDisciplineYear);
        $scope.plotSubDisciplineWiseStudentCountChart('Mechanical Engineering', $scope.selectedDisciplineYear);
    };
    
    $scope.changeTSYear = function() {
        $scope.plotTSWiseStudentCountChart($scope.selectedTSYear);
    };

    $scope.plotTSWiseStudentCountChart = function(year) {
        var pie1 = $('#trainingschemewisestudent-pie');

        if (pie1.length) {
            $.ajax({
                dataType: "json",
                url: '/eduAnalytics/servicejsp/studentcontroller.jsp?action=getTrainingSchemeWiseStudentCount&year=' + year,
                success: function(data) {
                    $('#trainingschemewisestudent-pie').highcharts({
                        credits: false,
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false
                        },
                        title: {
                            text: "Training Scheme wise Student Count"
                        },
                        tooltip: {
                            pointFormat: '{series.name}: <b>{point.y} ({point.percentage:.1f}%)</b>'
                        },
                        plotOptions: {
                            pie: {
                                size: "40%",
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
                                name: 'Students',
                                data: data,
                                point: {
                                    events: {
                                        click: function(event) {
                                            $scope.plotSubTSWiseStudentCountChart(this.name, $scope.selectedTSYear);
                                        }
                                    }
                                }
                            }]
                    });

                    var chart = $('#trainingschemewisestudent-pie').highcharts();
                    if (year != 0) {
                        chart.setTitle({text: 'Training Scheme wise Student Count for year-' + year});
                    }
                }
            });
        }
    };
    
    $scope.plotSubTSWiseStudentCountChart = function(schemetype, year) {
        var pie1 = $('#subtrainingschemewisestudent-pie');
        var encodeschemetype = encodeURIComponent(schemetype);
        if (pie1.length) {
            $.ajax({
                dataType: "json",
                url: '/eduAnalytics/servicejsp/studentcontroller.jsp?action=getSubTrainingSchemeWiseStudentCount&schemetype=' + encodeschemetype + '&year=' + year,
                success: function(data) {
                    $('#subtrainingschemewisestudent-pie').highcharts({
                        credits: false,
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false
                        },
                        title: {
                            text: "Sub Training Scheme wise Student Count for Training Scheme-<b>" + schemetype + "</b>"
                        },
                        tooltip: {
                            pointFormat: '{series.name}: <b>{point.y} ({point.percentage:.1f}%)</b>'
                        },
                        plotOptions: {
                            pie: {
                                size: "40%",
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
                                name: 'Students',
                                data: data
                            }]
                    });

                    var chart = $('#subtrainingschemewisestudent-pie').highcharts();
                    if (year != 0) {
                        chart.setTitle({text: 'Sub Training Scheme Student Count for Training Scheme-<b>' + schemetype + '</b> & year-<b>' + year + '</b>'});
                    }
                }
            });
        }
    };
    
    $scope.changeDisciplineYear = function() {
        $scope.plotDisciplineWiseStudentCountChart($scope.selectedDisciplineYear);
    };

    $scope.plotDisciplineWiseStudentCountChart = function(year) {
        var pie1 = $('#discipline-pie');

        if (pie1.length) {
            $.ajax({
                dataType: "json",
                url: '/eduAnalytics/servicejsp/studentcontroller.jsp?action=getDisciplineWiseStudentCount&year=' + year,
                success: function(data) {
                    console.log(data);
                    $('#discipline-pie').highcharts({
                        credits: false,
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false
                        },
                        title: {
                            text: "Discipline wise Student Count"
                        },
                        tooltip: {
                            pointFormat: '{series.name}: <b>{point.y} ({point.percentage:.1f}%)</b>'
                        },
                        plotOptions: {
                            pie: {
                                size: "40%",
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
                                name: 'Students',
                                data: data,
                                point: {
                                    events: {
                                        click: function(event) {
                                            $scope.plotSubDisciplineWiseStudentCountChart(this.name, $scope.selectedDisciplineYear);
                                        }
                                    }
                                }
                            }]
                    });

                    var chart = $('#discipline-pie').highcharts();
                    if (year != 0) {
                        chart.setTitle({text: 'Discipline wise Student Count for year-' + year});
                    }
                }
            });
        }
    };
    
    $scope.plotSubDisciplineWiseStudentCountChart = function(discipline, year) {
        var pie1 = $('#subdiscipline-pie');
        var encodediscipline=encodeURIComponent(discipline);
        if (pie1.length) {
            $.ajax({
                dataType: "json",
                url: '/eduAnalytics/servicejsp/studentcontroller.jsp?action=getSubDisciplineWiseStudentCount&discipline=' + encodediscipline + '&year=' + year,
                success: function(data) {
                    console.log(data);
                    $('#subdiscipline-pie').highcharts({
                        credits: false,
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false
                        },
                        title: {
                            text: "Sub Discipline wise Student Count for Discipline-<b>"+discipline+"</b>"
                        },
                        tooltip: {
                            pointFormat: '{series.name}: <b>{point.y} ({point.percentage:.1f}%)</b>'
                        },
                        plotOptions: {
                            pie: {
                                size: "40%",
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
                                name: 'Students',
                                data: data
                            }]
                    });
                    
                    var chart = $('#subdiscipline-pie').highcharts();
                    if (year != 0) {
                        chart.setTitle({text: 'Sub Discipline wise Student Count for Discipline-<b>'+discipline+'</b> & year-<b>' + year+'</b>'});
                    }
                }
            });
        }
    };
});
