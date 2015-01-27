/**
 * 
 */

var nodes = null;
var edges = null;
var network = null;

var relateSaveArray = [];

var dataSaveArray = [];
var dataDeleteArray = [];
var dataUpdateArray = [];

function draw(inputnodes, inputedges) {
	nodes = inputnodes;
	edges = inputedges;

	
	// create a network
	var container = document.getElementById('mynetwork');
	var data = {
		nodes : nodes,
		edges : edges
	};
	var options = {
		stabilize : false,
		dataManipulation : true,
		onAdd : function(data, callback) {
			var span = document.getElementById('operation');
			var idInput = document.getElementById('node-id');
			var createdAt = document.getElementById('created-at');
			var labelInput = document.getElementById('node-label');
			var moonsInput = document.getElementById('node-moons');
			var saveButton = document.getElementById('saveButton');
			var cancelButton = document.getElementById('cancelButton');
			var div = document.getElementById('network-popUp');
			span.innerHTML = "Add Node";
			idInput.value = data.id;
			createdAt.value - idInput.value;
			labelInput.value = data.label;
			moonsInput.value = "1";
			saveButton.onclick = saveData.bind(this, data, callback);
			cancelButton.onclick = clearPopUp.bind();
			div.style.display = 'block';
		},
		onEdit : function(data, callback) {
			var span = document.getElementById('operation');
			var idInput = document.getElementById('node-id');
			var createdAt = document.getElementById('created-at');
			var labelInput = document.getElementById('node-label');
			var moonsInput = document.getElementById('node-moons');
			var saveButton = document.getElementById('saveButton');
			var cancelButton = document.getElementById('cancelButton');
			var div = document.getElementById('network-popUp');
			span.innerHTML = "Edit Node";
			idInput.value = data.id;
			labelInput.value = data.label;
			moonsInput.value = data.moons;
			createdAt.value = data.createdAt;
			alert(data);
			pushDataForSave(data, 'update');
			saveButton.onclick = saveData.bind(this, data, callback);
			cancelButton.onclick = clearPopUp.bind();
			div.style.display = 'block';
		},
//		onConnect : function(data, callback) {
//			alert(" Edgeing " + data.from + " ----- " + data.to)
//			if (data.from == data.to) {
//				var r = confirm("Do you want to connect the node to itself?");
//				if (r == true) {
//					callback(data);
//				}
//			} else {
//				callback(data);
//			}
//		}
		
		
		onConnect : function(data, callback) {

			alert("Edging :" + JSON.stringify(data));

			var saveButton = document.getElementById('saveRelateButton');
			var cancelButton = document
					.getElementById('cancelRelateButton');
			var div = document.getElementById('relation-popUp');
			div.style.display = 'block';
			
			saveButton.onclick = saveRelateData.bind(this, data, callback);
			cancelButton.onclick = clearRelationPopUp.bind();
		}

	};
	network = new vis.Network(container, data, options);

	// add event listeners
	network.on('select', function(params) {
		document.getElementById('selection').innerHTML = 'Selection: '
				+ params.nodes;
	});

	network.on("resize", function(params) {
		console.log(params.width, params.height)
	});
	
	function clearRelationPopUp() {
		var saveButton = document.getElementById('saveRelateButton');
		var cancelButton = document.getElementById('cancelRelateButton');
		saveButton.onclick = null;
		cancelButton.onclick = null;
		var div = document.getElementById('relation-popUp');
		div.style.display = 'none';

	}

	function clearPopUp() {
		var saveButton = document.getElementById('saveButton');
		var cancelButton = document.getElementById('cancelButton');
		saveButton.onclick = null;
		cancelButton.onclick = null;
		var div = document.getElementById('network-popUp');
		div.style.display = 'none';

	}
	
	function saveRelateData(data, callback) {
		//var x = document.getElementByName("relation");
		var radios = document.getElementsByName('relation');

		for ( var i = 0, length = radios.length; i < length; i++) {
			if (radios[i].checked) {
				data.label = radios[i].value;
				data.action = 'save';
				//data.id = createId++;
				break;
			}
		}

		if (data.from == data.to) {
			var r = confirm("Do you want to connect the node to itself?");
			if (r == true) {
				callback(data);
			}
		} else {
			callback(data);
		}
		
		relateSaveArray.push(data);
		alert(' Saving relation '+ JSON.stringify(relateSaveArray))
		alert('RElation array length '+relateSaveArray);
		var div = document.getElementById('relation-popUp');
		div.style.display = 'none';
	}
	
	
	var createId = 1;
	function saveData(data, callback) {
		var idInput = document.getElementById('node-id');
		var labelInput = document.getElementById('node-label');
		var moonsInput = document.getElementById('node-moons');
		var createdAtInput = document.getElementById('created-at');
		var div = document.getElementById('network-popUp');
		data.id = idInput.value;
		data.label = labelInput.value;
		data.moons = moonsInput.value;
		data.createdAt = createdAtInput.value;
		//alert(data);
		pushDataForSave(data, 'save')

		clearPopUp();
		callback(data);
	}
	
	function pushDataForSave(data, action) {
		if (action == 'save') {
			//data.id = createId++;
			dataSaveArray.push(data);
			//alert('Adding to Save :' + JSON.stringify(dataSaveArray));
		}
		if (action == 'delete') {
			dataDeleteArray.push(data);
			alert('Adding to Delete :' + JSON.stringify(dataDeleteArray));
		}
		if (action == 'update') {
			dataUpdateArray.push(data);
			alert('Adding to Update :' + JSON.stringify(dataUpdateArray));
		}
		alert(' Save :' + dataSaveArray.length + " ... Delete:"
				+ dataDeleteArray.length + " ... Update :"
				+ dataUpdateArray.length);

	}

}

function pushAllDataToServer() {
	alert('saving Nodes: '+dataSaveArray.length)
	alert('saving Edges: '+relateSaveArray.length)
	//alert("nodeDetails="+escape(JSON.stringify(dataSaveArray))+"&edgeDetails="+escape(JSON.stringify(relateSaveArray)))
	$.ajax({
		url : contextPath+"/customer/savepersonjson.htm",
		data : "nodeDetails="+escape(JSON.stringify(dataSaveArray))+"&edgeDetails="+escape(JSON.stringify(relateSaveArray)),
		type : "POST",
		dataType : "json",
		contentType : 'application/json',
		success : function(response) { alert(' AJAX scess '+ response.jsonStrNode); },
		error : function(e) { alert('Error: ' + JSON.stringify(e)); } 
	});
}