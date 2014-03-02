<html>
	<head>
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
	
	<pre id="messages">
	
	</pre>
	
	</body>
</html>
