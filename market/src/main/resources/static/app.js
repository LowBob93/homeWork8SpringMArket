angular.module('market-front', []).controller('appController', function ($scope, $http) {

    const contextPath = 'http://localhost:8189/market/';
    let currentPage = 1;

    $scope.loadProducts = function (pageIndex=currentPage) {
            $http({
                url: contextPath + 'products',
                method: 'GET',
                params: {
                    p: pageIndex
                }
            }).then(function (response) {
                if (response.data.numberOfElements < 1){
                    console.log()
                    $scope.loadProducts(response.data.totalPages)
                } else {
                    console.log(response);
                    $scope.productsPage = response.data;

                }
            });
        }

    $scope.removeProduct = function (product) {
        $http.get(contextPath + 'products/delete/' + product.id)
            .then(function (response) {
                console.log(response);
                $scope.loadProducts();
            });
    }

    $scope.showInfo = function (product) {
        alert("Product: " +product.title +" Price: "+ product.price)
    }

    $scope.loadProducts(currentPage);

    $scope.loadPreviousPage = function () {
            currentPage--;
            $scope.loadProducts();
        }


    $scope.loadNextPage = function () {
            currentPage++;
            $scope.loadProducts();
        }


});
