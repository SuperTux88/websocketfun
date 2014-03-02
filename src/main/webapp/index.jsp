<html>
	<head>
		<script>
			var connection = new WebSocket('ws://remote.coding4coffee.org:8080/foo');
			connection.onopen = function() {
				connection.send("ping");
			};
		
			connection.onmessage = function(e) {
				document.getElementById("messages").innerHTML = e.data;
			};
		</script>
	</head>
	<body>
	
	<pre id="messages">
	
	</pre>
	
	</body>
</html>
