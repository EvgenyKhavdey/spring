angular.module('app', []).controller(`indexController`, function ($scope, $http) {

    const contextPath = 'http://localhost:8189';


    $scope.saveProduct = function () {
        $http.post(contextPath + '/product', $scope.NewProduct)
            .then(function (resp) {
                $scope.fillTable()
            });
    };

    $scope.fillTable = function () {
        $http.get(contextPath + '/product')
            .then(function (resp) {
                $scope.Product = resp.data
            })
    };

    $scope.removeProduct = function (id) {
        $http.delete(contextPath + '/product/'+id)
            .then(function (resp) {
                $scope.fillTable()
            })
    };


    $scope.quest = function () {
        $http.post(contextPath + '/product' + '/name', $scope.texts)
            .then(function (resp){
                $scope.Product = resp.data
            })
    };

    $scope.sort = function () {
        $http.get(contextPath + '/product' + '/sort')
            .then(function (resp){
                $scope.Product = resp.data
            })
    };

    $scope.fillTable()

});
