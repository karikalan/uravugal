/**
 * 
 */

function buildChart(indexName,data) {

	var table = document.getElementById("basetable");
	row = table.insertRow(table.rows.length);
	cell1 = row.insertCell(0);
	cell1.appendChild(buildDiv(indexName));

	var ctx = document.getElementById("canvas-" + indexName).getContext("2d");
	new Chart(ctx).Bar(data, {
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
	title.innerHTML = "Title : Chart-" + name;

	canvas.appendChild(title);
	div.appendChild(canvas);
	return div;

}