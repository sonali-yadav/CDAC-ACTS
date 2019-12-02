<%@include file="header.jsp"%>

<jsp:setProperty property="*" name="candbean" />

<body class="text-center" style="background-color: lightyellow;">
	<div class="main_box">
		<c:if test="${sessionScope.voterbean.adminStatus eq 1}">
			<div style="width: 80%; margin: 2em auto 1em auto; background-color: #fff;border:1px solid #cacaca;padding:0.5em;border-radius: 8px;">
				<div>
					<table class="table table-bordered">
						<tr
							style="background-color: rgba(235, 64, 52, 0.9); color: white;">
							<c:forEach var="cc"
								items="${sessionScope.candbean.topTwoCandidateList}">
								<td><strong>${cc.name} ( ${cc.political_party} ) :
										<span class="badge badge-success h3">${cc.votes}</span>
								</strong></td>
							</c:forEach>
						</tr>
					</table>
				</div>
				<div>
					<table class="table table-bordered" style="margin-bottom: 0;">
						<tbody>
							<tr
								style="background-color: rgba(62, 162, 23, 0.7); color: #fff;">
								<c:forEach var="x"
									items="${sessionScope.candbean.partyWiseAnalysis}">
									<td><strong>${x.key} : <span
											class="badge badge-pill badge-primary h3">${x.value}</span></strong></td>
								</c:forEach>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>
		<div class="main_box"
			style="width: 80%; background-color: #fff;padding: 1em; 
			margin: 2em auto; border: 1px solid #cacaca; padding: 1em; border-radius: 8px;">
			<div class="h3">You have been logged out.</div>
			<div style="margin: 1em auto;">${sessionScope.candbean.castYourVote()}</div>
			<div style="margin-top: 3em;">
				<a href="index.jsp" class="btn btn-lg btn-info" style="width: 10em;">Visit
					Again</a>
			</div>
		</div>
		${pageContext.session.invalidate()}
	</div>
</body>
