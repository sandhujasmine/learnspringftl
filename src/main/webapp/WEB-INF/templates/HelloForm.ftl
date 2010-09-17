[#ftl]
[#import "spring.ftl" as spring]

[#-- 
 	A simple form in Freemarker, maps to HelloFormController
 Binds data to the HelloForm object.
 
 The HelloFormController returns the data backed object (HelloForm) as a ModelAttribute. 
 This is not using the builtin spring macros @spring.formRadioButton -- would like to figure
 out and implement that. The binding to the radio button is not working correctly right now.
 
 There are also existing spring macros like: @spring.formSingleSelect, @spring.formMultiSelect,
 @spring.formInput. Haven't yet figured out how to use these correctly.
--]

<head>
	<title>Form Example</title>
	<link rel="stylesheet" type="text/css" href="pages/css/learnspringftl.css" />
</head>

<h1>Form Example</h1>
<form action="PostHelloForm.ftl" method = "POST">
<fieldset>
<legend>Edit HelloForm Object</legend>
	<ol>
	<li>
	[@spring.bind "helloForm.firstname" /]
	<label for="first"><span class="red">* </span>First Name:</label> 
	<input id="first" type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" /><br>
  	[#list spring.status.errorMessages as error] <b>${error}</b> <br> [/#list]
	</li>
	
	<li>
	[@spring.bind "helloForm.lastname" /]
	<label for="last"><span class="red">* </span>Last Name:</label>
	<input id="last" type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" /><br>
  	[#list spring.status.errorMessages as error] <b>${error}</b> <br> [/#list]
  	</li>
  	
  	[#-- 
  		Binding helloForm.active to the radio buttons is not working correctly.
  	--]
  	<li>
  	[@spring.bind "helloForm.active" /]
	<label for="active">Active: </label>
	[#if helloForm.active]
		<input id="active" type="radio" name="${spring.status.expression}" checked />
	[#else]
		<input id="active" type="radio" name="${spring.status.expression}" />
	[/#if]
	</li>		
	<li>
	<label for="inactive">Inactive: </label>
	[#if helloForm.active]
		<input id="inactive" type="radio" name="${spring.status.expression}" />
	[#else]
		<input id="inactive" type="radio" name="${spring.status.expression}" checked/>
	[/#if]
	
  	[#list spring.status.errorMessages as error] <b>${error}</b> <br> [/#list]
  	</li>
  	
  	<li>
	[@spring.bind "helloForm.id" /]
	<label for="id"><span class="red">* </span>ID:</label>
	<input id="id" type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" /><br>
  	[#list spring.status.errorMessages as error] <b>${error}</b> <br> [/#list]
  	</li>
  	
  	</ol>
  	
</fieldset>	

[#-- Submit data and invoke PostHelloForm.ftl --]
<fieldset class="submit">
	<input type="submit" value="Submit" />
</fieldset>
</form>