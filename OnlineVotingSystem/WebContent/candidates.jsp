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
		<form method="post"
			style="width: 25em; background-color: #fff; height: 23em; margin: 1em auto; border: 1px solid #cacaca; padding: 1em; border-radius: 8px;"
			method="GET" action="status.jsp">
			<h1 class="h4 mb-3 font-weight-normal" style="margin-bottom: 2em;">Choose
				Your Candidate</h1>
			<div>
				<c:forEach var="cb"
					items="${sessionScope.candbean.generateCandidateList()}">
					<div>
						<input type="radio" value="${cb.id}" name="candid"> <label
							for="candid">${cb.name}, ${cb.political_party}</label>
					</div>
				</c:forEach>
			</div>
			<button class="btn btn-lg btn-success btn-block" type="submit">Vote</button>
			<p class="mt-5 mb-3 text-muted">&copy; CDAC-ACTS</p>
		</form>
	</div>
</body>