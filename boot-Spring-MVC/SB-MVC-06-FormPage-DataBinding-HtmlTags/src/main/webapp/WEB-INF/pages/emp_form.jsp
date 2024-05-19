<%@ page isELIgnored="false" %>

<h1 style="text-align:center;color:red;">Welcome to Employee Form</h1><br><br><br>

<form action="showEmp" method="post">
	
	<table align="center" bgcolor="cyan">
		<tr>
			<td>EmpNo::</td>
			<td><input type="number" name="eId"></td>
		</tr>
		<tr>
			<td>EmpName::</td>
			<td><input type="text" name="eName"></td>
		</tr>
		<tr>
			<td>Designation::</td>
			<td><input type="text" name="desgn"></td>
		</tr>
		<tr>
			<td>Salary::</td>
			<td><input type="number" name="sal"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Show details"></td>
			<td><input type="reset" value="Reset"></td>
		</tr>
	</table>



</form>
