<%@include file="../common/header.jsp"%>

<body>
<nav class="navbar navbar-light" style="background-color: #0A2634;">
  <h1 class="h2" style="color:white;margin-bottom:0;">Mr. PojoJojo's Bank</h1>
</nav>
	<div class="text-center">
	<div>${sessionScope.voterbean.loginMsg}</div>
		<form method="post"
			style="width: 25em;height:30em; background-color: #fff; margin: 2em; 
			padding: 1em;border: 1px solid #cacaca; border-radius: 8px;">
			<h1 class="h3 mb-3 font-weight-normal">Log In</h1>
			<label for="email" class="sr-only">Email address</label> <input
				style="margin: 1em 0;" type="email" id="email"
				class="form-control" placeholder="Email address" name="email"
				required autofocus> <label for="password"
				class="sr-only">Password</label> <input style="margin: 1em 0;"
				type="password" id="password" class="form-control"
				placeholder="Password" name="password" required>
			<button class="btn btn-lg btn-block" type="submit" 
			style="background-color: #0A2634;color:#fff;">Sign
				in</button>
			<p class="mt-5 mb-3 text-muted">Not a member yet?</p>
			<button class="btn btn-lg btn-success btn-block" type="submit"
				formaction="register.jsp">Sign Up</button>
			<p class="mt-5 mb-3 text-muted">&copy; CDAC-ACTS</p>
		</form>
	</div>
</body>