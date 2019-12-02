<%@include file="header.jsp"%>

<body class="text-center" style="background-color: lightyellow;">
	<div class="main_box">
		<div class="main_box"
			style="width: 80%; background-color: #fff;padding: 1em; 
			margin: 2em auto; border: 1px solid #cacaca; padding: 1em; border-radius: 8px;">
			<div class="h3">You have been logged out.</div>
			<div style="margin: 1em auto;">${requestScope.status}</div>
			<div style="margin-top: 3em;">
				<a href="voter/goback" class="btn btn-lg btn-info" style="width: 10em;">Visit
					Again</a>
			</div>
		</div>
		<%-- ${pageContext.session.invalidate()} --%>
	</div>
</body>