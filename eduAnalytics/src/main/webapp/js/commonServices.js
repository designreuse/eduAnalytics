/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


ecwAnalyticsApp.service('commonService', function($http) {
    return {
        getAPUList: function() {
            try {
                return $http({
                    method: "GET",
                    url: "/analytics/generalreportscontroller.jsp?action=getAPUList",
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                    dataType: 'text'
                });
            } catch (err) {
                console.log(err);
            }
        },
        getProductList: function() {
            try {
                return $http({
                    method: "GET",
                    url: "/analytics/generalreportscontroller.jsp?action=getProductList",
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                    dataType: 'text'
                });
            } catch (err) {
            }
        }
    };
});