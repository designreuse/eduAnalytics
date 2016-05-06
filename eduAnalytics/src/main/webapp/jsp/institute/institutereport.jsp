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
<div ng-controller="institutereportcontroller">
    <aside class="right-side">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Institute Wise
            </h1>
        </section>

        <!-- Main content -->
        <section class="content" ng-init="initCharts()">

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
                <div id="disciplineWiseInstituteChart" class="col-md-6">
                    <!-- AREA CHART -->
                    <div id='browserMainChartBox' class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Discipline Wise Institute Count</h3>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="disciplinewiseinstitute-pie" style="height: 500px;"></div>
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
                                Discipline wise Institute List
                            </h3>
                        </div>
                        
                        <div class="box-body chart-responsive">
                            <div style="overflow-y: auto;height:210px;width:100%;margin-top:5px;border:1px solid #e1e1e1;">
                                <table style="border:1px solid #e1e1e1;width:100%;">
                                    <thead style="border:1px solid #e1e1e1">
                                    <th class="borderClass">Discipline</th>
                                    <th class="borderClass">Institute</th>
                                    <th class="borderClass">Training Scheme</th>
                                    </thead>
                                    <tbody>
                                        <tr  ng-repeat="item in disciplineWiseInsList" style="border:1px solid #e1e1e1;">
                                            <td width="40%" class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.discipline"></span>  
                                            </td>
                                            <td width="30%" class="borderClass" style="text-align: left;" ng-click="openInstituteDetailModal(item.institutename)">
                                                <span ng-bind="item.institutename"></span>  
                                            </td>
                                            <td width="30%" class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.schemetype"></span>  
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div> 
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div>
            </div>

            <div class="row">
                <div id="subdisciplineWiseInstituteChart" class="col-md-12">
                    <!-- AREA CHART -->
                    <div id='browserMainChartBox' class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Sub Discipline Wise Institute Count</h3>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="subdisciplinewiseinstitute-pie" style="height: 500px;"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div><!-- /.col (LEFT) -->
            </div>



            <div class="row">
                <div id="instituteChart" class="col-md-12">
                    <!-- AREA CHART -->
                    <div id='browserMainChartBox' class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Institute</h3>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="institute-line" style="height: 300px;"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div><!-- /.col (LEFT) -->
            </div>
            <div class="row">
                <div id="institute_ts_Chart" class="col-md-12">
                    <!-- AREA CHART -->
                    <div id='browserMainChartBox' class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Institute</h3>
                        </div>
                        <div class="box-body chart-responsive">
                            <div class="chart" id="institute_sub_trainingscheme-line" style="height: 300px;"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div><!-- /.col (LEFT) -->
            </div>

            <!-- Modal -->
            <div id="institutedetailModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Institute Detail</h4>
                        </div>
                        <div class="modal-body">
                            <table border="1" style="width: 100%">
                                <tr>
                                    <td style="width: 20%">Name</td>
                                    <td>{{instituteOject.name}}</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Established Year</td>
                                    <td>{{instituteOject.established_year}}</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Email</td>
                                    <td>{{instituteOject.email}}</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Address</td>
                                    <td>{{instituteOject.address}}</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">City</td>
                                    <td>{{instituteOject.city}}</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Pincode</td>
                                    <td>{{instituteOject.pincode}}</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Zone</td>
                                    <td>{{instituteOject.zone}}</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">District</td>
                                    <td>{{instituteOject.distict}}</td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
            
            <!-- Modal -->
            <div id="institutefromSubDisciplineModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Institute Detail</h4>
                        </div>
                        <div class="modal-body">
                            <table border="1" style="width: 100%">
                                <tr>
                                    <th>Course Name</th>
                                    <th>Institute Name</th>
                                </tr>
                                <tr ng-repeat="item in courseWiseInsList">
                                    <td style="width: 40%">{{item.coursename}}</td>
                                    <td>{{item.institutename}}</td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>

        </section>
    </aside>
</div>