<%@ include file="../common/header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spf"%>
<body style="text-align:center;">
	<div class="jumbotron" style="background-color: #fff">
	<h1>Hire Employee</h1>
		<spf:form method="post" modelAttribute="employee">
		
		<%-- <spf:form method="post" 
		action="<sp:url value='/employee/hire?deptId=${requestScope.deptId}'/>" modelAttribute="employee"> --%>
			
			<table class="table table-bordered">
				<tr>
					<td>Employee Name</td>
					<td><spf:input path="empName" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><spf:input path="email" /></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td><spf:input type="number" path="salary" /></td>
				</tr>
				<tr>
					<td>DOB</td>
					<td><spf:input type="date" path="dob" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
					<input type="hidden" name="deptId" value="${requestScope.deptId}">
					<input type="submit" value="Hire Employee" class="btn btn-primary btn-lg" />
					</td>
				</tr>
			</table>
		</spf:form>
	</div>
</body>