angular.module('app', []).controller(`indexController`, function ($scope, $http) {

    const contextPath = 'http://localhost:8188/security/api/v1';

    $scope.logout = function () {
        $http.get('/logout')
    };

    $scope.fillTable = function (pageIndex = 1) {
        $http({
            url: contextPath + '/product',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            $scope.ProductsPage = response.data;

            let minPageIndex = pageIndex - 2;
            if (minPageIndex < 1) {
                minPageIndex = 1;
            }

            let maxPageIndex = pageIndex + 2;
            if (maxPageIndex > $scope.ProductsPage.totalPages) {
                maxPageIndex = $scope.ProductsPage.totalPages;
            }

            $scope.PaginationArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);
        });
    };

    $scope.generatePagesIndexes = function(startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.saveProduct = function () {
        $http.post(contextPath + '/product', $scope.NewProduct)
            .then(function (resp) {
                $scope.newProduct = null;
                $scope.fillTable()
            });
    };

    $scope.removeProduct = function (id) {
        $http.delete(contextPath + '/product/'+id)
            .then(function (resp) {
                $scope.fillTable()
            })
    };

    $scope.showCart = function () {
        $http({
            url: contextPath + '/cart',
            method: 'GET'
        }).then(function (response) {
            $scope.Cart = response.data;
        });
    };

    $scope.addToCart = function (productId) {
        $http.put(contextPath + '/cart/add/' + productId)
            .then(function (response) {
                $scope.showCart();
            });
    }

    $scope.clearCart = function () {
        $http.get(contextPath + '/cart/clear')
            .then(function (response) {
                $scope.showCart();
            });
    }

    $scope.fillTable();
    $scope.showCart();

});

