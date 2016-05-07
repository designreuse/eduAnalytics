<style>
    .browserStat.big {
        display: inline-block;
        width: 49%;
        text-align: center;
        margin-bottom: 20px;
        padding: 0;
    }

    .browserStat {
        display: inline-block;
        width: 32%;
        text-align: center;
        margin: 0;
        padding: 0;
    }

    .browserStat span {
        display: block;
        text-align: center;
        margin-top: 10px;
    }

</style>
<div ng-controller="studentreportcontroller">
    <aside class="right-side">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Student Analytics
            </h1>
        </section>

        <!-- Main content -->
        <section class="content" ng-init="initCharts()">

            <div class="row">
                <div id="trainingschemeWiseStudentChart" class="col-md-6">
                    <!-- AREA CHART -->
                    <div id='browserMainChartBox' class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Training scheme Wise Student Count</h3>
                            <div class="form-group pull-right" style="width:150px !important;height:10px;padding-top:3px;margin-left:3px;">
                                <select class="form-control pull-left input-sm" style="margin-left: -10px;margin-top: 10px;" ng-model="selectedTSYear" ng-change="changeTSYear()">
                                    <option value="0"> All </option>
                                    <option  ng-repeat="obj in yearArray" ng-value="obj"> {{ obj}} </option>                                    
                                </select>
                            </div>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="trainingschemewisestudent-pie" style="height: 600px;"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->

                </div><!-- /.col (LEFT) -->

                <div id="subtrainingschemeWiseStudentChart" class="col-md-6">
                    <!-- AREA CHART -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">
                                <span id="selectedUserVersion"></span>
                                Sub Training Scheme Wise Student Count
                            </h3>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="subtrainingschemewisestudent-pie" style="height: 600px;"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div>
            </div>


            <div class="row">
                <div id="disciplineWiseStudentChart" class="col-md-6">
                    <!-- AREA CHART -->
                    <div id='browserMainChartBox' class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Discipline</h3>
                            <div class="form-group pull-right" style="width:150px !important;height:10px;padding-top:3px;margin-left:3px;">
                                <select class="form-control pull-left input-sm" style="margin-left: -10px;margin-top: 10px;" ng-model="selectedDisciplineYear" ng-change="changeDisciplineYear()">
                                    <option value="0"> All </option>
                                    <option  ng-repeat="obj in yearArray" ng-value="obj"> {{ obj}} </option>                                    
                                </select>
                            </div>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="discipline-pie" style="height: 600px;"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->

                </div><!-- /.col (LEFT) -->

                <div id="subdisciplineWiseStudentChart" class="col-md-6">
                    <!-- AREA CHART -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">
                                <span id="selectedUserVersion"></span>
                                Sub Discipline 
                            </h3>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="subdiscipline-pie" style="height: 600px;"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div>
            </div>
            <div class="row">
                <div id="instituteWiseStudentIntakeChart" class="col-md-12">
                    <!-- AREA CHART -->
                    <div id='browserMainChartBox' class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Institute Wise Student Intake</h3>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="instituteWiseStudentIntake-bar" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div><!-- /.col (LEFT) -->
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <!-- interactive chart -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title" ng-bind="studentLabel"></h3>
                        </div>
                        <div class="box-body">
                            <div style="overflow-y: auto;height:210px;width:100%;margin-top:5px;border:1px solid #e1e1e1;">
                                <table style="border:1px solid #e1e1e1;width:100%;">
                                    <thead style="border:1px solid #e1e1e1">
                                    <th class="borderClass">Name</th>
                                    <th class="borderClass">Course Name</th>
                                    <th class="borderClass">Seat Number</th>
                                    <th class="borderClass">Date of Birth</th>
                                    <th class="borderClass">Physical Handicap</th>
                                    <th class="borderClass">Caste</th>
                                    <th class="borderClass">Address1</th>
                                    <th class="borderClass">Address2</th>
                                    <th class="borderClass">Address3</th>
                                    <th class="borderClass">Pin code</th>
                                    <th class="borderClass">Result</th>
                                    <th class="borderClass">Passing Year</th>
                                    </thead>
                                    <tbody>
                                        <tr  ng-repeat="item in studentList" style="border:1px solid #e1e1e1;">
                                            <td class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.name"></span>  
                                            </td>
                                            <td class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.course_name"></span>  
                                            </td>
                                            <td class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.seat_no"></span>  
                                            </td>
                                            <td class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.dob"></span>  
                                            </td>
                                            <td class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.phy_hand"></span>  
                                            </td>
                                            <td class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.caste"></span>  
                                            </td>
                                            <td class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.add1"></span>  
                                            </td>
                                            <td class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.add2"></span>  
                                            </td>
                                            <td class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.add3"></span>  
                                            </td>
                                            <td class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.pincode"></span>  
                                            </td>
                                            <td class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.result"></span>  
                                            </td>
                                            <td class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.passing_year"></span>  
                                            </td>

                                        </tr>
                                    </tbody>
                                </table>
                            </div>    
                        </div><!-- /.box-body-->
                    </div><!-- /.box -->
                </div><!-- /.col -->
            </div>
        </section>
    </aside>
</div>