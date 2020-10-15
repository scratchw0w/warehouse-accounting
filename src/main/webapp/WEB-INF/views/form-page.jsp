<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>warehouse-accounting</title>
</head>
<body>
    <h1>Item Form Page</h1>

    <form:form action="items" modelAttribute="newItem" method="POST">
        <table>
            <tr>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <tb><form:input path="name" /></tb>
                <tb><form:input path="count" /></tb>
            </tr>
            <tr>
            <td><input type="submit" value="Save"/></td>
            </tr>
        </table>
        
    </form:form>
</body>
</html>