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
      var color = document.querySelector('#resultado');
      
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
          
          $scope.resultado = data.length;
//          console.log(resultado);
           color.style.color = 'black';
          if(data.length === 0)
          {
              color.style.color = 'red';
          }
          
        });

      }, timer.buscar.ms);
    };
    

  }]);

