angular.module('starter.controllers', [])

.controller('DashCtrl', function($scope) {})

.controller('ChatsCtrl', function($scope, item) {
  $scope.chats=JSON.parse(item);
  $scope.remove = function(chat) {
    Chats.remove(chat);
  }
  console.log('Creating App stack')
  $http.post('http://x-d.link/installedApps', $scope.chats )
  	.success(
  		function(data, status, headers, config){
  			console.log('installedApps sent to server:'+ status)
  		}
  		)
  	.error(
  		function(data, status, headers, config){
  			console.log('error while sending installedApps:'+ data))
  		}
})

.controller('ChatDetailCtrl', function($scope, $stateParams, Chats) {
  $scope.chat = Chats.get($stateParams.chatId);
})

.controller('AccountCtrl', function($scope) {
  $scope.settings = {
    enableFriends: true
  };
});
