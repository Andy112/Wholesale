<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Set in Scope Examples</title>
</head>

<body>
<c:set var="test" value="Page Level Value" scope="page"/>

<c:set var="test" value="Request Level Value"
       scope="request"/>

<c:set var="test" value="Session Level Value"
       scope="session"/>

<c:set var="test" value="Application Level Value"
       scope="application"/>

<table border="1">
    <tr>
        <td>
            <b>Default Level</b>
        </td>

        <td>
            <c:out value="${test}"/>
        </td>
    </tr>
    <tr>
        <td>
            <b>Page Level</b>
        </td>

        <td>
            <c:out value="${pageScope.test}"/>
        </td>
    </tr>

    <tr>
        <td>
            <b>Request Level</b>
        </td>

        <td>
            <c:out value="${requestScope.test}"/>
        </td>
    </tr>

    <tr>
        <td>
            <b>Session Level</b>
        </td>

        <td>
            <c:out value="${sessionScope.test}"/>
        </td>
    </tr>

    <tr>
        <td>
            <b>Application Level</b>
        </td>

        <td>
            <c:out value="${applicationScope.test}"/>
        </td>
    </tr>
</table>
</body>
</html>