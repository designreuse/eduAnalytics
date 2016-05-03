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
        </section>
    </aside>
</div>