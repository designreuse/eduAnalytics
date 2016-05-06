/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var colorArry = ["#FFB246", "Salmon", "HotPink", "LightSeaGreen", "#999EFF", "#3A78C1", "#A9FF96", "#FF7599", "#7AC5CD", "#FFB90F", "#ADE6D8", "LightGreen", "#8282EE", "#D8E6AD"];
eduAnalyticsApp.controller('institutereportcontroller', function ($scope, $http) {
    $scope.selectedInstituteYear = 0;
    $scope.yearArray = ['2001', '2002', '2003', '2004', '2005', '2006', '2007', '2008', '2009', '2010', '2011', '2012', '2013', '2014', '2015', '2016'];
    $scope.initCharts = function () {
        $scope.plotTSWiseInstituteCountChart($scope.selectedInstituteYear); // Trainingscheme
        $scope.plotSubTSWiseInstituteCountChart('KVK', $scope.selectedInstituteYear); // Trainingscheme

        $scope.plotDisciplineWiseInstituteCountChart(); // Discipline
        $scope.getInstitutesBySelectedDiscipline('Mechanical Engineering'); // Discipline

        $scope.plotSubDisciplineWiseInstituteCountChart(); // SubDiscipline

        $scope.plotInstituteChart_Trainingscheme(); // Line Chart
        $scope.plotInstituteChart_SubTrainingscheme(); // Line Chart
    };

    $scope.openInstituteDetailModal = function (institutename) {
        $http({
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            dataType: 'text',
            method: 'GET',
            url: '/eduAnalytics/servicejsp/institutecontroller.jsp?action=getInstituteDetailByName&name=' + institutename
        }).then(function (response) {
            console.log(response.data);
            $scope.instituteOject = response.data;
            $("#institutedetailModal").modal();
        }, function (response) {
            throw "Internal Error occured while fetching institutes by discipline";
        });
    };

    $scope.changeInstituteYear = function () {
        $scope.plotTSWiseInstituteCountChart($scope.selectedInstituteYear);
    };

    $scope.plotTSWiseInstituteCountChart = function (year) {
        var pie1 = $('#trainingschemewiseinstitute-pie');

        if (pie1.length) {
            $.ajax({
                dataType: "json",
                url: '/eduAnalytics/servicejsp/institutecontroller.jsp?action=getTrainingSchemeWiseInstituteCount&year=' + year,
                success: function (data) {
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
                                        click: function (event) {
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

    $scope.plotSubTSWiseInstituteCountChart = function (schemetype, year) {
        var pie1 = $('#subtrainingschemewiseinstitute-pie');
        var encodeschemetype = encodeURIComponent(schemetype);
        if (pie1.length) {
            $.ajax({
                dataType: "json",
                url: '/eduAnalytics/servicejsp/institutecontroller.jsp?action=getSubTrainingSchemeWiseInstituteCount&schemetype=' + encodeschemetype + '&year=' + year,
                success: function (data) {
                    $('#subtrainingschemewiseinstitute-pie').highcharts({
                        credits: false,
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false
                        },
                        title: {
                            text: "Sub Training Scheme wise Institute Count under Training Scheme-<b>" + schemetype + "</b>"
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


    $scope.plotDisciplineWiseInstituteCountChart = function () {
        var pie1 = $('#disciplinewiseinstitute-pie');

        if (pie1.length) {
            $.ajax({
                dataType: "json",
                url: '/eduAnalytics/servicejsp/institutecontroller.jsp?action=getDisciplineWiseInstituteCount',
                success: function (data) {
                    console.log(data);
                    $('#disciplinewiseinstitute-pie').highcharts({
                        credits: false,
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false
                        },
                        title: {
                            text: ""
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
                            verticalAlign: "top"
                        },
                        series: [{
                                type: 'pie',
                                name: 'Institutes',
                                data: data,
                                point: {
                                    events: {
                                        click: function (event) {
                                            $scope.getInstitutesBySelectedDiscipline(this.name);
                                        }
                                    }
                                }
                            }]
                    });
                }
            });
        }
    };

    $scope.getInstitutesBySelectedDiscipline = function (discipline) {
        var encodediscipline = encodeURIComponent(discipline);
        $http({
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            dataType: 'text',
            method: 'GET',
            url: '/eduAnalytics/servicejsp/institutecontroller.jsp?action=getInstitutesBySelectedDiscipline&discipline=' + encodediscipline
        }).then(function (response) {
            $scope.disciplineWiseInsList = response.data;
        }, function (response) {
            throw "Internal Error occured while fetching institutes by discipline";
        });
    };

    $scope.plotSubDisciplineWiseInstituteCountChart = function () {
        $.ajax({
            dataType: "json",
            url: '/eduAnalytics/servicejsp/institutecontroller.jsp?action=getSubDisciplineWiseInstituteCount',
            success: function (data) {
                console.log(data);
                $('#subdisciplinewiseinstitute-pie').highcharts({
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Sub Discipline Wise Institute Count'
                    },
                    xAxis: {
                        type: 'category',
                        labels: {
                            rotation: -45,
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif'
                            }
                        }
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Institute Count'
                        }
                    },
                    legend: {
                        enabled: false
                    },
                    tooltip: {
                        pointFormat: 'Count - <b>{point.y}</b>'
                    },
                    series: [{
                            name: 'Institute',
                            data: data,
                            dataLabels: {
                                enabled: true,
                                rotation: -90,
                                color: '#FFFFFF',
                                align: 'right',
                                format: '{point.y:.1f}', // one decimal
                                y: 10, // 10 pixels down from the top
                                style: {
                                    fontSize: '13px',
                                    fontFamily: 'Verdana, sans-serif'
                                }
                            },
                            point: {
                                events: {
                                    click: function (event) {
                                        $scope.getInstitutesBySubDiscipline(this.name);
                                    }
                                }
                            }
                        }]
                });
            }
        });
    };

    $scope.getInstitutesBySubDiscipline = function (course) {
        var encodecourse = encodeURIComponent(course);
        $http({
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            dataType: 'text',
            method: 'GET',
            url: '/eduAnalytics/servicejsp/institutecontroller.jsp?action=getInstituteListFromSubDiscipline&coursename=' + encodecourse
        }).then(function (response) {
            $scope.courseWiseInsList = response.data;
            $("#institutefromSubDisciplineModal").modal();
        }, function (response) {
            throw "Internal Error occured while fetching institutes by subdiscipline";
        });
    };


    $scope.plotInstituteChart_Trainingscheme = function () {
        var pie1 = $('#institute-line');
        if (pie1.length) {
            $.ajax({
                dataType: "json",
                url: '/eduAnalytics/servicejsp/institutecontroller.jsp?action=getYearWiseInstituteCount',
                success: function (data) {
                    $('#institute-line').highcharts({
                        title: {
                            text: 'Number of Institutes of Training scheme Established per year',
                            x: -20 //center
                        },
                        xAxis: {
                            categories: [2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016]
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

    $scope.plotInstituteChart_SubTrainingscheme = function () {
        var pie1 = $('#institute_sub_trainingscheme-line');
        if (pie1.length) {
            $.ajax({
                dataType: "json",
                url: '/eduAnalytics/servicejsp/institutecontroller.jsp?action=getYearWiseInstituteCount_subTS',
                success: function (data) {
                    $('#institute_sub_trainingscheme-line').highcharts({
                        title: {
                            text: 'Number of Institutes of Sub Training scheme Established per year',
                            x: -20 //center
                        },
                        xAxis: {
                            categories: [2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016]
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
