[#ftl]
[#import "spring.ftl" as spring]

<!-- just some sample testing of how to display the model returned by HelloController.java -->

<html>
  <head>
    <title>Simple Examples!</title>
  </head>
  <body>
    <h1>[@spring.message "greeting" /]</h1>
    <h3> well .. not a form example quite yet!</h3>
    <p>
        My string object is : ${hello}. <br>
        My boolean object is: 
        [#if checkBool]
        	True.
       	[#else]
        	False.
        [/#if]
      	<br>
      	The message list is: 
      	<ol>
      	[#list mssgs as mssg]
      		<li> ${mssg}[#if mssg_has_next], [#else].[/#if]
      	[/#list]
      	</ol>
      	
      	First mssg is: ${mssgs[0]}. <br>
      	
      	The hash map contains: <br>
      	name: {${info.name}}. <br>
      	[#if info.age < 5]
	      	age: {${info.age}}.
      	[/#if]
    </p>
    <a href="HelloForm.ftl">Simple Form example</p>
    
<!--    
    Thus my model can be shown as:<br>
    root <br>
    .<br>
    ..${hello}<br>
    .<br>
    ..[#if checkBool]True[#else]False[/#if]<br>
    .<br>
    ..mssgs<br>
    [#list mssgs as mssg]<br>
    .....${mssg}<br>
    [/#list]
    -->
  </body>
</html>
