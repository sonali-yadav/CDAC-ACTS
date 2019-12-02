<%@ include file="../common/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spf"%>

<body style="text-align: center;">
	<div class="jumbotron" style="background-color: #fff">
		<h1>Departments</h1>
		<spf:form method="post" modelAttribute="department">
			<table class="table table-bordered" align="center">
				<c:forEach var="m" items="${requestScope.departmentList}">
					<tr>
						<td><a href='<sp:url value="/employee/hire?deptid=${m.id}"/>'>${m.deptName}</a></td>
						<td>${m.location}</td>
						<td>${m.strength}</td>
					</tr>
				</c:forEach>
			</table>
		</spf:form>
		<h3>${requestScope.msg}</h3>
	</div>
</body>
