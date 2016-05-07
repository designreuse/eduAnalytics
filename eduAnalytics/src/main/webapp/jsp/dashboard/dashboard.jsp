<div ng-controller="dashboardcontroller">
    <aside class="right-side">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Dashboard
            </h1>
        </section>
        <!-- Main content -->
        <section class="content" ng-init="initCharts()">
            <!-- Small boxes (Stat box) -->
            <div class="row">
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-aqua">
                        <div class="inner">
                            <h3 ng-bind="dashboardObject.trainingschemecount">
                            </h3>
                            <p>
                                Total Training Schemes
                            </p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-person-stalker"></i>
                        </div>
                        <a href="#trainingscheme" class="small-box-footer">
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
                                    <span ng-bind="dashboardObject.institutecount"></span> 
                                </h3> 
                            </div>
                            <p>
                                Total Institutes
                            </p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-person-stalker"></i>
                        </div>
                        <a href="#institute" class="small-box-footer">
                            More info <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div><!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-yellow">
                        <div class="inner">
                            <h3 ng-bind="dashboardObject.coursecount">

                            </h3>
                            <p>
                                Total Courses
                            </p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-bag"></i>
                        </div>
                        <a href="#institute" class="small-box-footer">
                            More info <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div><!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-red">
                        <div class="inner">
                            <h3>
                                <span ng-bind="dashboardObject.studentcount"></span> 
                            </h3>
                            <p>
                                Total Students
                            </p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-pie-graph"></i>
                        </div>
                        <a href="#student" class="small-box-footer">
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