
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:setProperty property="*" name="cust" />

<c:redirect url="${sessionScope.cust.validateCustomer()}.jsp" />
