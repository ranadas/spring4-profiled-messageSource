/**
 * Created by rdas on 12/09/2016.
 */

'use strict';
console.log("in Angular js!");
var app = angular.module('ranaAngApp',[]);

app.controller('IndexPageController', function ($scope) {
    console.log(" in IndexPageController");
    /* Model */
    $scope.items = [
        {desc: 'Go shopping', done: false},
        {desc: 'Clean my room', done: true},
        {desc: 'Sleep', done: false}
    ];

    $scope.newItemDescription = '';

    /* Events */
    $scope.addItem = function () {
        $scope.items.push({
            desc: $scope.newItemDescription,
            done: false
        });
    };

    $scope.removeItem = function (index) {
        $scope.items.splice(index, 1);
    };

});