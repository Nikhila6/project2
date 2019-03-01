<!-- 
Freemarker page to display the Student Homepage
@authour Joshua Drumm
@version 1.3
@date 02/22/2019
 -->
<html>
    <head>
        <#include "stylesheet.css">
    </head>
    <body>
        <p>Welcome ${Session.userVO.getFirstname()}!</p>
        <form action="StudentCourseHome" method="GET">
            <select name="CourseId">
                <#list Session.CourseHashMap as courseId, courseName>
                    <option value=${courseId}> ${courseName}</option>
                </#list>
            </select>
            <input type = "submit" value="Submit"/>
        </form>
        <form action="displayGrades" method="GET">
        	<input type="submit" value="View Grades">
        </form>
        <#include "logout.html">
    </body>
</html>