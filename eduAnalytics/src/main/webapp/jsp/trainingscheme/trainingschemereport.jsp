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
                <div id="trainingschemeWiseStudentChart" class="col-md-6">
                    <!-- AREA CHART -->
                    <div id='browserMainChartBox' class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Training scheme</h3>
                            <div class="form-group pull-right" style="width:150px !important;height:10px;padding-top:3px;margin-left:3px;">
                                <select class="form-control pull-left input-sm" style="margin-left: -10px;margin-top: 10px;" ng-model="selectedYear" ng-change="changeYear()">
                                    <option value="0"> All </option>
                                    <option  ng-repeat="obj in yearArray" ng-value="obj"> {{ obj }} </option>                                    
                                </select>
                            </div>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="trainingscheme-pie" style="height: 600px;"></div>
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
                                Sub Training Scheme Wise 
                            </h3>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="subtrainingscheme-pie" style="height: 600px;"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div>
            </div>
        </section>
    </aside>
</div>