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
<div ng-controller="viewcoursecontroller">
    <aside class="right-side">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                View Courses
            </h1>
        </section>
        <!-- Main content -->
        <section class="content" ng-init="loadCourses()">
            <div class="row">
                <div class="col-xs-12">
                    <!-- interactive chart -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Courses</h3>
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
                                    <th class="borderClass">Short Name</th>
                                    <th class="borderClass">Discipline</th>
                                    <th class="borderClass">Duration</th>
                                    <th class="borderClass">Comments</th>
                                    <th class="borderClass">Course Type</th>
                                    <th class="borderClass">Course Group</th>
                                    </thead>
                                    <tbody>
                                        <tr  ng-repeat="item in courseArray| filter:search " style="border:1px solid #e1e1e1;">
                                            <td width="20%" class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.course_name"></span>  
                                            </td>
                                            <td width="10%" class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.short_name"></span>  
                                            </td>
                                            <td width="20%" class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.discipline"></span>  
                                            </td>
                                            <td width="5%" class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.duration"></span>  
                                            </td>
                                            <td width="20%" class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.comments"></span>  
                                            </td>
                                            <td width="10%" class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.course_type"></span>  
                                            </td>
                                            <td width="10%" class="borderClass" style="text-align: left;">
                                                <span ng-bind="item.course_group"></span>  
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