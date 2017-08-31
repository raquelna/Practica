app.controller('ngAppControllerBuscador',
['$scope', '$http', '$timeout', function ($scope, $http, $timeout)
  {
    var timer =
    {
      buscar:
      {
        id: null,
        ms: 750
      }
    };

    $scope.buscarFn = function (e)
    {
      var value = e.target.value;

      $timeout.cancel(timer.buscar.id);
      timer.buscar.id = $timeout(function ()
      {
        $http.post('/getItems',
        {
          nombre: value
        })
        .then(function (response)
        {
          var data = response.data;

          $scope.items = data;
        });

      }, timer.buscar.ms);
    };

  }]);

