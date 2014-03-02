<html ng-app>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.14/angular.min.js" type="text/javascript"></script>
		<script>
			function websocketUrl(s) {
			    var l = window.location;
			    return ((l.protocol === "https:") ? "wss://" : "ws://") + l.hostname + (((l.port != 80) && (l.port != 443)) ? ":" + l.port : "") + (s.indexOf('/') < 0 ? l.pathname : '') + s;
			}
			var connection = new WebSocket(websocketUrl('foo'));
			connection.onopen = function() {
				connection.send("ping");
			};
		
			connection.onmessage = function(e) {
				document.getElementById("messages").innerHTML = e.data;
			};
		</script>
	</head>
	<body>
	
	<p>hallo {{hallo}} :)</p>
	
	name: <input type="text" ng-model="hallo" />
	
	<pre id="messages">
	
	</pre>
	</body>
</html>
