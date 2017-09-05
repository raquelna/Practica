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
    
    
    (function ()
    {
        
        $http.post('/getItems',
        {
          nombre: ''
        })
        .then(function (response)
        {
          var data = response.data;

          $scope.items = data;
        });
        
    })();
    
    
    
    

    $scope.buscarFn = function (e)
    {
      var value = e.target.value;
      
      $timeout.cancel(timer.buscar.id);
      timer.buscar.id = $timeout(function ()
      {
        $http.post('/buscarItems',
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

