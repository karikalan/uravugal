/**
 * 
 */

var doughnutData = [ {
	value : 300,
	color : "#F7464A",
	highlight : "#FF5A5E",
	label : "Red"
}, {
	value : 50,
	color : "#46BFBD",
	highlight : "#5AD3D1",
	label : "Green"
}, {
	value : 100,
	color : "#FDB45C",
	highlight : "#FFC870",
	label : "Yellow"
}, {
	value : 40,
	color : "#949FB1",
	highlight : "#A8B3C5",
	label : "Grey"
}, {
	value : 120,
	color : "#4D5360",
	highlight : "#616774",
	label : "Dark Grey"
}

];

function loadCharts() {

	var count = 12;

	buildChart(count);
	for ( var idx = 0; idx < count; idx++) {
		drawChart("canvas-" + idx, doughnutData);
	}

}

function drawChart(canvasId, data) {
	var ctx = document.getElementById(canvasId).getContext("2d");	
	new Chart(ctx).Doughnut(data, {
		responsive : true
	});
}

function buildDiv(name) {
	/*
	 * <div id="canvas-holder-1" style="size: auto;"> <canvas id="chart-area-1"
	 * width="500" height="500"></canvas> </div>
	 */

	var div = document.createElement("div");
	div.id = "div-" + name;

	var canvas = document.createElement("canvas");
	canvas.id = "canvas-" + name;
	canvas.width = 300;
	canvas.height = 300;

	var title = document.createElement("label");
	title.innerHTML = "Title : Chart-"+name;
	
	canvas.appendChild(title);
	div.appendChild(canvas);
	return div;

}

function buildChart(count) {
	// alert("build");
	var table = document.getElementById("basetable");
	var tableCols = 4;
	var row;

	for ( var idx = 0; idx < count; idx++) {
		var mod = (idx % tableCols);
		if (mod == 0)
			row = table.insertRow(table.rows.length);
		var cell1 = row.insertCell(mod);
		cell1.appendChild(buildDiv(idx));
		
	}

}