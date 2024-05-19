<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<h1 style="text-align:center; color:red; font:30px"><b>All Employee Records</b></h1>
<center>
<c:choose>
	<c:when test="${!empty empList}">
		<table border="1" bgcolor="yellow">
			<tr>
				<th>Employee Id</th>		
				<th>Employee Name</th>		
				<th>Employee Job</th>		
				<th>Employee Salary</th>		
				<th>Employee departNo</th>
				<th>Operations</th>		
			</tr>
			<c:forEach var="emp" items="${empList}"  >
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
				<td>${emp.job}</td>
				<td>${emp.sal}</td>
				<td>${emp.deptno}</td>
				<td>&nbsp;
					<a href="update?empno=${emp.empno}" title="Edit Employee Data"><img alt="edit image" src="images/edit.png" width="20px" height="20px"></a>
					&nbsp;&nbsp;&nbsp;
					<a href="delete?empno=${emp.empno}" title="Delete Employee Data" onclick="return confirm(Are you sure to Delete ${empno} Employee Info)"><img alt="delete image" src="images/delete.png" width="20px" height="20px"></a>
				</td>
			</tr>
			</c:forEach>
		</table>
		
	</c:when>
	<c:otherwise>No Employee Data Found</c:otherwise>
</c:choose>
<h2 style="background: green;color:red;">${resultMsg}</h2>
<a href="add" title="Add Employee Data"><img src="images/add.png" alt="add data" width="70px" height="70px"></a>
</center>