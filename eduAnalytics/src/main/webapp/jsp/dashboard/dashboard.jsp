<div ng-controller="dashboardcontroller">
    <aside class="right-side">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Dashboard
            </h1>
<!--            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Dashboard</li>
            </ol>-->
        </section>

        <!-- Main content -->
        <section class="content" ng-init="initCharts()">

            <!-- Small boxes (Stat box) -->
            <div class="row">

                <!--                <div class="col-lg-3 col-xs-6" style="width:100%">
                                     small box 
                                    <div class="small-box" style="color: #f9f9f9 !important;background-color: #0275d8 !important;border-color: #0275d8 !important">
                                        <div class="inner">
                                            <h3>
                                                20
                                            </h3>
                                            <p>
                                                Total Users
                                            </p>
                                        </div>
                                        <div class="icon">
                                            <i class="ion ion-person-stalker"></i>
                                        </div>
                                        <a href="#" class="small-box-footer">
                                            More info <i class="fa fa-arrow-circle-right"></i>
                                        </a>
                                    </div>
                                </div>-->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- interactive chart -->
                        <div class="box box-primary">
                            <div class="box-header">
                                <div class="box-tools">
                                    <div class="container">
                                        <div class="row">
                                            <div class='col-sm-6'>
                                                <div class="form-group">
                                                    <div class='input-group date' id='datetimepicker1'>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="box-body">
                                <div id="datewiseActiveUsers" style="height: 250px"></div>
                            </div><!-- /.box-body-->
                        </div><!-- /.box -->
                    </div><!-- /.col -->
                </div>


                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-aqua">
                        <div class="inner">
                            <h3 ng-bind="dashBoardCount.totalUserCount">
                            </h3>
                            <p>
                                Total Users
                            </p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-person-stalker"></i>
                        </div>
                        <a href="#" class="small-box-footer">
                            More info <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div><!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-green">
                        <div class="inner">
                            <div style="white-space: nowrap;">
                                <h3>  
                                    <span ng-bind="dashBoardCount.averagePageLoadTime"></span> <span style="font-size: 30px;">ms</span>
                                </h3> 
                            </div>
                            <p>
                                Average Load Time
                            </p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-person-stalker"></i>
                        </div>
                        <a href="#" class="small-box-footer">
                            More info <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div><!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-yellow">
                        <div class="inner">
                            <h3 ng-bind="dashBoardCount.totalHttpCallsCount">

                            </h3>
                            <p>
                                Total HTTP Calls
                            </p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-bag"></i>
                        </div>
                        <a href="#" class="small-box-footer">
                            More info <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div><!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-red">
                        <div class="inner">
                            <h3>
                                <span ng-bind="dashBoardCount.averageErrorRate"></span> <sup style="font-size: 20px">%</sup>
                            </h3>
                            <p>
                                Error Rate
                            </p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-pie-graph"></i>
                        </div>
                        <a href="#" class="small-box-footer">
                            More info <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div><!-- ./col -->
            </div><!-- /.row -->

            <!-- top row -->
            <div class="row">
                <div class="col-xs-12 connectedSortable">

                </div><!-- /.col -->
            </div>
            <!-- /.row -->

            <!-- Main row -->

        </section><!-- /.content -->
    </aside><!-- /.right-side -->
</div>