angular.module('market-front', []).controller('appController', function ($scope, $http) {

    const contextPath = 'http://localhost:8189/market/api/v1/';
    let currentPage = 1;

    $scope.loadProducts = function (pageIndex = 1) {
            currentPageIndex = pageIndex;
            $http({
                url: contextPath + 'products',
                method: 'GET',
                params: {
                    p: pageIndex
                }
            }).then(function (response) {
                console.log(response);
                $scope.productsPage = response.data;
                $scope.paginationArray = $scope.generatePagesIndexes(1, $scope.productsPage.totalPages);
            });
        }


    $scope.removeProduct = function (product) {
        $http.delete(contextPath + 'products/' + product.id)
            .then(function (response) {
                console.log(response);
                $scope.loadProducts(currentPageIndex);
            });
    }

    $scope.showInfo = function (product) {
        alert("Product: " +product.title +" Price: "+ product.price)
    }

    $scope.loadProducts(currentPage);

   $scope.nextPage = function () {
           currentPageIndex++;
           if (currentPageIndex > $scope.productsPage.totalPages) {
               currentPageIndex = $scope.productsPage.totalPages;
           }
           $scope.loadProducts(currentPageIndex);
       }

       $scope.prevPage = function () {
           currentPageIndex--;
           if (currentPageIndex < 1) {
               currentPageIndex = 1;
           }
           $scope.loadProducts(currentPageIndex);
       }

    $scope.createNewProduct = function () {
            $http.post(contextPath + 'products', $scope.new_product)
            .then(function successCallback (response){
            $scope.loadProducts(currentPageIndex);
            $scope.new_product = null;
            },function failCallback (response){
                          alert(response.data.message);
            });
    }

    $scope.updateProduct = function () {
            $http.put(contextPath + 'products', $scope.new_product)
                .then(function (response) {
                        $scope.loadProducts(currentPageIndex);
                        $scope.new_product = null;
                    });
        }


    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

});
