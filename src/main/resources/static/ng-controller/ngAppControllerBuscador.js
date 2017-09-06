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
    
    var msg =
    {
      el: document.querySelector('#msg > span'),
      style:
      {
        classNotFound: 'notFound'
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
          nombre: value,
          descripcion:value
        })
        .then(function (response)
        {
          var data = response.data;
          

//          $scope.items = data;
          
          scopeItems(data);
          
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
    
    function scopeItems(data)
    {
      var length = data.length;

      msg.el.classList.remove(msg.style.classNotFound);

      if (length > 0)
      {
        $scope.items = data;
      }
      else
      {
        msg.el.classList.add(msg.style.classNotFound);
      }

      $scope.msg = data.length;
    }
    

  }]);

