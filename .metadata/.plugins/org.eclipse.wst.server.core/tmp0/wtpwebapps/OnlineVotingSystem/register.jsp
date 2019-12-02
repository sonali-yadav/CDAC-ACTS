
<%@include file="header.jsp"%>

<body class="text-center" style="background-color: #2B7DE9;">
	<div class="main_box">
		<form method="post"
			style="width: 25em; background-color: #fff; height: 23em; margin: 10em auto; border: 1px solid #cacaca; padding: 1em; border-radius: 8px;"
			method="GET" action="reg_voter.jsp">
			<h1 class="h4 mb-3 font-weight-normal" style="margin-bottom: 2em;">Welcome
				To Online Voting System</h1>
			<h1 class="h3 mb-3 font-weight-normal">Sign Up</h1>
			<label for="email" class="sr-only">Email address</label> <input
				style="margin: 1em 0;" type="email" id="email"
				class="form-control" placeholder="Email address" name="email"
				required autofocus> <label for="password"
				class="sr-only">Password</label> <input style="margin: 1em 0;"
				type="password" id="password" class="form-control"
				placeholder="Password" name="password" required>
				<label for="name" class="sr-only">Name</label> <input
				style="margin: 1em 0;" type="text" id="name"
				class="form-control" placeholder="Name" name="name" required> 
			<button class="btn btn-lg btn-success btn-block" type="submit">Sign
				Up</button>
			<p class="mt-5 mb-3 text-muted">&copy; CDAC-ACTS</p>
		</form>
	</div>
</body>