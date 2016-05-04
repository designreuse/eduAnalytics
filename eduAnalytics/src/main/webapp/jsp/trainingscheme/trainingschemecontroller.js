/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var colorArry = ["#FFB246", "Salmon", "HotPink", "LightSeaGreen", "#999EFF", "#3A78C1", "#A9FF96", "#FF7599", "#7AC5CD", "#FFB90F", "#ADE6D8", "LightGreen", "#8282EE", "#D8E6AD"];
eduAnalyticsApp.controller('trainingschemecontroller', function($scope, $http) {
    $scope.selectedStudentYear = 0;
    $scope.selectedInstituteYear = 0;
    $scope.yearArray = ['2001', '2002', '2003', '2004', '2005', '2006', '2007', '2008', '2009', '2010', '2011', '2012', '2013', '2014', '2015', '2016'];
    $scope.trainingschemeArray=[];
    $scope.initCharts = function() {
        $scope.loadTrainingSchemes();
        $scope.plotTSWiseStudentCountChart($scope.selectedStudentYear);
        $scope.plotTSWiseInstituteCountChart($scope.selectedInstituteYear);
    };

    $scope.loadTrainingSchemes = function() {
        
        $http({
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            dataType: 'text',
            method: 'GET',
            url: '/eduAnalytics/reportscontroller.jsp?action=getAllTrainingSchemes'
        }).then(function(response) {
            $scope.trainingschemeArray = response.data;
            console.log(JSON.stringify($scope.trainingschemeArray));
        }, function(response) {
            throw "Internal Error occured while saving Examination Notes,Please try after some time";
        });
    };
    
    $scope.changeInstituteYear = function() {
        $scope.plotTSWiseInstituteCountChart($scope.selectedInstituteYear);
    };

    $scope.changeStudentYear = function() {
        $scope.plotTSWiseStudentCountChart($scope.selectedStudentYear);
    };

    $scope.plotTSWiseInstituteCountChart = function(year) {
        var pie1 = $('#trainingschemewiseinstitute-pie');

        if (pie1.length) {
            $.ajax({
                dataType: "json",
                url: '/eduAnalytics/reportscontroller.jsp?action=getTrainingSchemeWiseInstituteCount&year=' + year,
                success: function(data) {
                    $('#trainingschemewiseinstitute-pie').highcharts({
                        credits: false,
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false
                        },
                        title: {
                            text: "Training Scheme wise Institute Count"
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
                                name: 'Institutes',
                                data: data,
                                point: {
                                    events: {
                                        click: function(event) {
                                            $scope.plotSubTSWiseInstituteCountChart(this.name, $scope.selectedInstituteYear);
                                        }
                                    }
                                }
                            }]
                    });

                    var chart = $('#trainingschemewiseinstitute-pie').highcharts();
                    if (year != 0) {
                        chart.setTitle({text: 'Training Scheme wise Institute Count for year-' + year});
                    }
                }
            });
        }
    };
    
    $scope.plotSubTSWiseInstituteCountChart = function(schemetype, year) {
        var pie1 = $('#subtrainingschemewiseinstitute-pie');
        var encodeschemetype = encodeURIComponent(schemetype);
        if (pie1.length) {
            $.ajax({
                dataType: "json",
                url: '/eduAnalytics/reportscontroller.jsp?action=getSubTrainingSchemeWiseInstituteCount&schemetype=' + encodeschemetype + '&year=' + year,
                success: function(data) {
                    $('#subtrainingschemewiseinstitute-pie').highcharts({
                        credits: false,
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false
                        },
                        title: {
                            text: "Sub Training Scheme wise Institute Count for Training Scheme-<b>" + schemetype + "</b>"
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
                                name: 'Institutes',
                                data: data
                            }]
                    });

                    var chart = $('#subtrainingschemewiseinstitute-pie').highcharts();
                    if (year != 0) {
                        chart.setTitle({text: 'Sub Training Scheme Institute Count for Training Scheme-<b>' + schemetype + '</b> & year-<b>' + year + '</b>'});
                    }
                }
            });
        }
    };
    
    $scope.plotTSWiseStudentCountChart = function(year) {
        var pie1 = $('#trainingschemewisestudent-pie');

        if (pie1.length) {
            $.ajax({
                dataType: "json",
                url: '/eduAnalytics/reportscontroller.jsp?action=getTrainingSchemeWiseStudentCount&year=' + year,
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
                                            $scope.plotSubTSWiseStudentCountChart(this.name, $scope.selectedStudentYear);
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
                url: '/eduAnalytics/reportscontroller.jsp?action=getSubTrainingSchemeWiseStudentCount&schemetype=' + encodeschemetype + '&year=' + year,
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
});
