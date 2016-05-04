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
<div ng-controller="trainingschemecontroller">
    <aside class="right-side">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Training scheme Wise
            </h1>
        </section>
        <!-- Main content -->
        <section class="content" ng-init="initCharts()">
            <div class="row">
                <div class="col-xs-12">
                    <!-- interactive chart -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Training scheme</h3>
                        </div>
                        <div class="box-body">
                            <div style="overflow-y: auto;height:210px;width:100%;margin-top:5px;border:1px solid #e1e1e1;">
                                <table style="border:1px solid #e1e1e1;width:100%;">
                                    <thead style="border:1px solid #e1e1e1">
                                    <th class="borderClass">Name</th>
                                    <th class="borderClass">Type</th>
                                    <th class="borderClass">Comment</th>
                                    </thead>
                                    <tbody>
                                        <tr  ng-repeat="item in trainingschemeArray" style="border:1px solid #e1e1e1;">
                                            <td width="40%" class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.name"></span>  
                                            </td>
                                            <td width="30%" class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.schemetype"></span>  
                                            </td>
                                            <td width="30%" class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.comment"></span>  
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>    
                        </div><!-- /.box-body-->
                    </div><!-- /.box -->
                </div><!-- /.col -->
            </div>
            <div class="row">
                <div id="trainingschemeWiseInstituteChart" class="col-md-6">
                    <!-- AREA CHART -->
                    <div id='browserMainChartBox' class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Training scheme Wise Institute Count</h3>
                            <div class="form-group pull-right" style="width:150px !important;height:50px;padding-top:3px;margin-left:3px;">
                                Established year : <select class="form-control pull-left input-sm" style="margin-left: -10px;margin-top: 10px;" ng-model="selectedInstituteYear" ng-change="changeInstituteYear()">
                                    <option value="0"> All </option>
                                    <option  ng-repeat="obj in yearArray" ng-value="obj"> {{ obj}} </option>                                    
                                </select>
                            </div>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="trainingschemewiseinstitute-pie" style="height: 600px;"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->

                </div><!-- /.col (LEFT) -->

                <div id="subtrainingschemeWiseInstituteChart" class="col-md-6">
                    <!-- AREA CHART -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">
                                <span id="selectedUserVersion"></span>
                                Sub Training Scheme Wise Institute Count
                            </h3>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="subtrainingschemewiseinstitute-pie" style="height: 600px;"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div>
            </div>
            <div class="row">
                <div id="trainingschemeWiseStudentChart" class="col-md-6">
                    <!-- AREA CHART -->
                    <div id='browserMainChartBox' class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Training scheme Wise Student Count</h3>
                            <div class="form-group pull-right" style="width:150px !important;height:10px;padding-top:3px;margin-left:3px;">
                                <select class="form-control pull-left input-sm" style="margin-left: -10px;margin-top: 10px;" ng-model="selectedStudentYear" ng-change="changeStudentYear()">
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
        </section>
    </aside>
</div>