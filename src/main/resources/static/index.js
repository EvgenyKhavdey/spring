angular.module('app', []).controller(`indexController`, function ($scope, $http) {

    const contextPath = 'http://localhost:8189';


    $scope.saveProduct = function () {
        $http.post(contextPath + '/app/v1/product', $scope.NewProduct)
            .then(function (resp) {
                $scope.fillTable()
            });
    };

    $scope.fillTable = function () {
        $http.get(contextPath + '/app/v1/product')
            .then(function (resp) {
                $scope.Product = resp.data
            })
    };

    $scope.removeProduct = function (id) {
        $http.delete(contextPath + '/app/v1/product/'+id)
            .then(function (resp) {
                $scope.fillTable()
            })
    };


    $scope.quest = function () {
        $http.post(contextPath + '/app/v1/product' + '/name', $scope.texts)
            .then(function (resp){
                $scope.Product = resp.data
            })
    };

    $scope.sort = function () {
        $http.get(contextPath + 'app/v1/product' + '/sort')
            .then(function (resp){
                $scope.Product = resp.data
            })
    };

    $scope.fillTable()

});

