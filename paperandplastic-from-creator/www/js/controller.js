angular.module('papperandplastic.controllers', [])

  .controller('BookCtrl', function ($scope) {
  })

  .controller('HistoryCtrl', function ($scope, turns) {
    // With the new view caching in Ionic, Controllers are only called
    // when they are recreated or on app start, instead of every page change.
    // To listen for when this page is active (for example, to refresh data),
    // listen for the $ionicView.enter event:
    //
    //$scope.$on('$ionicView.enter', function(e) {
    //});
    $scope.chats = turns.all();
    $scope.remove = function (turn) {
      turns.remove(turn);
    };

  })

  .controller('HistoryDetailCtrl', function ($scope, $stateParams, turns) {
    $scope.chat = turns.get($stateParams.turnId);
  })

  .controller('AccountCtrl', function ($scope) {
  });
