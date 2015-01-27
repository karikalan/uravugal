<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script src="../script/Chart.js"></script>
<script>
	function clearContext(ctx, canvas) {
		ctx.clearRect(0, 0, canvas.width, canvas.height);
	}

	function changeChartType(type) {
		//alert(' inside char type ' + type);
		var datafromServer = ${msg}
		;
		var canvas = document.getElementById("canvas");
		var ctx = canvas.getContext("2d");
		//ctx.clear();
		clearContext(ctx, canvas);

		alert(document.getElementById("head").value);
		document.getElementById("head").value = "Data Representation - " + type;
		window.myBar = null;
		window.myRadar = null;
		window.myLine = null;

		if (type = 'Line') {

			window.myLine = new Chart(ctx).Line(datafromServer, {
				responsive : true
			});
		}
		if (type = 'Bar') {
			;
			window.myBar = new Chart(ctx).Bar(datafromServer, {
				responsive : true
			});
		}
		if (type = 'Radar') {

			window.myRadar = new Chart(ctx).Radar(datafromServer, {
				responsive : true
			});
		}
	}
</script>
</head>
<body>
	<label id="head"> Data Representation - Bar </label>
	<input type="button" value="Line Chart"
		onclick="changeChartType('Line')" />
	<input type="button" value="Bar Chart" onclick="changeChartType('Bar')" />
	<input type="button" value="Radar Chart"
		onclick="changeChartType('Radar')" />


	<div style="width: 70%">
		<canvas id="canvas" height="450" width="800"></canvas>
	</div>





	<script>
		var randomScalingFactor = function() {
			return Math.round(Math.random() * 100)
		};

		var datafromServer = $
		{
			msg
		};

		//alert(" Data :" + datafromServer.length);

		window.onload = function() {
			var ctx = document.getElementById("canvas").getContext("2d");
			//	alert(datafromServer);
			window.myBar = new Chart(ctx).Bar(datafromServer, {
				responsive : true
			});

		}
	</script>

</body>
</html>