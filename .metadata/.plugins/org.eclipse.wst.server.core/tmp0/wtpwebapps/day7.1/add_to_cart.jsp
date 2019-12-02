
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:setProperty property="*" name="bk" />

	<c:redirect url="${sessionScope.bk.populateCart()}.jsp" />
