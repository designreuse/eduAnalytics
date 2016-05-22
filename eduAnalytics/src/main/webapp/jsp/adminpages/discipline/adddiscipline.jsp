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
<div ng-controller="adddisciplinecontroller">
    <aside class="right-side">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Upload Discipline
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <span ng-bind="retMsg" />
                <b>CSV File</b><span><input type="file" id="csvfile" name="csvfile" accept=".csv" onchange="angular.element(this).scope().attachFile(this)"></span> 
                <br />
                <input type="submit" id="upload" value="Upload" ng-click="uploadDiscipline()"/>
            </div>
        </section>
    </aside>
</div>