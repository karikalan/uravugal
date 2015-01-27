<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Network | Data Manipulation</title>
<link rel="stylesheet" type="text/css"
	href="../styles/vis-page-style.css">
<link type="text/css" rel="stylesheet" href="../styles/vis/vis.css">
<script type="text/javascript" src="../script/vis/vis.js"></script>
<script type="text/javascript"
	src="../script/graph/graphpopulate-vis.js"></script>

<script type="text/javascript"
	src="../script/jquery-ui-1.11.2.custom/jquery-1.11.2.min.js"></script>

<script type="text/javascript" language="javascript">
	var contextPath = null;

	$(document).ready(function() {
		/* alert('Page loading....') */
		contextPath =  "<%=request.getContextPath()%>";
		//alert('Context ' + contextPath);
	});
</script>
</head>

<body>

	<table>
		<tr>
			<td><div id="network-popUp">
					<span id="operation">node</span> <br>
					<table style="margin: auto;">
						<tr>
							<td>id</td>
							<td><input id="node-id" value="new value"></td>
						</tr>
						<tr>
							<td>createdAt</td>
							<td><input id="created-at" value="new value"></td>
						</tr>
						<tr>
							<td>label</td>
							<td><input id="node-label" value="new value">
							</td>
						</tr>
						<tr>
							<td>Moons</td>
							<td><input id="node-moons" value="new value">
							</td>
						</tr>
					</table>
					<input type="button" value="save" id="saveButton">
					</button>
					<input type="button" value="cancel" id="cancelButton">
					</button>
				</div> <br />
				<div id="relation-popUp">
					<span id="RelationNext">Choose Relation</span> <br> <input
						type="radio" name="relation" value="Father" checked>Father</input>
					<input type="radio" name="relation" value="Mother" id="myselect">Mother</input>
					<input type="radio" name="relation" value="sister">sister</input> <input
						type="radio" name="relation" value="Brother">Brother</input> <input
						type="radio" name="relation" value="Spouse">Spouse</input> <input
						type="button" value="save" id="saveRelateButton">
					</button>
					<input type="button" value="cancel" id="cancelRelateButton">
					</button>
				</div> <br />

				<div id="mynetwork"></div>

				<p id="selection"></p> ${jsonData.jsonStrNode} <br />
				${jsonData.jsonStrEdge} <script>
					var a = ${jsonData.jsonStrNode};
					var b = ${jsonData.jsonStrEdge};
					/* alert(a + b); */
					draw(a, b);
				</script>
			</td>
		</tr>
		<tr>
			<td><input id="submitBtn" type="button" value="Save all changes"
				onclick="pushAllDataToServer()" /></td>
		</tr>
	</table>

</body>
</html>