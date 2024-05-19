<%@ page isELIgnored="false"%>
<h1 style="text-align: center; color: red">
	WELCOME TO HOME PAGE FOR @REQUESTPARAM <b>(QUERY STRING)</b>
</h1>

<br>
<br>
<br>
<ol>
	<li><h3 style="color: blue;">
			<a style="text-decoration: none;" href="oneparam?sno=101">http://localhost:4041/SB-MVC-08/<b><u>param?sno=101</u></b></a>
		</h3>
	</li>
	<li><h3 style="color: blue; text-decoration: none;">
			<a style="text-decoration: none;" href="twoparam?sno=101&sname=Ritik">http://localhost:4041/SB-MVC-08/<b><u>param?sno=101&sname=Ritik</u></b></a>
		</h3>
	</li>
	<li><h3 style="color: blue; text-decoration: none;">
			<a style="text-decoration: none;" href="listparam?sno=101&sname=Ritik&sadd=kgn&sadd=bpl&sadd=delhi&sadd=hyd">http://localhost:4041/SB-MVC-08/<b><u>param?sno=101&sname=Ritik&sadd=kgn&sadd=bpl&sadd=delhi&sadd=hyd</u></b></a>
		</h3>
	</li>
	<li><h3 style="color: blue; text-decoration: none;">
			<a style="text-decoration: none;" href="colparam?sadd=kgn&sadd=bpl&sadd=delhi&sadd=hyd">http://localhost:4041/SB-MVC-08/<b><u>param?sadd=kgn&sadd=bpl&sadd=delhi&sadd=hyd</u></b></a>
		</h3>
	</li>
	<li><h3 style="color: blue; text-decoration: none;">
			<a style="text-decoration: none;" href="novalue1?sno=&sname=ritik">http://localhost:4041/SB-MVC-08/<b><u>novalue?sno=&sname=ritik</u></b></a>
		</h3>
	</li>
	<li><h3 style="color: blue; text-decoration: none;">
			<a style="text-decoration: none;" href="novalue2?&sname=ritik">http://localhost:4041/SB-MVC-08/<b><u>novalue?&sname=ritik</u></b></a>
		</h3>
	</li>
	<li><h3 style="color: blue; text-decoration: none;">
			<a style="text-decoration: none;" href="exception?sno=101f&sname=ritik">http://localhost:4041/SB-MVC-08/<b><u>exception?sno=101f&sname=ritik</u>--> give exception{org.springframework.web.method.annotation.MethodArgumentTypeMismatchException} since the request param type doesnt maytches to its datatype</b></a>
		</h3>
	</li>
</ol>