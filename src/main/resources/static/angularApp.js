    var app = angular.module('app', []);

    app.controller('indexController',['$scope','$http', function($scope, $http){
    	$scope.IsVisible = false;
    	$scope.IsCasesVisible = false;

        $scope.ShowHideTxns = function(){ //toggle visibility
            $scope.IsVisible = $scope.IsVisible ? false : true;
        };
        $scope.ShowHideCases = function(){ //toggle visibility
            $scope.IsCasesVisible = $scope.IsCasesVisible ? false : true;
        };
    	$scope.showTransactions = function(){
    		$scope.IsCasesVisible = false;
    		console.log($scope.merchantId);			
    		getTransactions($scope.merchantId);
    		$scope.ShowHideTxns();
    	};
        
    	$scope.showCases = function(){
    		$scope.IsVisible = false;
    		console.log($scope.merchantId);			
    		getCases($scope.merchantId);
    		$scope.ShowHideCases();		
    		$scope.showAddCases = false;
    	};
    	
    	$scope.addCase = function(){
    		$scope.showAddCases = true;
    		$scope.createdstatus = "Submit new case";
    	};
    	
    	$scope.submitCase = function(){
    		console.log($scope.casestatus);
    		console.log($scope.casedesc);
    		createCase($scope);
    	};
    	
    	$scope.editCase = function(){
    		console.log('Editing row');    		
    		var currentRow = $(this).parents('tr');
    		//var currentTD = $(this).parents('tr').find('td');
    		console.log(currentRow);
    		
    		//$.each(currentTD, function () {
                //$(this).prop('contenteditable', true)
    			//console.log($(this).html());
            //});
    	}
    	
    	function getTransactions(mid){
    		var url = "http://localhost:8080/transactions/list/" + mid;
    		console.log(url)
    		$http.get(url).then(function (response) {
    			console.log(response);
    			$scope.getDivAvailable = true;
    			$scope.listTransactions = response.data;
    			console.log(response.data);			
    		}, function error(response) {
    			$scope.postResultMessage = "Error Status: " +  response.statusText;
    		});
    		
    	}
    	
    	function getCases(mid){		
    		var url = "http://localhost:8080/cases/list/" + mid;		
    		$http.get(url).then(function (response) {
    			console.log(response);
    			$scope.getDivAvailable = true;
    			$scope.listCases = response.data;
    			console.log(response.data);
    		}, function error(response) {
    			$scope.postResultMessage = "Error Status: " +  response.statusText;
    		});
    	}
    	
    	function createCase($scope){
    		var today = new Date();
    		todaysDate = today.getDate();
    		console.log("Status: " + $scope.casestatus);
    		console.log("Desc: " + $scope.casedesc);
    		console.log("Date: " + todaysDate);
    	    $http({
    	        	url: 'http://localhost:8080/cases/create',
    	        	method: "POST",
    	        	data:  {
    	        		"created":today,
    	        		"description": $scope.casedesc,
    	        		"status": $scope.casestatus,
    	        		"merchantid":"test"
    	    		}})
    	    .then(function(response) {
				$scope.createdstatus = "Successful";
    	    }, 
    	    function(response) { // optional
    	    	$scope.createdstatus = "Failed";
    	    });
    		
    		}
    	}]);