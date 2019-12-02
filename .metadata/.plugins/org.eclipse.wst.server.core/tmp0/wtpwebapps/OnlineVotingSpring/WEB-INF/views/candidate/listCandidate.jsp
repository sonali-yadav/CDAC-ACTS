<%@include file="../voter/header.jsp"%>

<body class="text-center" style="background-color: lightyellow;">
	<div class="main_box">
		<form method="post"
			style="width: 25em; background-color: #fff; height: 23em; margin: 1em auto; border: 1px solid #cacaca; padding: 1em; border-radius: 8px;"
			action="castvote">
			<h1 class="h4 mb-3 font-weight-normal" style="margin-bottom: 2em;">Choose
				Your Candidate</h1>
			<div>
				<c:forEach var="cb"
					items="${requestScope.candidateList}">
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