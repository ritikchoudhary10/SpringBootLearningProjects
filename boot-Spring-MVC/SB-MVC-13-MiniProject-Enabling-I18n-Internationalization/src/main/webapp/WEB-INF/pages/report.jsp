<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<h3>Current Language Selected >${pageContext.response.locale.displayLanguage }</h3><br>
<h1 style="text-align:center; color:red; font:30px"><b> <sp:message code="report.main.title"/> </b></h1>
<center>
<c:choose>
	<c:when test="${ empPage.hasContent()}">
		<table border="1" bgcolor="yellow">
			<tr>
				<th><sp:message code="common.empno"/></th>		
				<th><sp:message code="common.ename"/></th>		
				<th><sp:message code="common.job"/></th>		
				<th><sp:message code="common.sal"/></th>		
				<th><sp:message code="common.deptno"/></th>
				<th><sp:message code="common.ops"/></th>		
			</tr>
			<c:forEach var="emp" items="${empPage.getContent()}"  >
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
				<td>${emp.job}</td>
				<td>${emp.sal}</td>
				<td>${emp.deptno}</td>
				<td>&nbsp;
					<a href="update?empno=${emp.empno}" title="Edit Employee Data"><img alt="edit image" src="images/edit.png" width="20px" height="20px"></a>
					&nbsp;&nbsp;&nbsp;
					<a href="delete?empno=${emp.empno}" title="Delete Employee Data" onclick="return confirm('Are you sure to Delete Employee Info')"><img alt="delete image" src="images/delete.png" width="20px" height="20px"></a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<c:if test="${empPage.hasPrevious()}">
			<a href="report?page=${empPage.getNumber()-1 }"><sp:message code="report.table.prev"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
		</c:if>
		<c:forEach var="pageNo" begin="1" end="${empPage.getTotalPages() }" step="1">
			<a href="report?page=${pageNo-1}">${pageNo}&nbsp;&nbsp;&nbsp;&nbsp; </a>
		</c:forEach>
		<c:if test="${empPage.hasNext()}">
			<a href="report?page=${empPage.getNumber()+1 }"><sp:message code="report.table.next"/></a>
		</c:if>
		
	</c:when>
	<c:otherwise>No Employee Data Found</c:otherwise>
</c:choose>
<h2 style="background: green;color:red;">${resultMsg}</h2>
<a href="add" title="Add Employee Data"><img src="images/add.png" alt="add data" width="70px" height="70px"></a>
</center>