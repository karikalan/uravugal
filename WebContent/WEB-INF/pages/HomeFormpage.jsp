<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
		alert('Page loading....')
		contextPath =  "<%=request.getContextPath()%>
	";
		alert('Context ' + contextPath);
	});
</script>
</head>

<body>

	<table>
		<tr>
			<td><div id="network-popUp">
					<form:form method="POST" commandName="customerForm">
						<form:errors path="*" cssClass="errorblock" element="div" />
						<span id="operation">node</span>
						<br>
						<table style="margin: auto;">
							<tr>
								<td>id</td>
								<td><input id="node-id" value="new value"></td>
								<td><form:input path="node-id" /></td>
								<td><form:errors path="node-id" cssClass="error" /></td>
							</tr>
							<tr>
								<td>label</td>
								<td><input id="node-label" value="new value">
								</td>
								<td><form:input path="node-label" /></td>
								<td><form:errors path="node-label" cssClass="error" /></td>
							</tr>
							<tr>
								<td>Moons</td>
								<td><input id="node-moons" value="new value">
								</td>
								<td><form:input path="node-moons" /></td>
								<td><form:errors path="node-moons" cssClass="error" /></td>
							</tr>
						</table>
						<input type="button" value="save" id="saveButton">
						</button>
						<input type="button" value="cancel" id="cancelButton">
						</button>
					</form:form>
				</div> <br />
				<div id="mynetwork"></div>

				<p id="selection"></p> ${jsonData.jsonStrNode} <br />
				${jsonData.jsonStrEdge} <script>
					var a = ${jsonData.jsonStrNode};
					var b = ${jsonData.jsonStrEdge};
					alert(a + b);
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