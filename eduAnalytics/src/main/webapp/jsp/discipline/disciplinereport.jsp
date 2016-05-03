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
<div ng-controller="disciplinereportcontroller">
    <aside class="right-side">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Discipline Wise
            </h1>
        </section>

        <!-- Main content -->
        <section class="content" ng-init="initCharts()">
            <div class="row">
                <div id="disciplineWiseStudentChart" class="col-md-6">
                    <!-- AREA CHART -->
                    <div id='browserMainChartBox' class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Discipline</h3>
                            <div class="form-group pull-right" style="width:150px !important;height:10px;padding-top:3px;margin-left:3px;">
                                <select class="form-control pull-left input-sm" style="margin-left: -10px;margin-top: 10px;" ng-model="selectedYear" ng-change="changeYear()">
                                    <option value="0"> Select Year </option>
                                    <option  ng-repeat="obj in yearArray" ng-value="obj"> {{ obj }} </option>                                    
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
                                Version 
                            </h3>
                            <div class="form-group pull-right" style="height:10px;padding-top:10px;margin-left:3px;margin-right: 10px;">
                                <button class="btn btn-default" ng-click="backToBrowserMainChart()" >Back</button>
                            </div>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="user-device-version-pie" style="height: 600px;"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->

                </div>

                <div  class="col-md-6" id='browserStatistics'>
                    <div class="row">
                        <!-- AREA CHART -->
                        <div id='browserStatisticsBox' class="box box-primary">
                            <div class="box-header">
                                <i class="fa fa-bar-chart-o"></i>
                                <h3 class="box-title">Browser Statistics</h3>                            
                            </div>
                            <div class="box-body chart-responsive">                            
                                <div class="" >


                                    <div >

                                        <div ng-if='chromeCount' class="browserStat big">
                                            <img src="/analytics/img/browser-chrome-big.png" alt="Chrome">
                                            <span> {{chromeCount}} Users </span>
                                        </div>
                                        <div ng-if='firefoxCount' class="browserStat big">
                                            <img src="/analytics/img/browser-firefox-big.png" alt="Firefox">
                                            <span> {{firefoxCount}} Users </span>
                                        </div>
                                        <div ng-if='ieCount' class="browserStat">
                                            <img src="/analytics/img/browser-ie.png" alt="Internet Explorer">
                                            <span> {{ieCount}} Users </span>
                                        </div>
                                        <div ng-if='safariCount' class="browserStat">
                                            <img src="/analytics/img/browser-safari.png" alt="Safari">
                                            <span> {{safariCount}} Users </span>
                                        </div>
                                        <div ng-if='operaCount' class="browserStat">
                                            <img src="/analytics/img/browser-opera.png" alt="Opera">
                                            <span> {{operaCount}} Users </span>
                                        </div>	
                                    </div>
                                </div>
                                <br>
                                
                            </div><!-- /.box-body -->
                        </div><!-- /.box -->
                    </div>
                    
                    <div class="row">
                        <div id='browserStatisticsBox' class="box box-primary">
                            <div class="box-header">
                                <i class="fa fa-bar-chart-o"></i>
                                <h3 class="box-title">User Type</h3>                            
                            </div>
                            <div class="box-body chart-responsive">                            
                                <div class="chart" id="user-type-pie"></div>                                                         
                            </div><!-- /.box-body -->
                        </div><!-- /.box -->
                        
                    </div>
                    
                   

                </div><!-- /.col (LEFT) -->

            </div>


            <div class="row">
                <div class="col-md-6">
                    <!-- AREA CHART -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Screen Resolution</h3>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="resoultionChart" style="height: 600px;"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->

                </div><!-- /.col (LEFT) -->
                <div class="col-md-6">
                    <!-- LINE CHART -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Operating System Usage</h3>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="osChart" style="height: 600px;"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div><!-- /.col (RIGHT) -->
            </div><!-- /.row -->

        </section>
    </aside>
</div>