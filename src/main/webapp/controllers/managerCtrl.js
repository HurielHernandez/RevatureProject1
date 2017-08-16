angular.module('ersApp').controller('managerCtrl', function($scope, $http) {

  $scope.user = {username:'Robert', firstName:'John', lastName:'Louis', email: "email@email.com", userId:5};
  
  $http.get("/RevatureReimbursement/api/users/sample").then(function(response) {
      $scope.user = response.data;
  });

  $http.get("/RevatureReimbursement/api/users").then(function(response) {
      $scope.users = response.data;
  });

  $http.get("/RevatureReimbursement/api/reimbursements").then(function(response) {
      $scope.reimbursements = response.data;
  });


	
});
