<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<script src="../script/Chart.js"></script>
<script src="../script/dashboard.js"></script>
</head>
<body>
	<label id="head"> Data Representation - Bar </label>
	<input type="button" value="Line Chart"
		onclick="changeChartType('Line')" />
	<input type="button" value="Bar Chart" onclick="changeChartType('Bar')" />
	<input type="button" value="Radar Chart"
		onclick="changeChartType('Radar')" />


	<table id="basetable">
	</table>

	
	

	<c:forEach items="${jsonLinear}" var="item" varStatus="id">
		<script>
			buildChart(${id.index},${item});
		</script>
	</c:forEach>

</body>
</html>