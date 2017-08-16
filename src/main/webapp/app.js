let routerApp = angular.module('ersApp', ['ui.router']);

routerApp.config(function($stateProvider, $urlRouterProvider) {
  $urlRouterProvider.otherwise('/login');
  
   $stateProvider.state('login', {
    url: '/login',
    templateUrl: 'partial-login.html'
  }).state('manager', {
    url: '/manager',
    templateUrl: 'partial-manager.html',
    controller: 'managerCtrl'
  }).state('manager.home', {
    url: '/home',
    templateUrl: 'partial-manager-home.html'
  }).state('manager.employees', {
    url: '/employees',
    templateUrl: 'partial-manager-employees.html'
  }).state('manager.create', {
    url: '/createEmployee',
    templateUrl: 'partial-manager-create.html'
  }).state('manager.view', {
    url: '/view?employeeId',
    templateUrl: 'partial-manager-view.html',
    controller: function($scope, $stateParams, $http) {
     $scope.user = $http.get('RevatureReimbursement/api/users/$stateParams.employeeId');
  }}).state('employee', {
    url: '/employee',
    templateUrl: 'partial-employee.html',
    controller: 'employeeCtrl'
  }).state('employee.create', {
    url: '/createRequest',
    templateUrl: 'partial-employee-create.html'
  }).state('employee.home', {
    url: '/home',
    templateUrl: 'partial-employee-home.html'
  }).state('employee.user', {
    url: '/user',
    templateUrl: 'partial-employee-user.html'
  }).state('employee.edit', {
    url: '/editUser',
    templateUrl: 'partial-employee-edit.html'
  });
  
});