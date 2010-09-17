[#ftl]
[#import "spring.ftl" as spring]

[#-- 
	Display data submitted by user in HelloForm.ftl
 The radio button (userInputs.active) parameter is not updated correctly.
--]

<head>
	<title>Post Form Input</title>
	<link rel="stylesheet" type="text/css" href="pages/css/learnspringftl.css" />
</head>

<h1>Display Form Example Data</h1>

<fieldset>
	<legend>User Inputs</legend>
	<ol>
	<li><label>Firstname:</label> ${userInputs.firstname}</li>
	<li><label>Lastname:</label> ${userInputs.lastname}</li> 
	<li><label>IsActive:</label>
		[#if userInputs.active ]
			True
		[#else]
			False
		[/#if]
	</li>
	<li><label>Object ID: </label>${userInputs.id}</li>
	</ol>
</fieldset>