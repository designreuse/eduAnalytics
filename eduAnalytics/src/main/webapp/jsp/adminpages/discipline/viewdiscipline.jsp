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
<div ng-controller="viewdisciplinecontroller">
    <aside class="right-side">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
               View Disciplines
            </h1>
        </section>
        <!-- Main content -->
        <section class="content" ng-init="loadDisciplines()">
            <div class="row">
                <div class="col-xs-12">
                    <!-- interactive chart -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Discipline</h3>
                        </div>
                        <div class="box-body">
                            
                            <div class="col-xs-12">
                                <div class="dataTables_filter" id="example1_filter">
                                    <label>Search: <input type="text" size="50" aria-controls="example1" ng-model="search.$"></label>
                                </div>
                            </div>
                            
                            <div style="overflow-y: auto;height:300px;width:100%;margin-top:5px;border:1px solid #e1e1e1;">
                                <table style="border:1px solid #e1e1e1;width:100%;">
                                    <thead style="border:1px solid #e1e1e1">
                                    <th class="borderClass">Name</th>
                                    </thead>
                                    <tbody>
                                        <tr  ng-repeat="item in disciplineArray | filter:search " style="border:1px solid #e1e1e1;">
                                            <td width="40%" class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.name"></span>  
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