angular.module('paperandplastic.services', [])

  .factory('turns', function () {
    // Might use a resource here that returns a JSON array

    // Some fake testing data
    var turns = [{
      id: 0,
      date: 'Ben Sparrow',
      info: 'You on your way?'
    }, {
      id: 1,
      date: 'Max Lynx',
      info: 'Hey, it\'s me'
    }, {
      id: 2,
      date: 'Adam Bradleyson',
      info: 'I should buy a boat'
    }, {
      id: 3,
      date: 'Perry Governor',
      info: 'Look at my mukluks!'
    }, {
      id: 4,
      date: 'Mike Harrington',
      info: 'This is wicked good ice cream.'
    }];

    return {
      all: function () {
        return turns;
      },
      remove: function (turn) {
        turns.splice(turns.indexOf(turn), 1);
      },
      get: function (turnId) {
        for (var i = 0; i < turns.length; i++) {
          if (turns[i].id === parseInt(turnId)) {
            return turns[i];
          }
        }
        return null;
      }
    };
  });

