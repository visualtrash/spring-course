<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

    <title>Student Registration Form</title>

</head>

<body>

<form:form action="processForm" modelAttribute="student">

    First name: <form:input path="firstName"/>

    <br><br>

    Last name: <form:input path="lastName"/>

    <br><br>

    Country:

    <form:select path="country">
        <form:options items="${student.countryOptions}"/>

    </form:select>

    <br><br>

    Favorite Language:

    Java <form:radiobutton path="favoriteLanguage" value="Java"/>
    PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
    Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
    C++ <form:radiobutton path="favoriteLanguage" value="C++"/>

    <br><br>

    OS:

    Linux <form:checkbox path="operationSystem" value="Linux"/>
    Windows <form:checkbox path="operationSystem" value="Windows"/>
    MacOS <form:checkbox path="operationSystem" value="MacOS"/>

    <br><br>

    <input type="submit" value="Submit"/>

</form:form>

</body>

</html>